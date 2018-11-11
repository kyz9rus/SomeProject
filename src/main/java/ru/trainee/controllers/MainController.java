package ru.trainee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trainee.model.Input;
import ru.trainee.repository.InputRepository;
import ru.trainee.templatesForValidation.InputValid;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import ru.trainee.templatesForValidation.InputValid;

@Controller
public class MainController{
        @Autowired
        private InputRepository inputRepository;

        @RequestMapping("/")
        public String hello() {
                return "index";
        }

        @RequestMapping(value="/get-inputs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public String getInputs(Model model) {

                List<Input> inputs = inputRepository.findAll();
                inputs = inputs
                        .stream()
                        .skip(inputs.size()-10)                                    // for mappings only last 10 input2s
                        .collect(Collectors.toList());

                model.addAttribute("inputs", inputs);

                return "result";
        }

        @RequestMapping(value="/saveInput", method = RequestMethod.POST)
        public String saveInput(@Valid InputValid inputValid, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                List<String> messages = new ArrayList<>();

                for (ObjectError error : bindingResult.getAllErrors() )
                    messages.add(error.getDefaultMessage());

                model.addAttribute("errorMessages", messages);

                return "sensorPage";
            }

            Input input = new Input(inputValid.getId(), inputValid.getDoubleTemperature(), inputValid.getDoubleX(), inputValid.getDoubleY());

            inputRepository.save(input);

            model.addAttribute("successMessage", "Data successfully saved");

            return "sensorPage";
        }
}