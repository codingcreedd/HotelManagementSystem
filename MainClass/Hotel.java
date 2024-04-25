/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem.MainClass;

import com.mycompany.hotelmanagementsystem.people.Admin;
import com.mycompany.hotelmanagementsystem.people.Chef;
import com.mycompany.hotelmanagementsystem.people.CleaningEmployee;
import com.mycompany.hotelmanagementsystem.people.Customer;
import com.mycompany.hotelmanagementsystem.people.Employee;
import com.mycompany.hotelmanagementsystem.people.LaundryEmployee;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.mycompany.hotelmanagementsystem.people.Owner;
import com.mycompany.hotelmanagementsystem.people.RestaurantCustomer;
import com.mycompany.hotelmanagementsystem.people.RoomCustomer;
import com.mycompany.hotelmanagementsystem.people.RoomServicesEmployee;
import com.mycompany.hotelmanagementsystem.people.Waiter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Marwan Moubayed, Jamal Ourabi, Bashar Dandan
 */

public class Hotel {
    
    //CLASSES
    private Scanner in = new Scanner(System.in);
    private static Hotel instance;
    
    private Owner owner = new Owner("Marwan", "Tripoli, Abu Samra", "+961 76490249", "moubayedmarwan@gmail.com", 18);
    private Admin admin = new Admin();
    private Reservation reservation = new Reservation();
    private Employee employee = new Employee();
    
    private RoomServicesEmployee roomServicesEmployee = new RoomServicesEmployee();
    private Waiter waiter = new Waiter();
    
    private LaundryEmployee laundryEmployee = new LaundryEmployee();
    private CleaningEmployee cleaningEmployee = new CleaningEmployee();
    private Chef chef = new Chef();
    
    RestaurantCustomer restCustomer = new RestaurantCustomer();
    
    //LISTS
    private ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(new Room("SUITE", 100, "KING", true), new Room("SINGLE", 101, "KING", true), new Room("DOUBLE", 102, "KING", true)));
    private ArrayList<Admin> admins = new ArrayList<>();
    
    private ArrayList<Customer>customers = new ArrayList<>();
    private ArrayList<RoomCustomer>roomCustomers = new ArrayList<>();
    private ArrayList<RestaurantCustomer> restaurantCustomers = new ArrayList<>();
    
    private ArrayList<Double> roomBills = new ArrayList<>();
    private ArrayList<Double> restBills = new ArrayList<>();
    
    //attributes
    private String name;
    private double revenue;
    private double roomRevenue;
    private double restRevenue;
    
    //CONSTRUCTOR
    private Hotel(){
        
    }
    
    public static Hotel getInstance(){
        if(instance == null)
            instance = new Hotel();
        
        return instance;
    }
    
    public Reservation getReservation(){
        return reservation;
    }
    
    public void addRoomRevenue(double bill){
        if(bill > 0){
            roomBills.add(bill);
            this.revenue += bill;
            this.roomRevenue += bill;
        }
    }
    
    public void addRestRevenue(double bill){
        if(bill > 0){
            restBills.add(bill);
            this.revenue += bill;
            this.restRevenue += bill;
        }
    }
    
    public double getTotalRevenue(){
        return this.revenue;
    }
    
    public double getRoomRevenue(){
        return this.roomRevenue;
    }
    
    public double getRestRevenue(){
        return this.restRevenue;
    }
    
    public void startProgram() {
        try {
            int userChoice = 0;
            while (true) {
                System.out.println("1. Owner");
                System.out.println("2. Admin");
                System.out.println("3. Employee");
                System.out.println("4. Reservation");
                System.out.println("5. Customer");
                System.out.println("0. Exit");

                userChoice = in.nextInt();
                switch (userChoice) {
                    case 0:
                        return;
                    case 1:
                        owner.login();
                        break;
                    case 2:
                        admin.login(admins); 
                        break;
                    case 3:
                        employee.login(in);
                        break;
                    case 4:
                        reservation.login(in);
                        break;
                    case 5:
                        restCustomer.login(in);
                        break;
                    default:
                        System.out.println("\nInvalid input!\n---------------------------------------------------\n");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input! Please enter a valid integer.");

            // Clear the scanner's buffer
            in.nextLine();
        }
    }

    
    //METHODS 
    
    //HOTEL GENERAL METHODS
    public void viewOccupancy(){
        int occupiedRooms = 0;
        for(int i = 0; i < rooms.size(); i++){
            if(!rooms.get(i).isAvailibility())
                occupiedRooms++;
        }
        
        System.out.println("\n" + occupiedRooms + " out of " + rooms.size() + " rooms are occupied in the hotel.\n");
        
        System.out.println("\n\nOccupied Rooms Details: \n-----------------------------------------------\n");
        for(int i = 0; i < roomCustomers.size(); i++){
            System.out.println("Room " + roomCustomers.get(i).getRoom().getRoomNumber() + " taken by: \n");
            System.out.println("Name: " + roomCustomers.get(i).getCustomerName());
            System.out.println("Customer ID: " + roomCustomers.get(i).getCustomerID());
            System.out.println("Check-in Date: " + roomCustomers.get(i).getCheckInTime());
            System.out.println("Duration of stay: " + roomCustomers.get(i).getNumberOfDays() + " days");
            System.out.println("\n-----------------------------------------------\n");
        }
    }
    
    //ROOMS
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    public void addRoom(){
        try{       
            while(true){
                System.out.println("\n\nAdding a new room:");

             
                String[] validRoomTypes = {"SINGLE", "DOUBLE", "DELUXE", "SUITE"};
                String type;
                while(true){
                    System.out.print("Enter room type (SINGLE, DOUBLE, DELUXE, SUITE): ");
                    type = in.next().toUpperCase(); 
                    if(Arrays.asList(validRoomTypes).contains(type))
                        break;
                    else
                        System.out.println("\nInvalid room type! Must be SINGLE, DOUBLE, DELUXE, or SUITE.\n");
                }

                
                int number;
                while(true){
                    System.out.print("Enter room number: ");
                    number = in.nextInt();
                    in.nextLine();
                    if(checkRoomNumber(number))
                        break;
                    else
                        System.out.println("\nRoom number already exists!\n");
                }
                
                String[] validBedTypes = {"KING", "QUEEN", "TWIN"};
                String bed;
                while(true){
                    System.out.print("Enter bed type (KING, QUEEN, TWIN): ");
                    bed = in.nextLine().toUpperCase(); 
                    if(Arrays.asList(validBedTypes).contains(bed))
                        break;
                    else
                        System.out.println("\nInvalid bed type! Must be KING, QUEEN, or TWIN.\n");
                }

                
                System.out.print("Is the room available? (true/false): ");
                boolean available = Boolean.parseBoolean(in.nextLine());

                
                Room newRoom = new Room(type, number, bed, available); 

                
                if(rooms.contains(newRoom))
                    System.out.println("\n\nRoom already exists!\n------------------------------------\n");
                else{
                    rooms.add(newRoom);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void removeRoom(){
        System.out.println("\n\nYou can Remove the following rooms:\n------------------------------------------------------\n\n");
        for(int i = 0; i < rooms.size(); i++){
            System.out.println("Room " + rooms.get(i).getRoomNumber() + "\n-----------------------------------------------");
        }
        
        System.out.println("Enter the Room's number that you would like to remove: ");
        int roomNumber = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomNumber() == roomNumber){
                rooms.remove(i);
                break;
            }
        }
        
        if(rooms.size() > 0){
            System.out.println("\n\nThe new list of rooms is as follows: \n-------------------------------------------------------\n");
            printRooms();
        }
        else
        {
            System.out.println("\nThere are no Rooms anymore!\n");
        }
    }
    public void checkRoomDetails(){
        while(true){
            System.out.print("Do you want to check all rooms (1) or do you want a specific room (2)? ");
            try{
                int input = in.nextInt();
                in.nextLine();

                switch(input){
                    case 1:
                        printRooms();
                        return;
                    case 2:
                        printRoom();
                        return; 
                    default:
                        System.out.println("\nInvalid choice! Please enter 1 or 2.\n");
                        break; 
                }
            } catch(InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter a valid integer.\n");
                in.nextLine(); // Clear the buffer
            }
        }
    }
    public ArrayList<Room> printAvailableRooms(){
        ArrayList<Room>availableRooms = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).isAvailibility()){
                System.out.println("Available Room\t\t" + rooms.get(i).getRoomType() + "\t\t" + rooms.get(i).getRoomNumber() + "\t\t" + rooms.get(i).getBedType() + 
                    "\t\t$" + rooms.get(i).getPrice() + "\t\t" + rooms.get(i).isAvailibility() + "\n--------------------------------------------------------------------------------------------\n");
                
                availableRooms.add(rooms.get(i));
            }
        }
        
        return availableRooms;
    }
    

    private void printRooms(){
        System.out.println("\n\nRoom\tRoom Type\tRoom Number\tBed Type\tPrice\t\tAvailable\n--------------------------------------------------------------------------------------------\n\n");
        for(int i = 0; i < rooms.size(); i++){
            System.out.println("Room " + (i + 1) + "\t\t" + rooms.get(i).getRoomType() + "\t\t" + rooms.get(i).getRoomNumber() + "\t\t" + rooms.get(i).getBedType() + 
                    "\t\t$" + rooms.get(i).getPrice() + "\t\t" + rooms.get(i).isAvailibility() + "\n--------------------------------------------------------------------------------------------\n");
        }
    }
    private boolean checkRoomNumber(int roomNumber){ //checks if room number already exists
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomNumber() == roomNumber)
                return false;
            
        }
        
        return true;
    }    
    private void printRoom(){
        try{
            if(rooms.size() >= 1){
                System.out.println("You can access the following rooms:\n------------------------------------------------------\n\n");
                for(int i = 0; i < rooms.size(); i++){
                    System.out.println("Room " + rooms.get(i).getRoomNumber() + "\n-----------------------------------------------");
                }

                System.out.println("Enter the Room's number that you would like to access: ");
                int roomNumber = in.nextInt();
                in.nextLine();

                for(int i = 0; i < rooms.size(); i++){
                    if(rooms.get(i).getRoomNumber() == roomNumber){
                        rooms.get(i).printRoomDetails();
                        break;
                    }
                }
            }
            else
            {
                System.out.println("\nThere are no rooms that you can access!\n");
            }
        }catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    
    //ADMINS
    public void addAdmin() {
        try {
            System.out.println("\nAdding a new admin:\n");
            System.out.print("Enter admin name: ");
            String name = in.nextLine();
            in.nextLine();

            System.out.print("Enter admin address: ");
            String address = in.nextLine();

            System.out.print("Enter admin phone: ");
            String phone = in.nextLine();

            System.out.print("Enter admin email: ");
            String email = in.nextLine();

            System.out.print("Enter admin age: ");
            int age = in.nextInt();
            in.nextLine(); 

            System.out.print("Enter admin role: ");
            String role = in.nextLine();

            String adminID = "";
            while(true){
                System.out.print("Enter admin ID: ");
                adminID = in.nextLine();
                boolean adminExists = false;
                for(int i = 0; i < admins.size(); i++){
                    if(admins.get(i).getAdminID().equals(adminID)){
                        adminExists = true;
                        break;
                    }
                }
                if(!adminExists){
                    break; // Exit the loop if the admin ID does not already exist
                } else {
                    System.out.println("ADMIN ALREADY EXISTS!\n");
                }
            }

            System.out.print("Enter admin password: ");
            String adminPass = in.nextLine();

            Admin newAdmin = new Admin(role, adminID, adminPass, name, address, phone, email, age);

            admins.add(newAdmin);

            System.out.println("Admin added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void removeAdmin(){
        try{
            System.out.println("\nRemoving an Admin: \n");
            System.out.println("You can remove one of the following admins: \n-----------------------------------------------\n");
            for(int i = 0; i < admins.size(); i++){
                System.out.println("Admin " + admins.get(i).getAdminID() + "\n-----------------------------------------------");
            }
            
            System.out.println("Enter the Admin's ID that you would like to remove: ");
            String adminID = in.next();

            for(int i = 0; i < admins.size(); i++){
                if(admins.get(i).getAdminID().equals(adminID)){
                    admins.remove(i);
                    break;
                }
            }
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void printAdminDetails(){
        System.out.println("\n\nAdmin\tAdmin Name\tID\tAddress\tPhone\t\tEmail\tAge\tRole\tPassword\n--------------------------------------------------------------------------------------------\n\n");

        for(int i = 0; i < admins.size(); i++){
            System.out.println("Admin " + (i + 1) + "\t\t" + admins.get(i).getAdminName() + "\t\t" + admins.get(i).getAdminID() + "\t\t" + admins.get(i).getAdminAddress() + 
                    "\t\t" + admins.get(i).getAdminPhone() + "\t\t" + admins.get(i).getAdminPhone() + "\t\t" + admins.get(i).getAdminEmail() + "\t\t" + admins.get(i).getAdminAge()
                    + "\t\t" + admins.get(i).getRole() + "\t\t" + admins.get(i).getAdminPass() + "\n--------------------------------------------------------------------------------------------\n");
        }
    }
    public void printCurrentAdmin(String adminID){
        System.out.println("\nAdmin Details\n-------------------------------------");
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getAdminID().equals(adminID))
            {
                System.out.println("\nAdmin Details\n-------------------------------------");
                System.out.println("Name: " + admins.get(i).getAdminName());
                System.out.println("Address: " + admins.get(i).getAdminAddress());
                System.out.println("Phone: " + admins.get(i).getAdminPhone());
                System.out.println("Email: " + admins.get(i).getAdminEmail());
                System.out.println("Age: " + admins.get(i).getAdminAge());
                System.out.println("Role: " + admins.get(i).getRole());
                System.out.println("Admin ID: " + admins.get(i).getAdminID());
                return;
            }
        }
    }
    
    //CUSTOMERS
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }
    
    public ArrayList<RoomCustomer> getRoomCustomers(){
        return this.roomCustomers;
    }
    
    public void printRoomCustomers(){
        System.out.println("\n\nROOMS TAKEN: \n---------------------------------------\n");
        for(int i = 0; i < roomCustomers.size(); i++){
            System.out.println(roomCustomers.get(i).getCustomerName() + " has taken room " + roomCustomers.get(i).getRoom().getRoomNumber() + ", ID: " + roomCustomers.get(i).getCustomerID());
        }
        System.out.println("\n");
    }
    
    
    //ROOM CUSTOMER
    
    public void addCustomer(RoomCustomer customer){
        try{
            boolean exists = false;
            
            if(roomCustomers.size() == 0){
                roomCustomers.add(customer);
                System.out.println("\nThis customer has been successfully added!\n");
            }
            else
            {
                for(int i = 0; i < roomCustomers.size(); i++){
                    if(roomCustomers.get(i).getRoomCustomerID() == customer.getRoomCustomerID()){
                        System.out.println("Customer already exists!\n");
                        exists = true;
                        break;
                    }
                }

                if(exists == false){
                    roomCustomers.add(customer);
                    System.out.println("\nThis customer has been successfully added!\n");
                }
            }
                    
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    public void removeCustomer(RoomCustomer customer){
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customer.getCustomerID()){
                roomCustomers.remove(i);
                return;
            }
        }
        
        System.out.println("\nThis customer doesn't exist!\n");
    }
    
    public void checkRoomsCustomers(){
        System.out.println("Available Rooms:\n------------------------------------------------\n");
        ArrayList<Room> availableRooms = Hotel.getInstance().printAvailableRooms();
       
          this.printRoomCustomers();
        
    }
    
    public boolean roomCustomerExists(int customerID){
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customerID)
                return true;
        }
        
        return false;
    }
    
    public RoomCustomer findCustomerByID(int customerID){
        for(int i = 0; i < roomCustomers.size(); i++){
            if(roomCustomers.get(i).getCustomerID() == customerID)
                return roomCustomers.get(i);
        }
        
        return null; //ROOM CUSTOMER WAS NOT FOUND
    }
    
    public void addRestCustomer(RestaurantCustomer customer){
        try{
            boolean exists = false;
            
            if(restaurantCustomers.size() == 0)
            {
                restaurantCustomers.add(customer);
                System.out.println("\nThis customer has been successfully added!\n");
            }
            else
            {
                for(int i = 0; i < restaurantCustomers.size(); i++){
                    
                    if(restaurantCustomers.get(i).getCustomerID() == customer.getCustomerID()){
                        System.out.println("Customer already exists!\n");
                        exists = true;
                        break;
                    }
                }

                if(exists == false){
                    restaurantCustomers.add(customer);
                    System.out.println("\nThis customer has been successfully added!\n");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    
    //Employees
    public void callWaiterMenu(){
        waiter.waiterMenu(in);
    }
    
    public void callRoomServicesMenu(){
        roomServicesEmployee.roomServicesEmployeeMenu(in);
    }
    
    public void callChefMenu(){ 
        chef.chefMenu(in);
    }
    
    public void callLaundryMenu(){
        laundryEmployee.laundryEmployeeMenu(in);
    }
    
    public void callCleaningMenu(){
        cleaningEmployee.cleaningEmployeeMenu(in);
    }

}
