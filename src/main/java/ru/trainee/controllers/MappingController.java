package ru.trainee.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MappingController {

    @RequestMapping("/loginPage")
    public String toLogin() {
        return "loginPage";
    }

    @PreAuthorize("hasAnyRole('SENSOR')")
    @RequestMapping("/sensorPage")
    public String toSensorPage() {
        return "sensorPage";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/userPage")
    public String toUserPage() {
        return "userPage";
    }
}
