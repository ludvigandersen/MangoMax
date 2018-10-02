package mangomax.demo.controller;

import mangomax.demo.model.Movie;
import mangomax.demo.repository.IDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IDbRepository connection;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String index (){
        return "redirect:/all-movies";
    }

    @GetMapping("/reservation")
    public String reservation (@RequestParam("id") int id, Model model){
        model.addAttribute("movie", connection.getMovieById(id)) ;
        return "reservation";
    }

    @GetMapping("/all-movies")
    public String readAllMovies(Model model){
        model.addAttribute("movie_data",connection.getMoviesOneWeekFromNow());
        return "all-movies";
    }

    @GetMapping("/reserve-movies")
    public String reserveMovies(){

        return "reserve-movies";
    }

    @GetMapping("/details")
    public String details (@RequestParam("id") int id, Model model){
        model.addAttribute("movie", connection.getMovieById(id)) ;
        return "details";
    }

    @GetMapping("/customer/myreservations")
    public String myReservations(){
        return "/customer/myreservations";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/redirect")
    public String redirect(HttpServletRequest request){
        if (request.isUserInRole("CUSTOMER")){
            System.out.println("logged in");
            return "redirect:/customer/myreservations";
        }
        return "/login";
    }
}