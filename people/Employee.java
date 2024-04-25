/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Employee extends Person{
   

    private String employeeID = "EMPLOYEE.000";
    private String employeePass = "EMPLOYEEPASS";
    private double baseSalary = 1200;
    
    protected String role;

    public Employee(String role, String name, String address, String phone, String email, int age) {
        super(name, address, phone, email, age);
        this.role = role;
    }
    
    public Employee(){
        
    }
    
    public String getRole(){
        return this.role;
    }
    
    public double getBaseSalary(){
        return this.baseSalary;
    }
    
    public void printPersonDetails() {
        System.out.println("\nEmployee's Details: ");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
    }

    
    public void login(Scanner in){
        try
        {
            System.out.print("Enter Employee ID: ");
            String employeeIDInput = in.next();
            if(employeeIDInput.equals(this.employeeID)){
                System.out.print("Enter employee password: ");
                String employeePassword = in.next();
                if(employeePassword.equals(this.employeePass))
                {
                    this.employeeMenu(in);
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
                System.out.println("\nWrong Employee ID!\n----------------------------------------\n");
                // Clear the scanner's buffer
                in.nextLine();
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void employeeMenu(Scanner in){
        try{
                int choice = 0;
                while (true) {
                    System.out.println("\nEmployee Menu:");
                    System.out.println("1. Waiter");
                    System.out.println("2. Room Services Employee");
                    System.out.println("0. Exit");

                    System.out.print("Enter your choice: ");
                    int input = in.nextInt();

                    in.nextLine();

                    switch (input) {
                        case 0:
                            return;
                        case 1:
                            Hotel.getInstance().callWaiterMenu();
                            break;
                        case 2:
                            Hotel.getInstance().callRoomServicesMenu();
                           break;
                        default:
                            System.out.println("\nInvalid choice!\n----------------------------------------\n");
                            break;
                    }
            }
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    public void methodsMenu(){
        System.out.println("1. Work Hours");
        System.out.println("2. Check Current Salary");
        System.out.println("0. Exit");
    }

    public void printEmployeeSalary(){
        System.out.println("Your base salary is: $ " + this.baseSalary);
    }
    
    public void workHours() {
        Random rand = new Random();
        int shiftStart = rand.nextInt(12) + 8; // Random start time between 8 AM and 8 PM
        int shiftDuration = rand.nextInt(6) + 4; // Random duration between 4 and 10 hours

        System.out.println("\nWaiter Work Hours:");
        System.out.println("*****************************");
        System.out.println("Shift Start: " + shiftStart + ":00 AM");
        System.out.println("Shift Duration: " + shiftDuration + " hours");
        int shiftEnd = shiftStart + shiftDuration;
        if (shiftEnd > 12) {
            System.out.println("Shift End: " + (shiftEnd - 12) + ":00 PM");
        } else {
            System.out.println("Shift End: " + shiftEnd + ":00 AM");
        }
        System.out.println("*****************************");
    }
    
    @Override
    protected void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
