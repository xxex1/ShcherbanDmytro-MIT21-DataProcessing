package com.example.model;

public class Smartphone {
    private int id;
    private String name;
    private String brand;
    private String description;

    public Smartphone() {}

    public Smartphone(int id, String name, String brand, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
