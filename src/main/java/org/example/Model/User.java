package org.example.Model;

public class User {
    private String name;
    private double bankBalance;

    public User(){

    }

    public User(String name, double bankBalance){
        this.name = name;
        this.bankBalance = bankBalance;
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

    public double getMoney() {
        return 0;
    }

    public void setMoney(double d) {
    }
}
