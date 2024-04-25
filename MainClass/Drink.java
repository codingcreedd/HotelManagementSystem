/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Drink {
    private String drinkName;
    private String drinkType;
    private int drinkID;
    
    private double price;

    public Drink(String drinkName, int drinkID, String drinkType, double price) {
        this.drinkName = drinkName;
        this.drinkID = drinkID;
        this.drinkType = drinkType;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public double getPrice() {
        return price;
    }
    
    public int getDrinkID(){
        return drinkID;
    }
    
    public void displayDrink(){
        System.out.println("\t" + drinkName + "\t" + drinkID + "\t" +  drinkType + "\t$" + price + "\n");
    }
}
