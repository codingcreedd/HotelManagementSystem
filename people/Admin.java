/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Admin extends Person{
    
    //CLASSES
    private Scanner in = new Scanner(System.in);
    
    private String role;
    private String adminID;
    private String adminPass;

    public Admin(String role, String adminID, String adminPass, String name, String address, String phone, String email, int age) {
        super(name, address, phone, email, age);
        this.role = role;
        this.adminID = adminID;
        this.adminPass = adminPass;
    }
    
    
    
    public Admin(){
        super();
    }

    //GETTERS
    public Scanner getIn() {
        return in;
    }

    public String getRole() {
        return role;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminPass() {
        return adminPass;
    }
    
    public String getAdminName(){
        return super.getName();
    }
    
    public String getAdminAddress(){
        return super.getAddress();
    }
    
    public String getAdminPhone(){
        return super.getPhone();
    }
    
    public String getAdminEmail(){
        return super.getEmail();
    }
    
    public int getAdminAge(){
        return super.getAge();
    }
    
    //METHODS
    public void login(ArrayList<Admin> admins) {
        try {
            if (admins.size() >= 1) {
                System.out.print("Enter admin ID: ");
                String adminInput = in.next();

                if (this.adminExists(adminInput, admins)) {
                    System.out.print("Enter admin password: ");
                    String adminPassword = in.next();
                    if (this.checkAdminPassword(adminInput, adminPassword, admins)) {
                        this.adminMenu(admins, adminInput); // Pass the current admin object to the adminMenu method
                    } else {
                        System.out.println("\nWrong Password!\n----------------------------------------\n");
                        // Clear the scanner's buffer
                        in.nextLine();
                    }
                } else {
                    System.out.println("\nAdmin doesn't exist!\n----------------------------------------\n");
                    // Clear the scanner's buffer
                    in.nextLine();
                }
            } else {
                System.out.println("\nThere are no admins yet, the owner must add admins for this hotel!\n---------------------------------------------------\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
    
    public void adminMenu(ArrayList<Admin> admins, String adminID){
        try {
            int choice = 0;
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add Room");
                System.out.println("2. Remove Room");
                System.out.println("3. Change My Name");
                System.out.println("4. Change My ID");
                System.out.println("5. Change My Password");
                System.out.println("6. Print My Details");
                System.out.println("7. View Room Details");
                System.out.println("8. Add Admin");
                System.out.println("9. View Reports");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int input = in.nextInt();

                in.nextLine();
                switch(input){
                    case 0:
                        return;
                    case 1:
                        Hotel.getInstance().addRoom();
                        break;
                    case 2:
                        Hotel.getInstance().removeRoom();
                        break;
                    case 3:
                        changeAdminName();
                        break;
                    case 4:
                        changeAdminID();
                        break;
                    case 5:
                        changeAdminPassword();
                        break;
                    case 6:
                        Hotel.getInstance().printCurrentAdmin(adminID);
                        break;
                    case 7:
                        Hotel.getInstance().checkRoomDetails();
                        break;
                    case 8:
                        Hotel.getInstance().addAdmin();
                        break;
                    case 9:
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
    
    private boolean adminExists(String adminID, ArrayList<Admin> admins){
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getAdminID().equals(adminID))
                return true;
        }
        
        return false;
    }
    
    private boolean checkAdminPassword(String adminID, String adminPassword, ArrayList<Admin> admins){
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getAdminID().equals(adminID) && admins.get(i).getAdminPass().equals(adminPassword))
                return true;
        }
        
        return false;
    }
    
    private void changeAdminName() {
        try { 
            while(true){
                System.out.print("Enter new name: ");
                String newName = in.nextLine();
                
                if(!newName.equals(this.getAdminName())){
                    super.setName(newName);
                    System.out.println("\nName changed successfully!\n");
                    break;
                }
                else
                {
                    System.out.println("\nThe name you entered is the same!\n");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void changeAdminID(){
        try {
            while(true){
                System.out.print("Enter password to change ID: ");
                String adminPassword = in.next();

                if(adminPassword.equals(this.adminPass)){
                    this.adminPass = adminPassword;
                    break;
                }
            }
            
            while(true){
                System.out.print("Enter new ID: ");
                String newID = in.nextLine();
                
                if(!newID.equals(this.getAdminID()) && newID.length() > 8){
                    this.adminID = newID;
                    System.out.println("ID changed successfully!\n");
                    break;
                }
                else
                {
                    if(newID.equals(this.getAdminID()))
                        System.out.println("\nThe ID you entered is the same!\n");
                    else
                        System.out.println("\nThe ID you entered must be at least 8 characters long!\n");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void changeAdminPassword(){
        try {
            while(true){
                System.out.print("Enter old password to change password: ");
                String oldPassword = in.next();

                if(oldPassword.equals(this.adminPass)){
                    System.out.print("Enter new password: ");
                    String newPassword = in.next();

                    String pattern = "^(?=.*[0-9])(?=.*[!@#$%^&*()-+=])(?=\\S+$).{8,}$";
                    Pattern p = Pattern.compile(pattern);

                    Matcher m = p.matcher(newPassword);
                    if(m.matches()){
                        this.adminPass = newPassword;
                        System.out.println("Password changed successfully!\n");
                        break;
                    }
                    else{
                        System.out.println("The password must be at least 8 characters long and contain at least one special character and one number.\n");
                    }
                }
                else{
                    System.out.println("Incorrect old password!\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printPersonDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
