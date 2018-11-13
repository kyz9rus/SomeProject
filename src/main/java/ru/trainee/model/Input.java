package ru.trainee.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double temperature, x, y;

    public Input(){}

    public Input(long id, double temperature, double x, double y){
        this.id = id;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }

    public Input(double temperature, double x, double y){
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }
}
