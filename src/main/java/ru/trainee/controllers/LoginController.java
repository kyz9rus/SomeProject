package ru.trainee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/loginUser")
    public String loginUser(Model model) {

        return "index";
    }

    @RequestMapping("/loginSensor")
    public String loginSensor(Model model) {

        return "index";
    }
}
