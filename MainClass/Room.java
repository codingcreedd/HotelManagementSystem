/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

import java.util.Scanner;
/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Room {
    
    private Scanner in = new Scanner(System.in);
    private final int MAX_OCCUPANCY = 5;
    
    private String roomType;
    private int roomNumber;
    private String bedType;
    
    private boolean availibility;
    private double price;

    public Room(String roomType, int roomNumber, String bedType, boolean availibility) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.bedType = bedType;
        this.availibility = availibility;
        
        if(roomType.toUpperCase().equals("SUITE"))
            this.price = 399.95;
        else if(roomType.toUpperCase().equals( "DELUXE"))
            this.price = 249.99;
        else if(roomType.toUpperCase().equals("DOUBLE"))
            this.price = 199.95;
        else
            this.price = 149.99;
    }

    public Scanner getIn() {
        return in;
    }

    public int getMAX_OCCUPANCY() {
        return MAX_OCCUPANCY;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBedType() {
        return bedType;
    }

    public boolean isAvailibility() {
        return availibility;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void printRoomDetails() {
        System.out.println("\nRoom Details:");
        System.out.println("Room Type: " + roomType);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Type: " + bedType);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (availibility ? "Available" : "Occupied"));
    }
    
    public void changeAvailability(){
        this.availibility = !this.availibility;
    }

    
}
