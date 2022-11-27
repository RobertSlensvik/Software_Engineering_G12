package org.example.Model;

public class Store {
    private String name;
    private double bankBalance;
    
    public Store(){

    }

    public Store(String brand, String model, String discription, double price, String rentersName, String color, String userName, double bankBalance){
        this.name = userName;
        this.bankBalance = 0;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getBalance(){
        return bankBalance;
    }
    public void setBalance(double bankBalance){
        this.bankBalance = bankBalance;
    }

    public String getActiveRentals() {
        return name;
    }

    public String getRentHistory() {
        return name;
    }
}
