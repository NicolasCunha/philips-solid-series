package org.philips.solid.app.model;

public class CombustionVehicle extends Vehicle implements CombustionEngine {

    public CombustionVehicle(long id, String color, Double price, Brand brand, Model model) {
        super(id, color, price, brand, model);
    }

    @Override
    public void refillGas() {
        System.out.println("Refilling gas...");
    }
    
    

}
