package ru.trainee.model;

import lombok.Data;

@Data
public class InputView {
    private long id;
    private double temperature, x, y;
    private String city;

    public InputView(){}

    public InputView(long id, double temperature, double x, double y){
        this.id = id;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }
}
