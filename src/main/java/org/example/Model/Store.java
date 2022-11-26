package org.example.Model;

public class Store {
    private String name;
    private double bankBalance;
    
    public Store(String string, double d){

    }

    public Store(String userName){
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
