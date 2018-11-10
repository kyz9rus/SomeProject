package ru.trainee.model;

import javax.persistence.*;

@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double temperature, x, y;

    public Input() {
    }

    public Input(Long id, double temperature, double x, double y) {
        this.id = id;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return id + " (" + String.format("%.2f", x) + "; " + String.format("%.2f", y) + ") " + temperature;
    }
}