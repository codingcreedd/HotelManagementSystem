/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;
import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import com.mycompany.hotelmanagementsystem.MainClass.Reservation;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Owner extends Person{
    
    //CLASSES
    private Scanner in = new Scanner(System.in);
    
    private final long ownership_share = 100; //IN PERCENTAGE
    private String ownershipID = "OWNER.000";
    private String ownerPass = "owner12345@";

    //CONSTRUCTOR
    public Owner(String name, String address, String phone, String email, int age) {
        super(name, address, phone, email, age);
    }
    
    
    public void login(){
        try
        {
            System.out.print("Enter ownership ID: ");
            String ownerShipIDInput = in.next();
            if(ownerShipIDInput.equals(this.ownershipID)){
                System.out.print("Enter owner password: ");
                String ownerPassword = in.next();
                if(ownerPassword.equals(this.ownerPass))
                {
                    this.ownerMenu();
                }
                else
                {
                    System.out.println("\nWrong Password!\n----------------------------------------\n");
                    // Clear the scanner's buffer
                    in.nextLine();
                }
            }
            else
            {
                System.out.println("\nWrong ownership ID!\n----------------------------------------\n");
                // Clear the scanner's buffer
                in.nextLine();
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void printPersonDetails() {
         System.out.println("\n\nOwner Details\n-------------------------------------\n:");
         System.out.println("Name: " + getName());
         System.out.println("Address: " + getAddress());
         System.out.println("Phone: " + getPhone());
         System.out.println("Email: " + getEmail());
         System.out.println("Age: " + getAge());
         System.out.println("Ownership ID: " + ownershipID);
         System.out.println("Ownership Share: " + ownership_share + "%");
     }

    
    private void ownerMenu() {
        try {
            int choice = 0;
            while (true) {
                System.out.println("\n\nOwner Menu:");
                System.out.println("1. Add Room");
                System.out.println("2. Remove Room");
                System.out.println("3. View Occupancy");
                System.out.println("4. View Revenue");
                System.out.println("5. Change Owner Name");
                System.out.println("6. Change Ownership ID");
                System.out.println("7. Change Owner Password");
                System.out.println("8. Print Owner Details");
                System.out.println("9. View Room Details");
                System.out.println("10. Add Admin");
                System.out.println("11. Remove Admin");
                System.out.println("12. Print Admin Details");
                System.out.println("13. View Reports");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int input = in.nextInt();

                in.nextLine();

                switch (input) {
                    case 0:
                        return;
                    case 1:
                        Hotel.getInstance().addRoom();
                        break;
                    case 2:
                        Hotel.getInstance().removeRoom();
                        break;
                    case 3:
                        Hotel.getInstance().viewOccupancy(); 
                        break;
                    case 4:
                        viewRevenue();
                        break;
                    case 5:
                        changeOwnerName();
                        break;
                    case 6:
                        changeOwnerID();
                        break;
                    case 7:
                        changeOwnerPassword();
                        break;
                    case 8:
                        printPersonDetails();
                        break;
                    case 9:
                        Hotel.getInstance().checkRoomDetails();
                        break;
                    case 10:
                        Hotel.getInstance().addAdmin();
                        break;
                    case 11:
                        Hotel.getInstance().removeAdmin();
                        break;
                    case 12:
                        Hotel.getInstance().printAdminDetails();
                        break;
                    case 13:
                        super.viewReports();
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
    
    private void changeOwnerName() {
        try {
            while (true) {
                System.out.print("Enter new owner name: ");
                String newName = in.nextLine();
                if (!newName.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Invalid name format! Name should only contain letters and spaces.");
                } else {
                    this.name = newName;
                    System.out.println("Owner name updated successfully.");
                    break; 
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void changeOwnerID() {
        try {
            while (true) {
                System.out.print("Enter new owner ID (at least 8 characters): ");
                String newID = in.nextLine();
                if (newID.length() < 8) {
                    System.out.println("Owner ID must be at least 8 characters long.");
                } else {
                    ownershipID = newID;
                    System.out.println("Owner ID updated successfully.");
                    break; 
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void changeOwnerPassword() {
        try {
            while (true) {
                System.out.print("Enter new owner password (at least 8 characters, with at least one number and one special character): ");
                String newPassword = in.nextLine();
                if (newPassword.length() < 8 || !newPassword.matches(".*\\d.*") || !newPassword.matches(".*[!@#$%^&*()-+=`~\\\\\\\\|[{\\\\]};:'\\\",<.>/?].*")) {
                    System.out.println("Invalid password format! Password must be at least 8 characters long and contain at least one number and one special character.");
                } else {
                    ownerPass = newPassword;
                    System.out.println("Owner password updated successfully.");
                    break; 
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void viewRevenue(){
        System.out.println("Total Hotel Revenue ($):\n----------------------------------------------\n");
        System.out.println("$ " + Hotel.getInstance().getTotalRevenue() + "\n----------------------------------------------\n");
        
        System.out.println("Rooms Revenue ($): \n----------------------------------------------\n");
        System.out.println("$ " + Hotel.getInstance().getRoomRevenue() + "\n----------------------------------------------\n");
        
        System.out.println("Restaurant Revenue ($): \n----------------------------------------------\n");
        System.out.println("$ " + Hotel.getInstance().getRestRevenue() + "\n----------------------------------------------\n");
        
    }
    
}
