package model;

import java.util.ArrayList;
import java.util.List;

public class Landlord extends Person {
    private String landlordID;
    private List<Dorm> ownedDorms; 

    // Parameterized constructor
    public Landlord(
        String name,
        String email,
        String contactInfo,
        String address,
        String landlordID
    ) {

        super(name, contactInfo, email); // nakared linech
        this.landlordID = landlordID;
        this.ownedDorms = new ArrayList<>();
    }

    public String getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(String landlordID) {
        this.landlordID = landlordID;
    }

    public List<Dorm> getOwnedDorms() {
        return ownedDorms;
    }

    public void setOwnedDorms(List<Dorm> ownedDorms) {
        this.ownedDorms = ownedDorms;
    }

    public void addDorm(Dorm dorm) {
        if (dorm != null && !ownedDorms.contains(dorm)) {
            ownedDorms.add(dorm);
        }
    }

    @Override 
    public String displayInfo() {
        return "\nName: " + getFullName() +
               "\nLandlord ID: " + landlordID +
               "\nOwned Dorms: " + ownedDorms.size() +
               "\nEmail: " + getEmail() +
               "\nContact: " + getContactNumber();
    }

    public void postDormListing(DormListing listing) {
        System.out.println("Listing posted: " + listing.getDescription());
    }

    public void updateListing(DormListing listing, String newDesc) {
        listing.updateDescription(newDesc);
    }

    public void deleteListing(String listingID) {
        System.out.println("Listing deleted: " + listingID);
    }

    public void viewInquiries(List<Inquiry> inquiries) {
        for (Inquiry inquiry : inquiries) {
            if (inquiry.getListing().getLandlord().equals(this)) {
                System.out.println("Inquiry: " + inquiry.getMessage());
            }
        }
    }
}