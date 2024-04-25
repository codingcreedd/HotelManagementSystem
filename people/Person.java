/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.people;

import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import com.mycompany.hotelmanagementsystem.MainClass.Reservation;
import java.util.ArrayList;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */
public abstract class Person {
    protected String name;
    protected String address;
    protected String phone; //with country code
    protected String email;
    protected int age;

    public Person(String name, String address, String phone, String email, int age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public Person(){
        
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    protected void viewReports(){
        Reservation reservation = Hotel.getInstance().getReservation();
        ArrayList<String> reports = reservation.getReports();
        
        if(reports.size() >= 1){
            for(int i = 0; i < reports.size(); i++){
                System.out.println(reports.get(i));
            }
        }
        else
        {
            System.out.println("\nThere are no reports yet!\n");
        }
        
    }
    
    public abstract void printPersonDetails();
    protected abstract void login();
    
}
