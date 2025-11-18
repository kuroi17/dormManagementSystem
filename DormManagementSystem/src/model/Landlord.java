/*
 * 👤 MEMBER 1 - Shin
 * 
 * File: DormManagementSystem/src/model/Landlord.java
 *
 * Instructions:
 * - Replace [MEMBER 1 NAME] with your name
 * - Follow the TODO hints inside this file
 * - Fill in the blanks where indicated
 * - After finishing, run the following git commands:
 *      1. git pull
 *      2. ctrl + j (open terminal)
 *      3. git add .
 *      4. git commit -m "Add Landlord.java by [MEMBER 1 NAME]"
 *      5. git push
 * - Message the group when done! 
 *
 * Notes:
 * - This class is almost the same as Student.java
 * - You need to complete the parts marked with TODO
 */

package model;
import java.util.ArrayList;
import java.util.List;

public class Landlord extends Person {

    // Attributes
    private String landlordID;    // TODO: add your attribute here
    private List<Dorm> ownedDorms; // TODO: initialize in constructor

    // Constructor
    public Landlord(String name, String email, String contactInfo, String address, String landlordID) {
        //  (ito yung may mga this. sa unahan
        // TODO: Call super constructor
        // TODO: initialize landlordID
        // TODO: initialize ownedDorms
    }

     // getters and setters po from enscapsulation lesson
    public String getLandlordID() {
        // TODO: return landlordID
    }

    public void setLandlordID(String landlordID) {
        // TODO: set landlordID with validation if needed
    }

    public List<Dorm> getOwnedDorms() {
        // TODO: return the list of dorms
    }

    // Methods
    public void addDorm(Dorm dorm) {
        // TODO: add dorm to ownedDorms (optional: check for duplicates)
    }

    @Override
    public String displayInfo() {
        // TODO: override displayInfo() to show landlord info
        // Hint: include name, ID, email, contact, number of owned dorms
        // katulad lang nung nasa Student.java
    }
}
