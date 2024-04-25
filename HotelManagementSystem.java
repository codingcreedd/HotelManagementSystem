/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagementsystem;
import com.mycompany.hotelmanagementsystem.MainClass.Hotel;
import java.util.Scanner;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan, Abdallah Merhabi
 */
public class HotelManagementSystem {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        Hotel hotel = Hotel.getInstance();
        hotel.startProgram();
    }
}
