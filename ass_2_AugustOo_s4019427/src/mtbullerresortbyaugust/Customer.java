/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;

import java.io.Serializable;

/**
 *This class represents a customer with details of MtBuller winter resort.
 * @author August Oo
 * @version 1
 * 
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class Customer implements Serializable {
    private int custId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String address;
    static int nextID = 100; //initial ID for customers

    private String skiingLevel;
    
    /**
     * Default constructor for creating a customer object.
     * It assigns a unique ID to the customer.
     */
    public Customer(){
        custId = nextID++; // Assign a unique ID to the customer
    }

    public Customer(String firstName, String lastName, String contact, String email, String address, String skiingLevel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.skiingLevel = skiingLevel;
        
        this.custId = nextID++; // Assign a unique ID to the customer
    }

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.custId = nextID++;
    }


    public int getCustId() {
        return custId;
    }
    

    public String getCustomerName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }



    public String getAddress() {
        return address;
    }


    public static int getNextID() {
        return nextID;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setContact(String contact) {
       this.contact = contact;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getSkiingLevel() {
        return skiingLevel;
    }

    public void setSkiingLevel(String skiingLevel) {
        this.skiingLevel = skiingLevel;
    }
    
   

    @Override
    public String toString() {
        return 
                
                "\nID: " + custId +
                ", Name: " + firstName + " " + lastName + "\n" +
                ", Skii Level: " + skiingLevel +"\n";
    }
    
    
}

