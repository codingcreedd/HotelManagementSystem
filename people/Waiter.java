/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Waiter extends Employee implements Employable{
    private double waiterSalary = 600;
    
    public void waiterMenu(Scanner in){
        try{
                int choice = 0;
                while (true) {
                    super.methodsMenu();

                    System.out.print("Enter your choice: ");
                    int input = in.nextInt();

                    in.nextLine();

                    switch (input) {
                        case 0:
                            return;
                        case 1:
                            this.workHours();
                            break;
                        case 2:
                           this.printEmployeeSalary();
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
    
    public void workHours(){
        System.out.println("\nWaiter Work Shift For Today: \n-------------------------------------------\n");
        super.workHours();
    }
    
    @Override
    public void printEmployeeSalary(){
        super.printEmployeeSalary();
        System.out.println("\nYour Salary (As a Waiter): $" + this.waiterSalary);
        System.out.println("\nYour Whole Salary: $" + this.getEmployeeSalary() + "\n");
    }
    
    @Override
    public double getEmployeeSalary() {
        return super.getBaseSalary() + waiterSalary;
    }
    

    @Override
    public void printPersonDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEmployeeSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
