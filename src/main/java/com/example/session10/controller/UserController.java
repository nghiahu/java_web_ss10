package com.example.session10.controller;

import com.example.session10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("userForm")
    public String user(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("user-sub")
    public String submitForm(@ModelAttribute ("user" ) User user, Model model){
        model.addAttribute("user", user);
        return "userResult";
    }
}
