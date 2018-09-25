package mangomax.demo.controller;

import mangomax.demo.repository.IDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}