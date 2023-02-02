package org.philips.solid.app.model;

public class ElectricVehicle extends Vehicle implements ElectricEngine {

    public ElectricVehicle(long id, String color, Double price, Brand brand, Model model) {
        super(id, color, price, brand, model);
    }

    @Override
    public void recharge() {
        System.out.println("Recharging gas...");
    }

}
