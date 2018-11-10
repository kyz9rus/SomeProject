package ru.trainee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trainee.Repository.InputRepository;
import ru.trainee.model.Input;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController{
        @Autowired
        private InputRepository inputRepository;

        @RequestMapping("/")
        public String hello() {
                return "index";
        }

        @RequestMapping(value="/get-inputs", method = RequestMethod.GET)
        public String greetingSubmit(Model model) {

                List<Input> inputs = (List<Input>) inputRepository.findAll();
                inputs = inputs
                        .stream()
                        .skip(inputs.size()-10)                                    // for mappings only last 10 inputs
                        .collect(Collectors.toList());

                model.addAttribute("inputs", inputs);

                return "result";
        }
}