package org.philips.solid.app.model;

public class ElectricVehicle extends Vehicle implements CarBehavior {

    @Override
    public void recharge() {
        System.out.println("Recharging gas...");
    }

    @Override
    public void refillGas() {
        throw new UnsupportedOperationException("Electric cars don't refill gas.");
    }   

}
