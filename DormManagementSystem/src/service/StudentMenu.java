package service;

import model.*;
import util.InputValidator;
import java.util.InputMismatchException;
import ui.Main;
import java.util.Scanner;

// ========== STUDENT MENU ==========
public class StudentMenu {
    public void start(Scanner input){

        System.out.println("\n--- STUDENT LOGIN ---");
        System.out.print("Enter your student ID: ");
        String sid = input.nextLine();
        
        Student currentStudent = null;
        for (Student student : Main.students) {
            if (student.getStudentID().equals(sid)) {
                currentStudent = student;
                break;
            }
        }
        
        if (currentStudent == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println("Welcome, " + currentStudent.getfullName() + "!");

        boolean studentExit = false;
        while (!studentExit) {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Browse listings");
            System.out.println("2. Inquire about a dorm");
            System.out.println("3. Rent a room");
            System.out.println("4. Display info");
            System.out.println("5. Logout");
            System.out.print("Choice: ");
            
            try {
                int studentChoice = input.nextInt();
                input.nextLine();

                switch (studentChoice) {
                    case 1 -> browseListing();
                    case 2 -> inquireDorm(input, currentStudent);
                    case 3 -> bookRoom(input, currentStudent);
                    case 4 -> System.out.println(currentStudent.displayInfo());
                    case 5 -> {
                        studentExit = true;
                        System.out.println("Logged out successfully!");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                input.nextLine();
            }
        }
    }

    public void portal(Scanner input) {
    boolean exitPortal = false;

    while (!exitPortal) {
        System.out.println("\n--- STUDENT PORTAL ---");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Back");
        System.out.print("Choice: ");

        try {
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> start(input);  // existing login method
                case 2 -> signUp(input);
                case 3 -> exitPortal = true;
                default -> System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            input.nextLine();
        }
    }
}


    // ========== STUDENT FUNCTIONS ==========

    private void signUp(Scanner sc) {
    System.out.println("\n--- STUDENT SIGN UP ---");

    System.out.print("Full Name: ");
    String nameInput = sc.nextLine();

    System.out.print("Email: ");
    String emailInput = sc.nextLine();

    System.out.print("Phone Number: ");
    String phoneInput = sc.nextLine();

    System.out.print("Address: ");
    String addressInput = sc.nextLine();

    System.out.print("Student ID: ");
    String studentidInput = sc.nextLine();

    System.out.print("School/University: ");
    String schoolInput = sc.nextLine();

    System.out.print("Budget (Monthly): ");
    double budgetInput = sc.nextDouble();
    sc.nextLine();

    Student newStudent = new Student(
        nameInput, emailInput, phoneInput, addressInput, 
        studentidInput, schoolInput, budgetInput);
    Main.students.add(newStudent);

    System.out.println("Account created successfully!");
}



    private void browseListing() {
        System.out.println("\n--- AVAILABLE LISTINGS ---");
        if (Main.listings.isEmpty()) {
            System.out.println("No listings available.");
            return;
        }
        
        for (DormListing dormListing : Main.listings) {
            System.out.println("\nListing ID: " + dormListing.getListingID());
            System.out.println("Dorm: " + dormListing.getDorm().getDormName());
            System.out.println("Address: " + dormListing.getDorm().getAddress());
            System.out.println("Available Rooms: " + dormListing.getAvailableRooms());
            System.out.println("Monthly Rate:  ₱" + dormListing.getPriceRange());
            System.out.println("Description: " + dormListing.getDorm().getShortDescription());
        
            System.out.print("Available Room: ");
            for (Room room: dormListing.getDorm().getRooms()){
            System.out.print(room.getRoomNumber() + " ");
            }
            System.out.println();
        }
        }

       

    private void inquireDorm(Scanner sc, Student student) {
        System.out.println("\n---AVAILABLE DORM LISTINGS---");
        for (DormListing dormlisting: Main.listings){
            System.out.println("Available Listing ID: " +
             dormlisting.getListingID());
        }
        try {
            System.out.print("\nEnter listing ID to inquire: ");
            String input = sc.nextLine();
            
            DormListing selected = null;
            for (DormListing dormlisting : Main.listings) {
                if (dormlisting.getListingID().equals(input)) {
                    selected = dormlisting;
                    break;
                }
            }
            
            if (selected == null) {
                InputValidator.printError("Listing not found!");
                return;
            }
            
            System.out.print("Enter your message: ");
            String msg = sc.nextLine();
            
            if (!InputValidator.isNotEmpty(msg)) {
                InputValidator.printError("Message cannot be empty!");
                return;
            }
            
            Inquiry inquiry = new Inquiry(
                "INQ-" + System.currentTimeMillis(),
                student,
                selected,
                msg,
                "2025-12-01"
            );
            Main.inquiries.add(inquiry);
            System.out.println("Inquiry sent successfully!");
            
        } catch (Exception e) {
            System.out.println("Failed to send inquiry: " + e.getMessage());
        }
    }

    private void bookRoom(Scanner sc, Student student) {
    try {
        System.out.println("\n--- RENT A ROOM ---");
        
        if (Main.listings.isEmpty()) {
            System.out.println("No dorms available.");
            return;
        }
        
        // Step 1: Display dorms with numbers
        System.out.println("\n--- AVAILABLE DORMS ---");
        for (int i = 0; i < Main.listings.size(); i++) {
            DormListing listing = Main.listings.get(i);
            System.out.println((i + 1) + ". " + listing.getDorm().getDormName() + 
                             " - " + listing.getDorm().getAddress());
        }
        
        // Step 2: User selects dorm by number
        System.out.print("Select dorm (1-" + Main.listings.size() + "): ");
        int dormChoice = sc.nextInt();
        sc.nextLine();
        
        if (dormChoice < 1 || dormChoice > Main.listings.size()) {
            InputValidator.printError("Invalid dorm selection!");
            return;
        }
        
        Dorm selectedDorm = Main.listings.get(dormChoice - 1).getDorm();
        
        // Step 3: Display rooms in selected dorm
        System.out.println("\n--- Rooms in " + selectedDorm.getDormName() + " ---");
        for (int i = 0; i < selectedDorm.getRooms().size(); i++) {
            Room room = selectedDorm.getRooms().get(i);
            String status = room.isAvailable() ? "Available" : "Full";
            System.out.println((i + 1) + ". Room " + room.getRoomNumber() + 
                             " - ₱" + room.getPricePerMonth() + "/month - " + status);
        }
        
        // Step 4: User selects room by number
        if (selectedDorm.getRooms().size() > 1){
             System.out.print("Select room (1-" + selectedDorm.getRooms().size() + "): ");
        }
        else{
             System.out.print("Select room (1): ");
        }
       
        int roomChoice = sc.nextInt();
        sc.nextLine();
        
        if (roomChoice < 1 || roomChoice > selectedDorm.getRooms().size()) {
            InputValidator.printError("Invalid room selection!");
            return;
        }
        
        Room selectedRoom = selectedDorm.getRooms().get(roomChoice - 1);
        
        if (!selectedRoom.isAvailable()) {
            InputValidator.printError("Room is not available!");
            return;
        }
        
        // Step 5: Get dates
        System.out.print("\nEnter start date (YYYY-MM-DD): ");
        String startDate = sc.nextLine();
        
        if (!InputValidator.isValidDate(startDate)) {
            InputValidator.printError("Invalid date format!");
            return;
        }
        
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = sc.nextLine();
        
        if (!InputValidator.isValidDate(endDate)) {
            InputValidator.printError("Invalid date format!");
            return;
        }
        
        // Step 6: Book
        student.bookRoom(selectedRoom, startDate, endDate, selectedRoom.getPricePerMonth());
        System.out.println("✓ Room booked successfully!");
        
    } catch (InputMismatchException e) {
        System.out.println("✗ Please enter a valid number!");
        sc.nextLine();
    } catch (Exception e) {
        System.out.println("✗ Booking failed: " + e.getMessage());
    }
}
}