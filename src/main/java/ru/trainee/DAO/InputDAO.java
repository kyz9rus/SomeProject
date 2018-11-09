package ru.trainee.DAO;

import org.springframework.stereotype.Repository;
import ru.trainee.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InputDAO {

    public List<Input> getInputs(){
        List<Input> listofInputs = new ArrayList<>();

        // Logic for get values from db and add to our list

        listofInputs.add(new Input(new Temperature(36.6d), new Location(10.2, 20.1)));
        listofInputs.add(new Input(new Temperature(36.6d), new Location(10.2, 20.1)));
        listofInputs.add(new Input(new Temperature(36.6d), new Location(10.2, 20.1)));
        listofInputs.add(new Input(new Temperature(36.6d), new Location(10.2, 20.1)));

        return listofInputs;
    }

}
