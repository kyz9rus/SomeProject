package ru.trainee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MappingController {
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/sensorPage")
    public String toSensorPage() {
        return "sensorPage";
    }

    @RequestMapping("/userPage")
    public String toUserPage() {
        return "userPage";
    }
}
