/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Room;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class RoomCustomer extends Customer{
    private double roomBill;
    private Room room;
    private long numberOfDays;
    private String report;

    public RoomCustomer(double roomBill, Room room, long numberOfDays, int customerID, String checkInTime, String name, String address, String phone, String email, int age) {
        super(customerID, checkInTime, name, address, phone, email, age);
        this.roomBill = roomBill;
        this.room = room;
        this.numberOfDays = numberOfDays;
    }
    
    public RoomCustomer(){
        
    }
    
    public void printPersonDetails() {
        System.out.println("Customer Details:");
        System.out.println("Customer ID: " + super.getCustomerID());
        System.out.println("Name: " + super.getName());
        System.out.println("Address: " + super.getAddress());
        System.out.println("Phone: " + super.getPhone());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Age: " + super.getAge());
        System.out.println("Check-in Time: " + getCheckInTime());
        
        System.out.println("Room Details:");
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Bed Type: " + room.getBedType());
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Room Bill: $" + roomBill);
        viewTotalBill();
    }

    
    
    public double getRoomBill() {
        return roomBill;
    }
    
    public double getRestBill(){
        return restBill;
    }
    
    public double getTotalBill(){ //FOR CHECKOUT PURPOSES
        return roomBill + (roomBill*0.25);
    }
    
    public String getCustomerName(){
        return super.getName();
    }
    
    public int getRoomCustomerID(){
        return super.getCustomerID();
    }

    public Room getRoom() {
        return room;
    }

    public long getNumberOfDays() {
        return numberOfDays;
    }
    
    public void addRestBill(double bill){
        this.restBill += bill;
    }
    
    public void setReport(String report){
        this.report = report;
    }

    @Override
    protected void viewTotalBill() {
        System.out.println("Total Bill: $" + this.roomBill + " + $" + (this.roomBill * 0.25) + " FEE\n");
    }

    @Override
    protected void checkOut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
