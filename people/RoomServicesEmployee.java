/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public class RoomServicesEmployee extends Employee implements Employable{
    
    protected double roomServicesEmployeeBaseSalary = 1300;
    
    public void roomServicesEmployeeMenu(Scanner in){
        try{
                int choice = 0;
                while (true) {
                    System.out.println("\nRoom Services Employee Menu: \n");
                    System.out.println("1. Laundry Employee");
                    System.out.println("2. Cleaning Employee");
                    System.out.println("3. Chef");
                    System.out.println("0. Exit");
                    
               
                    System.out.print("Enter your choice: ");
                    int input = in.nextInt();

                    in.nextLine();

                    switch (input) {
                        case 0:
                            return;
                        case 1:
                            Hotel.getInstance().callLaundryMenu();
                            break;
                        case 2:
                            Hotel.getInstance().callCleaningMenu();
                           break;
                        case 3:
                            Hotel.getInstance().callChefMenu();
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

    @Override
    public void printEmployeeSalary(){
        System.out.println("Your base salary is: $ " + this.roomServicesEmployeeBaseSalary);
    }
    
    @Override
    public double getBaseSalary(){
        return this.roomServicesEmployeeBaseSalary;
    }
    
    @Override
    public void workHours() {
        super.workHours();
    }
    
    @Override
    public double getEmployeeSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEmployeeSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
