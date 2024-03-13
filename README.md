# Hotel Management System

This project is a hotel management system developed as part of a university project in Object-Oriented Programming (OOP) using Java.

## Description

The Hotel Management System is designed to streamline various aspects of hotel management, including room reservations, guest check-ins, check-outs, billing, and staff management. The system aims to improve operational efficiency and enhance the overall guest experience.

## Usage

1. **Welcome Screen**: Upon running the program, a window displaying an image of the hotel with a "Next" button will appear. The title of the window will be "Hotel Management System".

2. **Login Page**: After clicking the "Next" button, you will be redirected to a login page where you must log in as either an admin or a guest. If the account isn't already logged in, you'll be prompted to sign up. This page will consist of two options: "Admin" and "Guest". The corresponding classes for this stage are Admin, Guest, and Form.

   - **Admin Login**: If you choose to log in as an admin, you'll be required to enter the admin username and password. By default, there is only one username and password for admins unless additional accounts are added to the list. The Admin class will contain a method to authenticate the admin's credentials. Once authenticated, the admin must fill out a form with their details for validation, unless their name already exists in the system. If the admin's details exist in the login history, they can select their profile from a dropdown list.

   - **Guest Login**: (To be implemented)
  
# Classes and Methods

## Form

- `username` and `password` (String)
- Constructors
- Getters and setters for usernames and passwords
- `validation` method which checks if the username and password are correct

## Employee

- List of employees
- `usageFrequency` attribute to track how many times an employee logs in
- `name`, `age`, and `salary`
- Constructors
- Getters and setters
- `toString` method
- `validation` method which overrides the one from `Form`
- `logInHistory` method to render names of employees who have logged in before on a dropdown list

## Admin (extends Employee)

- List of admins (type `Form`) containing usernames and passwords
- List of accessibility in the hotel
- List of `Form` objects to add new usernames and passwords for admins
- Constructors with various parameters
- `validation` method which overrides the one from `Form`
- `addEmployee` method to add a new employee to the list
- `addUserAdmin` method to add a new username and password
- `addLogInFrequency` method to update login frequency


## Installation

To run the Hotel Management System on your local machine, follow these steps:

1. Clone this repository to your local machine using `git clone`.
2. Open the project in your preferred Java IDE.
3. Build the project and resolve any dependencies.
4. Run the application.

## Contributing

Contributions to this project are welcome! If you have any suggestions for improvements or new features, please feel free to submit a pull request or open an issue.

