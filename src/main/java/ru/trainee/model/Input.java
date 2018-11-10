package ru.trainee.model;

import javax.persistence.*;

@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double temperature, x, y;

    public Input() {
    }

    public Input(Long id, Double temperature, Double x, Double y) {
        this.id = id;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return id + " (" + String.format("%.2f", x) + "; " + String.format("%.2f", y) + ") " + temperature;
    }
}