package ru.trainee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trainee.model.Input;
import ru.trainee.repository.InputRepository;
import ru.trainee.templatesForValidation.InputValid;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController{
        @Autowired
        private InputRepository inputRepository;

        public static void setGreeting(Model model){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (!authentication.getName().equals("anonymousUser"))
                model.addAttribute("greeting", "Hello, " + authentication.getName() + "!");
        }

        @RequestMapping("/")
        public String hello(Model model) {
            setGreeting(model);
            return "index";
        }

        @PreAuthorize("hasAnyRole('USER')")
        @RequestMapping(value="/get-inputs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public String getInputs(Model model) {
            setGreeting(model);

                List<Input> inputs = inputRepository.findAll();
                inputs = inputs
                        .stream()
                        .skip(inputs.size()-10)                                    // for mappings only last 10 input2s
                        .collect(Collectors.toList());

                model.addAttribute("inputs", inputs);

                return "result";
        }

        @PreAuthorize("hasAnyRole('SENSOR')")
        @RequestMapping(value="/saveInput", method = RequestMethod.POST)
        public String saveInput(@Valid InputValid inputValid, BindingResult bindingResult, Model model) {
            setGreeting(model);
            if (bindingResult.hasErrors()) {
                List<String> messages = new ArrayList<>();

                for (ObjectError error : bindingResult.getAllErrors() )
                    messages.add(error.getDefaultMessage());

                model.addAttribute("errorMessages", messages);

                return "sensorPage";
            }

            Input input = new Input(inputValid.getDoubleTemperature(), inputValid.getDoubleX(), inputValid.getDoubleY());

            inputRepository.save(input);

            model.addAttribute("successMessage", "Data successfully saved");

            return "sensorPage";
        }
}