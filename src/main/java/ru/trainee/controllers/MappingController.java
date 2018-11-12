package ru.trainee.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static ru.trainee.controllers.MainController.setGreeting;

@Controller
public class MappingController {

    @PreAuthorize("hasAnyRole('SENSOR')")
    @RequestMapping("/sensorPage")
    public String toSensorPage(Model model) {
        setGreeting(model);
        return "sensorPage";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/userPage")
    public String toUserPage(Model model) {
        setGreeting(model);
        return "userPage";
    }
}
