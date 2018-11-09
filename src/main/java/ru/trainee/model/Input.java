package ru.trainee.model;

public class Input {
    private Temperature temperature;
    private Location location;

    public Input(Temperature temperature, Location location){
        this.temperature = temperature;
        this.location = location;
    }

    public String getTemperature() {
        return temperature.toString();
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location.toString();
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}