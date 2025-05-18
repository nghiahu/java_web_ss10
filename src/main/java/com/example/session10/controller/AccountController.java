package com.example.session10.controller;

import com.example.session10.model.Account;
import com.example.session10.service.account.AccountSeviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountSeviceImp accountSeviceImp;

    @GetMapping("registerForm")
    public String registerForm(Model model) {
        model.addAttribute("account", new Account());
        return "registerForm";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("account") Account account, Model model) {
        accountSeviceImp.addProduct(account);
        return "registerConfirm";
    }
}
