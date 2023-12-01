package com.edu.webappstuddb_v4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {
    @GetMapping("/")
    public String startpage(){
        return "startpage";
    }
}
