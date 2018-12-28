package ru.trainee.model;

import lombok.Data;

/**
 * This class was created to display inputs on user page.
 * Here is a new field city.
 */
@Data
public class InputView {
    private long id;
    private double temperature, x, y;
    private String city;

    public InputView() {
    }

    public InputView(long id, double temperature, double x, double y) {
        this.id = id;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }
}
