/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class Chef extends RoomServicesEmployee implements Employable{
    private double chefSalary = 700;
    
    public void chefMenu(Scanner in){
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
    
    public double getEmployeeSalary(){
        return this.chefSalary + super.getBaseSalary();
    }
    
    public void workHours(){
        System.out.println("\nChef Work Shift For Today: \n---------------------------------------\n");
        super.workHours();
    }
    
    public void printEmployeeSalary(){
        super.printEmployeeSalary();
        System.out.println("\nYour Salary (As a Chef): $" + this.chefSalary);
        System.out.println("\nYour Whole Salary: $" + this.getEmployeeSalary() + "\n");
    }
    
}
