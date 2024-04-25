/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Dish {
    private String dishName;
    private String dishType;
    private int dishID;
    
    private double price;

    public Dish(String dishName, int drinkID , String dishType, double price) {
        this.dishName = dishName;
        this.dishID = drinkID;
        this.dishType = dishType;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public double getPrice() {
        return price;
    }
    
    public int getDishID(){
        return dishID;
    }
    
    public void displayDish(){
        System.out.println("\t" + dishName + "\t" + dishID + "\t" + dishType + "\t$" + price + "\n");
    }
    
}
