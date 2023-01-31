package org.philips.solid.app.model;

public class HybridVehicle extends Vehicle {

    public HybridVehicle(long id, String color, Double price, Brand brand, Model model) {
        super(id, color, price, brand, model);
    }

    @Override
    public void recharge() {
        System.out.println("Recharging...");
    }

    @Override
    public void refillGas() {
        System.out.println("Refilling gas...");
    }

}
