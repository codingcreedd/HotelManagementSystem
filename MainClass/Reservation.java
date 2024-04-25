/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

import com.mycompany.hotelmanagementsystem.people.Customer;
import com.mycompany.hotelmanagementsystem.people.RoomCustomer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Reservation {
    
    private final String username = "RESERVATION.000";
    private String password = "RESERVATIONPASS";
    
    private ArrayList<String>reports = new ArrayList<>();
    
    public Reservation(){
        
    }
    
    public ArrayList<String> getReports(){
        return reports;
    }
    
    public void addReport(String report, RoomCustomer roomCustomer){
        String newReport = "Added by " + roomCustomer.getCustomerName() + ", ID: " + roomCustomer.getCustomerID() + "\n-------------------------------------------\n" + report;
        reports.add(newReport);
    }
    
    public void login(Scanner in){
        try{
            String usernameInput;
            
                System.out.print("\nEnter Reservation Username: ");
                usernameInput = in.next();
                
                if(!usernameInput.equals(this.username)){
                    System.out.println("\nWrong Reservation Username!\n");
                    return;
                }
            
            
            String passwordInput;
            while(true){
                System.out.print("\nEnter Reservation Password: ");
                passwordInput = in.next();
                
                if(passwordInput.equals(this.password)){
                    break;
                }
                else
                    System.out.println("\nWrong Reservation Password!\n");
            }
            
            this.reservationMenu(in);
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    private void reservationMenu(Scanner in){
        try {
            int choice = 0;
            while (true) {
                System.out.println("Reservation Menu:");
                System.out.println("1. Customer Check-in");
                System.out.println("2. Customer Check-out");
                System.out.println("3. Check Rooms and Customers");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int input = in.nextInt();

                in.nextLine();
                switch(input){
                    case 0:
                        return;
                    case 1:
                        checkIn(in);
                        break;
                    case 2:
                        checkOut(in);
                        break;
                    case 3:
                        Hotel.getInstance().checkRoomsCustomers();
                        break;
                    default:
                        System.out.println("\nInvalid choice!\n----------------------------------------\n");
                        break;
                }
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private Room checkInRoom(Scanner in) {
        while (true) {
            System.out.println("Pick one of the following rooms (Room Number): \n");
            ArrayList<Room> availableRooms = Hotel.getInstance().printAvailableRooms();

            int roomNumber = in.nextInt();
            in.nextLine();

            for (Room room : availableRooms) {
                if (room.getRoomNumber() == roomNumber) {
                    room.changeAvailability();
                    return room;
                }
            }

            System.out.println("Invalid room number. Please choose a valid room number.");
        }
    }

    
    private void checkIn(Scanner in) {
        try {
            System.out.println("\nCustomer Check-in:");
            System.out.print("Enter customer name: ");
            String customerName = in.nextLine();
            
            System.out.print("Enter customer address: ");
            String customerAddress = in.nextLine();
            
            System.out.print("Enter customer phone: ");
            String customerPhone = in.nextLine();
            
            System.out.print("Enter customer email: ");
            String customerEmail = in.nextLine();
            
            System.out.print("Enter customer age: ");
            int customerAge = in.nextInt();
            in.nextLine();

            //random ID
            int customerId = (int) (Math.random() * 90000) + 10000;
            System.out.println("Generated customer ID: " + customerId);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date checkInDateTime = null;
            Date expectedCheckOutDateTime = null;

            boolean validDates = false;
            String checkInDateTimeStr = "";
            while (!validDates) {
                System.out.print("Enter check-in date and time (yyyy-MM-dd HH:mm:ss): ");
                checkInDateTimeStr = in.nextLine();
                try {
                    checkInDateTime = dateFormat.parse(checkInDateTimeStr);
                    validDates = true;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd HH:mm:ss");
                }
            }

            validDates = false;
            while (!validDates) {
                System.out.print("Enter expected check-out date and time (yyyy-MM-dd HH:mm:ss): ");
                String expectedCheckOutDateTimeStr = in.nextLine();
                try {
                    expectedCheckOutDateTime = dateFormat.parse(expectedCheckOutDateTimeStr);
                    validDates = true;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd HH:mm:ss");
                }
            }

            //number of days
            long diffInMillies = Math.abs(expectedCheckOutDateTime.getTime() - checkInDateTime.getTime());
            long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);

            System.out.println("Number of days: " + diffInDays);
            
            if(Hotel.getInstance().getRooms().size() >= 1){
                Room room = this.checkInRoom(in);
                RoomCustomer customer = new RoomCustomer(room.getPrice(), room, diffInDays, customerId, checkInDateTimeStr, customerName, customerAddress, customerPhone, customerEmail, customerAge);
                Hotel.getInstance().addCustomer(customer);
            }
            else
            {
                System.out.println("\nThere are no rooms yet!\n");
            }
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void checkOut(Scanner in) {
        try {
            System.out.println("\nCustomer Check-out:");
            System.out.print("\nEnter customer ID: ");
            int customerID = in.nextInt();
            in.nextLine();

            RoomCustomer customerToCheckOut = Hotel.getInstance().findCustomerByID(customerID);

            if (customerToCheckOut != null) {
                System.out.println("\nCustomer found. Checking out...");
                
                System.out.println("\n\nCustomer paid $" + customerToCheckOut.getTotalBill());
                Hotel.getInstance().addRoomRevenue(customerToCheckOut.getTotalBill());
                
                //REMOVE CUSTOMER
                Hotel.getInstance().removeCustomer(customerToCheckOut);
                
                
                customerToCheckOut.getRoom().changeAvailability(); // Mark room as available
                System.out.println("\nCustomer successfully checked out.");
            } else {
                System.out.println("\n\nCustomer not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
