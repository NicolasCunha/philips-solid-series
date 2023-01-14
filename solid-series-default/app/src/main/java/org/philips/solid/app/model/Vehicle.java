package org.philips.solid.app.model;

public class Vehicle implements CarBehavior {

    private long id;
    private String color;
    private Double price;
    private Brand brand;
    private Model model;

    public Vehicle(long id, String color, Double price, Brand brand, Model model) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void refillGas() {
        System.out.println("Refilling gas...");
    }

    @Override
    public void recharge() {
        throw new UnsupportedOperationException("Combustion cars don't recharge.");
    }

}
