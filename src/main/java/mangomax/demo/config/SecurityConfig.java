package mangomax.demo.config;

import mangomax.demo.web.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST, "/admin/addMovieToDate");
        web.ignoring().antMatchers(HttpMethod.POST, "/admin/addMovie");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**",
                        // TODO: ændre til 1 x "*" herunder
                        "/**").permitAll()
                .antMatchers("/customer/**").hasRole("CUSTOMER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/redirect")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // password = $2a$10$GkHRhh4AHWS.WHUzRucUIeBoEmowH7qZ2HLVas544VbXFscstpEE6
        // TODO: Ret SQL
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select user_email, role_name FROM user INNER JOIN role ON role.role_id = user.userRole_fk WHERE user_email=?")
                .usersByUsernameQuery("SELECT user_email, user_password as password,1 FROM user WHERE user_email=?")
                .passwordEncoder(passEncoder());

    }

    @Bean
    public PasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }
}