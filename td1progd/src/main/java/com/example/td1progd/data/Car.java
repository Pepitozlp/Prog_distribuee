package com.example.td1progd.data;

public class Car {
    private int id;
    private String model;
    private String plateNumber;
    private double price;

    // Constructeur
    public Car(int id, String model, String plateNumber, double price) {
        this.id = id;
        this.model = model;
        this.plateNumber = plateNumber;
        this.price = price;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModel() { return model; }
    public String getPlateNumber() { return plateNumber; }
    public double getPrice() { return price; }
}
