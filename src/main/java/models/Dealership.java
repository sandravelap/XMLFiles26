package models;

import java.util.ArrayList;

public class Dealership {
    private ArrayList<Car> cars;

    public Dealership() {
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
