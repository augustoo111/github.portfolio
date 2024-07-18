/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;

/**
 *This class represent the liftPass type and price that available at MtBuller winter resort.
 * @author August Oo
 * @version 1
 * 
 */
public class LiftPass {
    private String type;
    private double price;
    
    public LiftPass(String type){
      this.type = type;
    }
    
    public LiftPass(String type, double price){
    this.type = type;
    this.price = price;
    }
    
    public double getPrice(){
    return price;
    }
    
    public String getType(){
    return type;
    }
    public void setPrice(double price){
    this.price = price;
    }
    
    public String toString(){
        return "LiftPass Type: " + type + " & Fee: " + price;
    }
}
