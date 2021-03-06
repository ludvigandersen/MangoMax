package mangomax.demo.controller;

import mangomax.demo.model.Reservation;
import mangomax.demo.model.User;

import mangomax.demo.model.Cinema;
import mangomax.demo.model.Movie;


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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    IDbRepository connection;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String index (){
        return "redirect:/all-movies";
    }

    @GetMapping("/customer/reserve-movies")
    public String reserveMovies(@RequestParam("id") int id, Model model) {
        model.addAttribute("movie", connection.getMovieById(id));
        return "/customer/reserve-movies";
    }

    @PostMapping("/customer/create-reservation-post")
    public String reserveMovies(@ModelAttribute Reservation reservation){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        //TODO: skal tage fat i ID og ikke navn
        connection.createReservation(reservation);

        return "/customer/reserve-movies";
    }

    @GetMapping("/all-movies")
    public String readAllMovies(Model model){
        model.addAttribute("movie_data",connection.getMoviesOneWeekFromNow());
        return "/all-movies";
    }

    @GetMapping("/details")
    public String details (@RequestParam("id") int id, Model model){
        model.addAttribute("movie", connection.getMovieById(id));
        model.addAttribute("id", id);
        return "/details";
    }

    @GetMapping("/customer/myreservations")
    public String myReservations(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user;
        if (!name.equals("anonymousUser")) {
            user = connection.getUserByEmail(name);
            model.addAttribute("reservations",connection.getAllUserReservations(user.getUserId()));
            return "/customer/myreservations";
        }
        return "redirect:/login";
    }

    @GetMapping("/admin/admin-dashboard")
    public String adminDashboard(Model model){
        model.addAttribute("movie_data",connection.getMoviesOneWeekFromNow());
        return "/admin/admin-dashboard";
    }

    @GetMapping("/admin/deletemovie")
    public String deletemovie(@RequestParam("id") int id){
        connection.deleteMovieDate(id);
        return "redirect:/admin/admin-dashboard";
    }

    @GetMapping("/admin/addexistingmovietodate")
    public String addExistingMovieToDate(Model model){
        model.addAttribute("movies", connection.getAllMovies());
        return "/admin/add-existing-movie-to-date";
    }

    @PostMapping("/admin/addMovieToDate")
    public String addMovieToDate(@RequestParam("movieId") int movieId,
                                 @RequestParam("date") String date){
        System.out.println(date);
        SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date1 = new Date();
        try {
            date1 = dateformat3.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        connection.addMovieToDate(movieId, date1);
        return "redirect:/admin/admin-dashboard";
    }

    @GetMapping("/admin/addNewMovie")
    public String addNewMovie(Model model){
        model.addAttribute("cinemas", connection.getAllCinemas());
        return "/admin/admin-add-movie";
    }

    @PostMapping("/admin/addMovie")
    public String addMovie(@RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("price") String price,
                           @RequestParam("age") String age,
                           @RequestParam("cinema") int cinema){
        Movie movie = new Movie(name, description, Integer.parseInt(price), Integer.parseInt(age), new Cinema(cinema, "", 0));
        connection.createMovie(movie);
        return "redirect:/admin/admin-dashboard";
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