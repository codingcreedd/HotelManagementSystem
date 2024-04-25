/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Dish;
import com.mycompany.hotelmanagementsystem.MainClass.Drink;
import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import com.mycompany.hotelmanagementsystem.MainClass.Reservation;
import com.mycompany.hotelmanagementsystem.MainClass.Restaurant;
import com.mycompany.hotelmanagementsystem.MainClass.Room;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public abstract class Customer extends Person{
    
    //CLASSES
    private Scanner in = new Scanner(System.in);
    private Restaurant restaurant = new Restaurant();
    
    private int customerID;
    private String checkInTime;
    protected double restBill;

    public Customer(int customerID, String checkInTime, String name, String address, String phone, String email, int age) {
        super(name, address, phone, email, age);
        this.customerID = customerID;
        this.checkInTime = checkInTime;
    }
    
    public Customer(){
        
    }
    
    public void login(Scanner in){
        try{
            
            ArrayList<RoomCustomer> roomCustomers = Hotel.getInstance().getRoomCustomers();
            if(roomCustomers.size() >= 1){
                System.out.println("\nEnter your customer ID: ");
                int customerIDInput = in.nextInt();
                in.nextLine();

                //check if customer exists
                boolean customerExists = false;
                for(int i = 0; i < roomCustomers.size(); i++){
                    if(roomCustomers.get(i).getCustomerID() == customerIDInput){
                        customerExists = true;
                        break;
                    }
                }

                if(customerExists == true){
                    this.menu(in, customerIDInput, roomCustomers);
                }
                else
                {
                    System.out.println("\nCustomer doesn't exist!\n");
                }
            }
            else
            {
                System.out.println("\nThere are no customers yet! PLEASE CHECK-IN FIRST!\n\n");
            }
            
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    public void menu(Scanner in, int customerID, ArrayList<RoomCustomer> roomCustomers){
        try{
            int choice = 0;
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Check Total Bill");
                System.out.println("2. Check Your Room");
                System.out.println("3. Order Dish");
                System.out.println("4. Order Drink");
                System.out.println("5. Leave Report");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int input = in.nextInt();

                in.nextLine();
                switch(input){
                    case 0:
                        return;
                    case 1:
                        this.checkTotalBill(customerID, roomCustomers);
                        break;
                    case 2:
                        this.checkYourRoom(customerID, roomCustomers);
                        break;
                    case 3:
                        this.orderDish(customerID, roomCustomers);
                        break;
                    case 4:
                        this.orderDrink(customerID, roomCustomers);
                        break;
                    case 5:
                        this.addReport(customerID, roomCustomers);
                        break;
                    default:
                        System.out.println("\nInvalid choice!\n----------------------------------------\n");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    public void checkTotalBill(int customerID, ArrayList<RoomCustomer> roomCustomers){
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customerID){
                System.out.println("Total Room Bill: \n-------------------------------------\n");
                System.out.println("$" + roomCustomers.get(i).getRoom().getPrice());
                
                System.out.println("\n\nTotal Restaurant Bill: \n------------------------------------\n");
                System.out.println("Total Restaurant Bill is $" + roomCustomers.get(i).getRestBill());
            }
        }
    }
    
    public void checkYourRoom(int customerID, ArrayList<RoomCustomer> roomCustomers){
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customerID){
                System.out.println("Information about your room: \n-------------------------------\n");
                roomCustomers.get(i).getRoom().printRoomDetails();
            }
        }
    }
    
    public void orderDish(int customerID, ArrayList<RoomCustomer> roomCustomers){
        try{
           restaurant.displayDishes();
           ArrayList<Dish> dishes = restaurant.getDishes();

            while(true){
                System.out.print("Please Enter the ID of the Dish that you would like to buy or cancel order by entering (0): ");
                int dishIDInput = in.nextInt();
                in.nextLine();
                
                if(dishIDInput <= 0){
                    System.out.println("\nOrder Canceled!\n\n");
                    return;
                }
                else
                {
                    Dish dish = null;
                    for(int i = 0; i < dishes.size(); i++){
                        if(dishes.get(i).getDishID() == dishIDInput){
                            dish = dishes.get(i);
                            break;
                        }
                    }
                    
                    for(int i = 0; i < roomCustomers.size(); i++){
                        if(roomCustomers.get(i).getCustomerID() == customerID){
                            roomCustomers.get(i).addRestBill(dish.getPrice());
                            System.out.println("You have paid $" + dish.getPrice() + " for " + dish.getDishName());
                            Hotel.getInstance().addRestRevenue(dish.getPrice());
                            break;
                        }
                    }
                    
                    System.out.println("\nThank you for purchasing a dish from our restaurant!\n\n");
                }
            } 
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
        
    }
    
    public void orderDrink(int customerID, ArrayList<RoomCustomer> roomCustomers){
        try{
           restaurant.displayDrinks();
           ArrayList<Drink> drinks = restaurant.getDrinks();

            while(true){
                System.out.print("Please Enter the ID of the Drink that you would like to buy or cancel order by entering (0): ");
                int drinkIDInput = in.nextInt();
                in.nextLine();
                
                if(drinkIDInput <= 0){
                    System.out.println("\nOrder Canceled!\n\n");
                    return;
                }
                else
                {
                    Drink drink = null;
                    for(int i = 0; i < drinks.size(); i++){
                        if(drinks.get(i).getDrinkID() == drinkIDInput){
                            drink = drinks.get(i);
                            break;
                        }
                    }
                    
                    for(int i = 0; i < roomCustomers.size(); i++){
                        if(roomCustomers.get(i).getCustomerID() == customerID){
                            roomCustomers.get(i).addRestBill(drink.getPrice());
                            System.out.println("You have paid $" + drink.getPrice() + " for " + drink.getDrinkName());
                            Hotel.getInstance().addRestRevenue(drink.getPrice());
                            break;
                        }
                    }
                    
                    System.out.println("\nThank you for purchasing a drink from our restaurant!\n\n");
                }
            } 
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    public void addReport(int customerID, ArrayList<RoomCustomer> roomCustomers){
        System.out.println("Please enter a report about your experience in this hotel: \n------------------------------------------\n");
        String reportInput = in.nextLine();
        
        Reservation reservation = Hotel.getInstance().getReservation();
        RoomCustomer customer = null;
        
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customerID)
                customer = roomCustomers.get(i);
        }
        
        System.out.println("Thank you for sending feedback!\n");
        if(reportInput.length() > 10){
            reservation.addReport(reportInput, customer);
            System.out.println("\nReport has been added!Thank you!\n\n");
        }
        
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public String getCheckInTime(){
        return checkInTime;
    }
    
    public double getRestBill(){
        return restBill;
    }
    

    @Override
    public void printPersonDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    protected abstract void viewTotalBill();
    protected abstract void checkOut();
    
}
