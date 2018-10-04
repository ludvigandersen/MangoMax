package mangomax.demo.controller;

import mangomax.demo.model.Reservation;
import mangomax.demo.repository.IDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Security;

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
        return "/reservation";
    }

    @PostMapping("/create-reservation-post")
    public String createReservation(@ModelAttribute Reservation reservation){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        //TODO: skal tage fat i ID og ikke navn
        connection.createReservation(reservation);

        return "redirect/customer/myreservations";
    }

    @GetMapping("/all-movies")
    public String readAllMovies(Model model){
        model.addAttribute("movie_data",connection.getMoviesOneWeekFromNow());
        return "/all-movies";
    }

    @GetMapping("/reserve-movies")
    public String reserveMovies(@RequestParam("id") int id, Model model) {
        model.addAttribute("movie", connection.getMovieById(id));
        return "reserve-movies";
    }

    @GetMapping("/details")
    public String details (@RequestParam("id") int id, Model model){
        model.addAttribute("movie", connection.getMovieById(id)) ;
        return "/details";
    }

    @GetMapping("/customer/myreservations")
    public String myReservations(){
        return "/customer/myreservations";
    }

    @GetMapping("/admin/admin-dashboard")
    public String adminDashboard(){
        return "/admin/admin-dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/redirect")
    public String redirect(HttpServletRequest request){
        if (request.isUserInRole("CUSTOMER")){
            return "redirect:/customer/myreservations";
        }
        if (request.isUserInRole("ADMIN")){
            System.out.println("admin");
            return "redirect:/admin/admin-dashboard";
        }
        return "/login";
    }
}