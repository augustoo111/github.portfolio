/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *This class represents accommodation type that available in MtBuller winter resort.
 * @author August Oo
 * @version 1.0
 * 
 */
public class Accommodation implements Serializable {

    
    
    private int id;
    private String type;
    private double price;
    static int nextID = 1;
    private boolean availability = true;
    private String image;
    private String name;


    public Accommodation () {
    }
    public Accommodation(String type, int price, String image, String name) {
        this.type = type;
        this.price = price;
        //this.imagePath = imagePath;
        id = nextID++;
        this.image = image;
        this.name = name;
    }
    
    public Accommodation(String type, double price){
        
        this.type = type;
        this.price = price;
        id = nextID++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Accommodation.nextID = nextID;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     


    
    @Override
    public String toString() {
        return  "\nID: " + id +
                "\n, Type: " + type + 
                "\n, Price: " + price 
               // "\nAvailable " + availability 
               ;
    }

    boolean isAvailable() {
        return availability;
    }
    
}
