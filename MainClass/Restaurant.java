/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Restaurant
{
    private Scanner in = new Scanner(System.in);
    private ArrayList<Dish>dishes = new ArrayList<>(Arrays.asList(new Dish("Fahita", 1 ,"Sandwich", 5.3), new Dish("Chicken Avocado", 2 ,"Plates", 7.5), new Dish("Hamburger", 3, "Sandwich", 4.2)));
    private ArrayList<Drink>drinks = new ArrayList<>(Arrays.asList(new Drink("Orange", 1 , "Fruit", 1.1), new Drink("Vanilla Milkshake", 2, "Milkshake", 3.2), new Drink("Tea", 3,"Hot Drink", 0.9)));
    
    public void displayMenu(){
        this.displayDishes();
        this.displayDrinks();
    }
    
    public ArrayList<Dish> getDishes(){
        return dishes;
    }
    
    public ArrayList<Drink> getDrinks(){
        return drinks;
    }
    
    public void addDish(Dish dish){
        boolean dishExists = false;
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).getDishName().equals(dish.getDishName()))
                dishExists = true;
        }
        
        if(dishExists == false)
            dishes.add(dish);
            
    }
    
    public void addDrink(Drink drink){
        boolean drinkExists = false;
        for(int i = 0; i < drinks.size(); i++){
            if(drinks.get(i).getDrinkName().equals(drink.getDrinkName()))
                drinkExists = true;
        }
        
        if(drinkExists == false)
            drinks.add(drink);
    }
    
    public void removeDish(){
        try{
            this.displayDishes();

            System.out.print("\n\nEnter the Dish name that you would like to remove: ");
            String dishName = in.nextLine();

            boolean dishExists = false;
            for(int i = 0; i < dishes.size(); i++){
                if(dishes.get(i).getDishName().toUpperCase().equals(dishName.toUpperCase()))
                {
                    dishes.remove(i);
                    System.out.println("\nDish removed successfully!\n");
                    dishExists = true;
                    break;
                }
            }

            if(dishExists == false)
                System.out.println("\nDish doesn't exist!\n");
            
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
        
    }
    
    public void removeDrink(){
        try{
            this.displayDrinks();

            System.out.print("\n\nEnter the Dish name that you would like to remove: ");
            String dishName = in.nextLine();

            boolean dishExists = false;
            for(int i = 0; i < dishes.size(); i++){
                if(dishes.get(i).getDishName().toUpperCase().equals(dishName.toUpperCase()))
                {
                    dishes.remove(i);
                    System.out.println("\nDish removed successfully!\n");
                    dishExists = true;
                    break;
                }
            }

            if(dishExists == false){
                System.out.println("\nDish doesn't exist!\n");
                return;
            }
            
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    public void displayDrinks(){
        System.out.println("\n--------------------------------\nDrink\tName\tID\tType\tPrice ($)\n---------------------------------\n");
        for(int i = 0; i < drinks.size(); i++){
            System.out.print((i + 1));
            drinks.get(i).displayDrink();
        }
    }
    
    public void displayDishes(){
        System.out.println("Dish\tName\tid\tType\tPrice ($)\n---------------------------------\n");
        for(int i = 0; i < dishes.size(); i++){
            System.out.println((i + 1));
            dishes.get(i).displayDish();
        }
    }
    
}
