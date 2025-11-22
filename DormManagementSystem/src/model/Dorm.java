package model;


import java.util.ArrayList;
import java.util.List;


/*
 * 
 * 
 * @author Kuroi 
 */

 public class Dorm {
    private String dormName;
    private List <Room> rooms;
    private List <Tenant> tenants;
    private String googleMapLink;
    private String address;
    public String shortDescription;


    public Dorm (
        String dormName,
        List <Room> rooms,
        List <Tenant> tenants,
        String googleMapLink,
        String address,
        String shortDescription
    ){
        this.dormName = dormName;
        this.rooms = rooms;
        this.tenants = tenants;
        this.googleMapLink = googleMapLink;
        this.address = address;
        this.shortDescription = shortDescription;

    }

    public String getDormName (){
        return dormName;
    }

    public void setDormName(String dormName){
        this.dormName = dormName;
    }
    public List <Room> getRooms (){
        return rooms;
    }
    public void setRooms (List <Room> rooms){
        this.rooms = rooms;
    }
    public List <Tenant> getTenants (){
        return tenants;
    }
    public void setTenants (List <Tenant> tenants){
        this.tenants = tenants;
    }
    public String getGoogleMapLink (){
        return googleMapLink;
    }
    public void setGoogleMapLink (String googleMapLink){
        this.googleMapLink = googleMapLink;
    }
    public String getAddress (){
        return address;
    }
    public void setAddress (String address){
        this.address = address;
    }
    public String getShortDescription (){
        return shortDescription;
    }
    public void setShortDescription (String shortDescription){
        this.shortDescription = shortDescription;
    }
    
    @Override  // implementation of abstract method from Person class 
    public String displayInfo(){
        return "Dorm Name: " + dormName + "\n" +
               "Address: " + address + "\n" +
               "Google Map Link: " + googleMapLink + "\n" +
               "Short Description: " + shortDescription + "\n" +
               "Number of Rooms: " + rooms.size() + "\n" +
               "Number of Tenants: " + tenants.size();
    } 


 }