package com.example.model;

public class Smartphone {
    private String brand;
    private String model;
    private String imageUrl;
    private String description;
    private String specifications;

    public Smartphone(String brand, String model, String imageUrl, String description, String specifications) {
        this.brand = brand;
        this.model = model;
        this.imageUrl = imageUrl;
        this.description = description;
        this.specifications = specifications;
    }

    // Геттери
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getSpecifications() {
        return specifications;
    }
}
