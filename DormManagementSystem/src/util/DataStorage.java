package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
import ui.Main;  // Import for initializeData

public class DataStorage {

    private static final String FILE_NAME = "database.dat";

    // Central storage lists
    public static List<Dorm> dorms = new ArrayList<>();
    public static List<DormListing> listings = new ArrayList<>();
    public static List<Landlord> landlords = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<Inquiry> inquiries = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Person> person = new ArrayList<>();

    // ID trackers (optional, for auto-incrementing)
    private static int nextStudentId = 1;
    // Add similar for other entities if needed (e.g., nextLandlordId, nextDormId)

    public static int getNextStudentId() {
        return nextStudentId++;
    }

    // Wrapper to store everything together
    private static class Database implements Serializable {
        private static final long serialVersionUID = 1L;

        List<Dorm> dorms;
        List<DormListing> listings;
        List<Landlord> landlords;
        List<Student> students;
        List<Inquiry> inquiries;
        List<Room> rooms;
        List<Person> person;
    }

    // Save all data into file
    public static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            Database data = new Database();
            data.dorms = dorms;
            data.listings = listings;
            data.landlords = landlords;
            data.students = students;
            data.inquiries = inquiries;
            data.rooms = rooms;
            data.person = person;

            out.writeObject(data);
            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Saving Error: " + e.getMessage());
        }
    }

    // Load all data from file
    public static void load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("ℹ No previous data found. Starting with empty database.");
            // Initialize sample data since no file exists
            Main.initializeData();
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            Database data = (Database) in.readObject();

            // Safely assign lists, initializing to empty if null
            dorms = data.dorms != null ? data.dorms : new ArrayList<>();
            listings = data.listings != null ? data.listings : new ArrayList<>();
            landlords = data.landlords != null ? data.landlords : new ArrayList<>();
            students = data.students != null ? data.students : new ArrayList<>();
            inquiries = data.inquiries != null ? data.inquiries : new ArrayList<>();
            rooms = data.rooms != null ? data.rooms : new ArrayList<>();
            person = data.person != null ? data.person : new ArrayList<>();

            // Update ID trackers based on loaded data to avoid conflicts
            updateIdTrackers();

            // If no students were loaded, initialize sample data
            if (students.isEmpty()) {
                Main.initializeData();
            }

            System.out.println("Data loaded successfully.");

        } catch (Exception e) {
            System.out.println("Loading Error: " + e.getMessage() + ". Starting with empty database.");
            // Initialize empty lists on failure and add sample data
            dorms = new ArrayList<>();
            listings = new ArrayList<>();
            landlords = new ArrayList<>();
            students = new ArrayList<>();
            inquiries = new ArrayList<>();
            rooms = new ArrayList<>();
            person = new ArrayList<>();
            Main.initializeData();
        }
    }

    // Helper method to update ID trackers from loaded data
    private static void updateIdTrackers() {
        // Update nextStudentId
        int maxStudentId = 0;
        for (Student s : students) {
            try {
                // Assuming ID format like "S001" - extract the number
                int idNum = Integer.parseInt(s.getStudentID().substring(1));
                if (idNum > maxStudentId) maxStudentId = idNum;
            } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                // Skip invalid IDs
            }
        }
        nextStudentId = maxStudentId + 1;
    }
}