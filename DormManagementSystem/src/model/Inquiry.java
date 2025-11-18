/*
 * 👤 MEMBER 3 - Antony
 * 
 * File: DormManagementSystem/src/model/Inquiry.java
 *
 * Instructions:
 * - Replace [YOUR NAME] with your name
 * - Follow the TODO hints inside this file
 * - Fill in the blanks where indicated
 * - After finishing, run the following git commands:
 *      1. git pull
 *      2. ctrl + j (open terminal)
 *      3. git add .
 *      4. git commit -m "Add Inquiry.java by [YOUR NAME]"
 *      5. git push
 * - Message the group when done!
 *
 * Notes:
 * - Very simple class
 * - Just private fields + getters + one respond() method
 * - Use hints inside TODOs
 */

package model;

public class Inquiry {

    // Attributes
    private String inquiryID;         // TODO: add your attribute
    private Student student;          // TODO: link to Student object
    private DormListing listing;      // TODO: link to DormListing object
    private String message;           // TODO: inquiry message
    private String dateInquired;      // TODO: date as String
    private String status;            // TODO: initialize as "Pending"
    private String response;          // TODO: initially empty

    // Constructor
    public Inquiry(String inquiryID, Student student, DormListing listing, String message, String dateInquired) {
        // TODO: initialize all attributes (ito yung mga this. sa unahan)
        // TODO: status = "Pending"
        // TODO: response = ""
    }

    // getters and setters po from encapsulation lesson
    public String getInquiryID() {
        // TODO: return inquiryID
    }

    public Student getStudent() {
        // TODO: return student
    }

    public DormListing getListing() {
        // TODO: return listing
    }

    public String getMessage() {
        // TODO: return message
    }

    public String getDateInquired() {
        // TODO: return dateInquired
    }

    public String getStatus() {
        // TODO: return status
    }

    public String getResponse() {
        // TODO: return response
    }

    // Methods
    public void respond(String response) {
        // TODO: set this.response = response
        // TODO: set status = "Responded"
    }

    public String displayInfo() {
        // TODO: return a string with inquiry info
        // Hint: include inquiryID, student name, message, date, status
        // katulad ng displayInfo() sa Student.java
    }
}
