package org.example.Model;


public class Car {
    private String brand;
    private String model;
    private String description;
    private double price;
    private String rentersName;
    private String buyer;
    private boolean rented;

    public Car(String carName, String rentersName, String model, String brand, double price, String description){

    }


    public Car(String brand, String model, String description, double price, String rentersName, String buyer) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.price = price;
        this.rentersName = rentersName;
        this.buyer = buyer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getDecsription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getRentersName() {
        return rentersName;
    }
    public void setRentersName(String rentersName) {
        this.rentersName = rentersName;
    }
    public String getBuyer() {
        return buyer;
    }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    public Boolean getRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString(){
        return "Car [brand=" + brand + ", model=" + model + ", description=" + description + ", price=" + price + ", rentersName=" + rentersName + ", buyer=" + buyer + "]";
    }



}