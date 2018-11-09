package ru.trainee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trainee.DAO.InputDAO;
import ru.trainee.model.Input;

import java.util.List;

@Controller
public class MainController{

        @Autowired
        private InputDAO inputDAO;

        @RequestMapping("/")
        public String hello() {
                return "index";
        }

        @RequestMapping(value="/get-inputs", method = RequestMethod.GET)
        public String greetingSubmit(Model model) {

                List<Input> list = inputDAO.getInputs();
                model.addAttribute("inputs", list);

                return "result";
        }

}