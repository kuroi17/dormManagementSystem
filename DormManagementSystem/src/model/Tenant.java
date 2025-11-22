package model;
/*
 * represents a tenant in this system 
 * who is currently renting a dorm room
 *   @author Kuroi
 * 
 * 
 * 
 */
public class Tenant extends Person {
    private String tenantID;
    private String studentID; // Can link back to original Student if needed
    private Room rentedRoom; // TODO: Wait for Room.java by Cole
    private String leaseStartDate; // Simple String for now (e.g., "2025-01-15")
    private String leaseEndDate;
    private double monthlyRent;
    private String paymentStatus; // "Paid", "Pending", "Overdue"


    public Tenant (
        String name,
        String email, 
        String contactInfo,
        String address,
        String tenantID,
        String studentID,
        double monthlyRent,
        String leaseStartDate,
        String leaseEndDate
    ) {
        // use super to call Person constructor
        super(name, email, contactInfo, address); // from Person class 
        this.tenantID = tenantID;
        this.studentID = studentID;
        this.monthlyRent = monthlyRent;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.paymentStatus = "Pending"; // Default status
        this.rentedRoom = null; // Will be set when assigned
    }

    // use special methods(getters and setters) from encapsulation
     public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Room getRentedRoom() {
        return rentedRoom;
    }

    public void setRentedRoom(Room rentedRoom) {
        this.rentedRoom = rentedRoom;
    }

    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public String getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(String leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Methods specific to Tenant
    public void payRent() {
        this.paymentStatus = "Paid";
        System.out.println("Payment recorded for Tenant: " + getName());
    }

    public boolean isLeaseActive() {
        // Simple check (can be improved with actual date comparison later)
        return !paymentStatus.equals("Overdue");
    }

    @Override // implementation of abstract method from Person class 
    public String displayInfo() {
        return "\n=== TENANT INFO ===" +
               "\nName: " + getName() +
               "\nTenant ID: " + tenantID +
               "\nStudent ID: " + studentID +
               "\nMonthly Rent: ₱" + String.format("%.2f", monthlyRent) +
               "\nLease Period: " + leaseStartDate + " to " + leaseEndDate +
               "\nPayment Status: " + paymentStatus +
               "\nEmail: " + getEmail() +
               "\nContact: " + getContactInfo() +
               "\nAddress: " + getAddress();
    }
}