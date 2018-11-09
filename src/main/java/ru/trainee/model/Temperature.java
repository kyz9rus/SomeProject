package ru.trainee.model;

public class Temperature {
    private double temperature;

    public Temperature(double temperature){
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("%.2f", temperature);
    }
}
