package com.edu.webappstuddb_v4.controllers;

import com.edu.webappstuddb_v4.models.User;
import org.springframework.ui.Model;
import com.edu.webappstuddb_v4.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model ) {
        if (!userService.createUser(user)){
            model.addAttribute("errorMessage", "Користувач з мейлом:" + user.getEmail() +"вже зареестрований");
            return "registration";
        }
        return "redirect:/login";
    }

}
