package org.philips.solid.app.model;

public class Model {

    private long id;
    private String name;
    private boolean automatic;
    private boolean combustion;
    private Brand brand;

    public Model(long id, String name, boolean automatic, boolean combustion, Brand brand) {
        this.id = id;
        this.name = name;
        this.automatic = automatic;
        this.combustion = combustion;
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public boolean isCombustion() {
        return combustion;
    }

    public void setCombustion(boolean combustion) {
        this.combustion = combustion;
    }

}
