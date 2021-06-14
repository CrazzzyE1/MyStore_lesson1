package com.litvak.mystore_lesson1.controllers;

import com.litvak.mystore_lesson1.aspect.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logging")
    public String logging(Model model) {
        model.addAttribute("logging", Logger.loggerInfo);
        return "logging";
    }

    @RequestMapping("/login-error") // чтобы пользователь попал на 404-page
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
