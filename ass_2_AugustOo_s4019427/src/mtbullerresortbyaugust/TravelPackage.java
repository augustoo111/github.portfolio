/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;

/**
 *This lass represents the customer trip package to MtBuller winter resort.
 * @author August Oo
 * @version 1.0
 * 
 */


import java.io.Serializable;
import java.time.LocalDate;

public class TravelPackage implements Serializable {

    
    private static int nextID = 10;
    private int travelPackageId;
    private int cutId;
    private LocalDate startDate;
    private int duration;
    private double accommodationCost;
    private Accommodation accommodation;
    private double liftpassCost;
    private double totalLessonFee;
    private double totalCost;
    private int accommodationId;
    private double lessonFee;
    private int lessonCount;
    private String lessonType;
    private String selectedLiftPassType;
    private Customer customer;
    
    public TravelPackage() {
        this.travelPackageId = nextID++;
        

    }
    
    public TravelPackage(Customer customer,Accommodation accommodation, LocalDate startDate, int duration) {
        this.customer = customer;
        this.accommodation = accommodation;
        this.startDate = startDate;
        this.duration = duration;
        this.travelPackageId = nextID++;

    }
    public TravelPackage(int cutId, LocalDate startDate, int duration) {
        this.cutId = cutId;
        this.startDate = startDate;
        this.duration = duration;
        this.travelPackageId = nextID++;

    }
        public TravelPackage(int cutId, int accommodationId, LocalDate startDate, int duration) {
        this.cutId = cutId;
        this.accommodationId = accommodationId;
        this.startDate = startDate;
        this.duration = duration;
        this.travelPackageId = nextID++;

    }
    
    

    // Getters and setters
        public int getTravelPackageId() {
            return travelPackageId;
        }

        public int getCutId() {
            return cutId;
        }

        public void setCutId(int cutId) {
            this.cutId = cutId;
        }
        

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Accommodation getAccommodation() {
            return accommodation;
        }
        public Customer getCustomer(){
            return customer;
        }
        public void setCustomer(Customer customer){
            this.customer = customer;
        }

        public void setAccommodation(Accommodation accommodation) {
            this.accommodation = accommodation;
        }

        public String getLiftPassType() {
            return selectedLiftPassType;
        }

        public void setLiftPassType(String selectedLiftPassType) {
            this.selectedLiftPassType = selectedLiftPassType;
        }

        public double getLiftpassCost() {
            return liftpassCost;
        }

        public void setLiftpassCost(double liftpassCost) {
            this.liftpassCost = liftpassCost;
        }


        public static int getNextID() {
            return nextID;
        }

        public static void setNextID(int nextID) {
            TravelPackage.nextID = nextID;
        }

        public double getTotalLessonFee() {
            return totalLessonFee;
        }

        public void setTotalLessonFee(double totalLessonFee) {
            this.totalLessonFee = totalLessonFee;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }

        public int getAccommodationId() {
            return accommodation.getId();
        }

        public void setAccommodationId(int accommodationId) {
            this.accommodationId = accommodationId;
        }

        public double getLessonFee() {
            return lessonFee;
        }

        public void setLessonFee(double lessonFee) {
            this.lessonFee = lessonFee;
        }

        public int getLessonCount() {
            return lessonCount;
        }

        public void setLessonCount(int lessonCount) {
            this.lessonCount = lessonCount;
        }

        public String getLessonType() {
            return lessonType;
        }

        public void setLessonType(String lessonType) {
            this.lessonType = lessonType;
        }

        void totalAccommodationCost(double accommodationCost) {
            this.accommodationCost = accommodationCost;

        }



    // toString method
        @Override
        public String toString() {
            return "ID: " + travelPackageId;
        }
}
