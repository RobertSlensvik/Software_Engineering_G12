package org.example.Model;

public class User {
    private String name;
    private double bankBalance;

    public User(String name, double bankBalance){
        this.name = name;
        this.bankBalance = bankBalance;
    }
    public String getName(){
        return name;
    }
    
}
