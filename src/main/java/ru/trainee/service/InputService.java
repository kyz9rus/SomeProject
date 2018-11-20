package ru.trainee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trainee.model.Input;
import ru.trainee.repository.InputRepository;

import java.util.List;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    public void saveInput(Input input){
        inputRepository.save(input);
    }

    public List<Input> getAllInputs(){
        return inputRepository.findAll();
    }
}
