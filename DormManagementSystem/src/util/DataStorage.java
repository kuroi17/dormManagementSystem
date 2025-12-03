package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
import ui.Main;

public class DataStorage {

    private static final String FILE_NAME = "database.dat";

    public static class Database implements Serializable {
        private static final long serialVersionUID = 1L;

        private List<Dorm> dorms = new ArrayList<>();
        private List<DormListing> listings = new ArrayList<>();
        private List<Landlord> landlords = new ArrayList<>();
        private List<Student> students = new ArrayList<>();
        private List<Inquiry> inquiries = new ArrayList<>();
        private List<Room> rooms = new ArrayList<>();
        private List<Person> persons = new ArrayList<>();

        public List<Dorm> getDorms() { return dorms; }
        public List<DormListing> getListings() { return listings; }
        public List<Landlord> getLandlords() { return landlords; }
        public List<Student> getStudents() { return students; }
        public List<Inquiry> getInquiries() { return inquiries; }
        public List<Room> getRooms() { return rooms; }
        public List<Person> getPersons() { return persons; }

        public void setDorms(List<Dorm> dorms) { this.dorms = dorms; }
        public void setListings(List<DormListing> listings) { this.listings = listings; }
        public void setLandlords(List<Landlord> landlords) { this.landlords = landlords; }
        public void setStudents(List<Student> students) { this.students = students; }
        public void setInquiries(List<Inquiry> inquiries) { this.inquiries = inquiries; }
        public void setRooms(List<Room> rooms) { this.rooms = rooms; }
        public void setPersons(List<Person> persons) { this.persons = persons; }
    }

    private static Database db = new Database();
    private static int nextStudentId = 1;

    public static int getNextStudentId() {
        return nextStudentId++;
    }

    public static Database getDatabase() {
        return db;
    }

    public static void save() {
        File file = new File(FILE_NAME);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            Main.initializeData();
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            db = (Database) in.readObject();
            updateIdTrackers();
        } catch (Exception e) {
            e.printStackTrace();
            db = new Database();
            Main.initializeData();
        }
    }

    private static void updateIdTrackers() {
        int maxId = 0;

        for (Student s : db.getStudents()) {
            try {
                int idNum = Integer.parseInt(s.getStudentID().substring(1));
                if (idNum > maxId) maxId = idNum;
            } catch (Exception ignored) {}
        }

        nextStudentId = maxId + 1;
    }
}