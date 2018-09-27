package mangomax.demo.controller;

import mangomax.demo.repository.IDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    IDbRepository connection;

    @GetMapping("/")
    public String index (){
        System.out.println(connection.test());
        return "index";
    }

    @GetMapping("/all-movies")
    public String readAllMovies(Model model){
        model.addAttribute("movie_data",connection.getAllMovies());
        return "all-movies";
    }


}