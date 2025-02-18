/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.classinheritance;

/**
 *
 * @author JHoang2026
 */
import java.util.*;
public class ClassInheritance {

    public static void main(String[] args){
        
            //child object that inherits Car
            ElectricCar ec = new ElectricCar("Tesla Model 3", 120.0, 5, 500.0, 25.0, 75.0, 350);
            //Printing the electric car details
            System.out.println(ec);
            
            //child object that inherits Car
             LuxuryCar lc = new LuxuryCar("Mercedes-Benz S-Class", 150.0, 5, 500.0, 22.0, true, true, true, "Leather");
            // Printing the LuxuryCar details
            System.out.println(lc);
            
            //child object that inherits Vehicle (boat)
            SpeedBoat sb = new SpeedBoat("Sunseeker", 55.0, 6, 1500.0, "Motorboat", 500.0);
            // Printing the SpeedBoat details
            System.out.println(sb);
            
            //child object that inherits Vehicle (boat)
            LuxuryYacht ly = new LuxuryYacht("Ocean Star", 35.0, 12, 50000.0, 
                                                     "Motorboat", 
                                                     "Pool, Jacuzzi, Cinema Room, Bar, Sauna", 
                                                     15, true);
            // Printing the LuxuryYacht details
            System.out.println(ly);
            
            //child object that inherits Vehicle (airplane)
            CommercialAirliner ca = new CommercialAirliner("Airbus A380", 575.0, 850, 80000.0, 4, 500, 70000.0);
            // Printing the second CommercialAirliner details
            System.out.println(ca);
            
            //child object that inherits Vehicle (airplane)
            PrivateJet pj = new PrivateJet("Gulfstream G650", 600.0, 12, 20000.0, 2, true, "Leather");
            // Printing the PrivateJet details
            System.out.println(pj);
            
            //child object that inherits Vehicle (electricscooter)
            ElectricScooter es = new ElectricScooter("Xiaomi Mi Electric Scooter", 20.0, 1, 20.0, 0.5, 30);
            // Printing the ElectricScooter details
            System.out.println(es);
            
            //child object that inherits Vehicle (motorcycle)
            Motorcycle mc = new Motorcycle("Harley Davidson", 120.0, 2, 300.0, false);
            // Printing the Motorcycle details
            System.out.println(mc);
    }
}

// The Base Vehicle Class, implements the Speedometer interface
class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;
    //Base default constructor 
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
        cargoWeight = 0.0;
    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    //getters and setters
    public Vehicle(String inBrand){
        brandName = inBrand;
    }

    public String getBrand(){
        return brandName;
    }

    public  void setBrandName(String inBrand){
        brandName = inBrand;
    }

    public double getSpeed(){
        return  speed;
    }

    public void setSpeed(double inSpeed){
        speed = inSpeed;
    }

    public int getPassengers(){
        return  passengers;
    }

    public void setPassengers(int inPassengers){
        speed = inPassengers;
    }

    public double getCargoWeight(){
        return  cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight){
        cargoWeight = inCargoWeight;
    }

    //Base toString
    public String toString(){
        String result = "";
        result = "Brand: \t\t\t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
    public void setSpeed(double inSpeed);
    public double getSpeed();
 }


// Car Class inherits from Vehicle Class
class Car extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setSpoiler(boolean inSpoiler){
        spoiler = inSpoiler;
    }

    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
    public void setStereo(boolean inStereo){
        stereo = inStereo;
    }

    public boolean getStereo(){
        return  stereo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "MPG :\t\t\t" + this.getMPG() + "\n";
        return  result ;
    }
}
// ElectricCar Class inherits from Car
class ElectricCar extends Car {
    private double batteryCapacity;  // in kWh
    private int maxRange;            // in miles

    // Constructor that calls the superclass (Car) constructor
    public ElectricCar(String brand, double speed, int passengers, double cargoWeight, double mpg, double batteryCapacity, int maxRange) {
        super(brand, speed, passengers, cargoWeight, mpg);  // Call Car constructor
        this.batteryCapacity = batteryCapacity;
        this.maxRange = maxRange;
    }

    // Getters and Setters for battery capacity and range
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public double getSpeed() {
        // Electric cars can have better acceleration, so let's add a small speed boost (e.g., +10 mph) for quick acceleration
        return super.getSpeed() + 10;
    }

    @Override
    public String toString() {
        // Append the Electric Car-specific details to the Car's toString method
        return super.toString() + 
               "Battery Capacity: " + batteryCapacity + " kWh\n" + 
               "Max Range: " + maxRange + " miles\n" + 
               "Modified Speed (with electric boost): " + getSpeed() + " mph\n";
    }
}

//child class that extends Car
// LuxuryCar Class inherits from Car
class LuxuryCar extends Car {
    private boolean leatherSeats;           // True if the car has leather seats
    private boolean premiumSoundSystem;     // True if the car has a premium sound system
    private boolean advancedSafetyFeatures; // True if the car has advanced safety features
    private String interiorMaterial;        // Type of interior material (e.g., leather, suede)

    // Constructor that calls the superclass (Car) constructor
    public LuxuryCar(String brand, double speed, int passengers, double cargoWeight, 
                     double mpg, boolean leatherSeats, boolean premiumSoundSystem, 
                     boolean advancedSafetyFeatures, String interiorMaterial) {
        super(brand, speed, passengers, cargoWeight, mpg);  // Call Car constructor
        this.leatherSeats = leatherSeats;
        this.premiumSoundSystem = premiumSoundSystem;
        this.advancedSafetyFeatures = advancedSafetyFeatures;
        this.interiorMaterial = interiorMaterial;
    }

    // Getters and Setters for the new properties
    public boolean hasLeatherSeats() {
        return leatherSeats;
    }

    public void setLeatherSeats(boolean leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public boolean hasPremiumSoundSystem() {
        return premiumSoundSystem;
    }

    public void setPremiumSoundSystem(boolean premiumSoundSystem) {
        this.premiumSoundSystem = premiumSoundSystem;
    }

    public boolean hasAdvancedSafetyFeatures() {
        return advancedSafetyFeatures;
    }

    public void setAdvancedSafetyFeatures(boolean advancedSafetyFeatures) {
        this.advancedSafetyFeatures = advancedSafetyFeatures;
    }

    public String getInteriorMaterial() {
        return interiorMaterial;
    }

    public void setInteriorMaterial(String interiorMaterial) {
        this.interiorMaterial = interiorMaterial;
    }

    @Override
    public double getSpeed() {
        // Luxury cars often have slightly better performance, so we add a small speed boost (e.g., +15 mph)
        return super.getSpeed() + 15;
    }

    @Override
    public String toString() {
        // Add luxury features to the standard car details
        return super.toString() + 
               "Leather Seats: " + (leatherSeats ? "Yes" : "No") + "\n" +
               "Premium Sound System: " + (premiumSoundSystem ? "Yes" : "No") + "\n" +
               "Advanced Safety Features: " + (advancedSafetyFeatures ? "Yes" : "No") + "\n" +
               "Interior Material: " + interiorMaterial + "\n" +
               "Modified Speed (Luxury Performance): " + getSpeed() + " mph\n";
    }
}
// Boat Class inherits from Vehicle
class Boat extends Vehicle {
    private String typeOfBoat; // e.g., Sailboat, Motorboat, etc.
    
    public Boat(String brand, double speed, int passengers, double cargoWeight, String typeOfBoat) {
        super(brand, speed, passengers, cargoWeight);
        this.typeOfBoat = typeOfBoat;
    }

    public String getTypeOfBoat() {
        return typeOfBoat;
    }

    public void setTypeOfBoat(String typeOfBoat) {
        this.typeOfBoat = typeOfBoat;
    }

    @Override
    public String toString() {
        return super.toString() +
               "Type of Boat: " + typeOfBoat + "\n";
    }
}
// SpeedBoat Class inherits from Boat Class
class SpeedBoat extends Boat {
    private double engineHorsepower;

    public SpeedBoat(String brand, double speed, int passengers, double cargoWeight, String typeOfBoat, double engineHorsepower) {
        super(brand, speed, passengers, cargoWeight, typeOfBoat);
        this.engineHorsepower = engineHorsepower;
    }

    public double getEngineHorsepower() {
        return engineHorsepower;
    }

    public void setEngineHorsepower(double engineHorsepower) {
        this.engineHorsepower = engineHorsepower;
    }

    @Override
    public double getSpeed() {
        // Speedboat's speed depends on engine power (let's assume 10 mph per 100 horsepower)
        return super.getSpeed() + (engineHorsepower / 100 * 10);
    }

    @Override
    public String toString() {
        return super.toString() +
               "Engine Horsepower: " + engineHorsepower + " HP\n" +
               "Modified Speed: " + getSpeed() + " mph\n";
    }
}
// LuxuryYacht Class inherits from Boat
class LuxuryYacht extends Boat {
    private String luxuryAmenities;    // Luxury amenities on the yacht (e.g., pool, jacuzzi, cinema room)
    private int numCrewMembers;        // Number of crew members on board
    private boolean hasHelipad;        // True if the yacht has a helipad for helicopters

    // Constructor for LuxuryYacht
    public LuxuryYacht(String brand, double speed, int passengers, double cargoWeight, 
                       String typeOfBoat, String luxuryAmenities, int numCrewMembers, boolean hasHelipad) {
        super(brand, speed, passengers, cargoWeight, typeOfBoat);  // Call Boat constructor
        this.luxuryAmenities = luxuryAmenities;
        this.numCrewMembers = numCrewMembers;
        this.hasHelipad = hasHelipad;
    }

    // Getters and Setters for the new properties
    public String getLuxuryAmenities() {
        return luxuryAmenities;
    }

    public void setLuxuryAmenities(String luxuryAmenities) {
        this.luxuryAmenities = luxuryAmenities;
    }

    public int getNumCrewMembers() {
        return numCrewMembers;
    }

    public void setNumCrewMembers(int numCrewMembers) {
        this.numCrewMembers = numCrewMembers;
    }

    public boolean hasHelipad() {
        return hasHelipad;
    }

    public void setHasHelipad(boolean hasHelipad) {
        this.hasHelipad = hasHelipad;
    }

    @Override
    public String toString() {
        // Add luxury-specific features to the standard boat details
        return super.toString() +
               "Luxury Amenities: " + luxuryAmenities + "\n" +
               "Number of Crew Members: " + numCrewMembers + "\n" +
               "Has Helipad: " + (hasHelipad ? "Yes" : "No") + "\n";
    }
}

// Airplane Class inherits from Vehicle
class Airplane extends Vehicle {
    private int engineCount;

    public Airplane(String brand, double speed, int passengers, double cargoWeight, int engineCount) {
        super(brand, speed, passengers, cargoWeight);
        this.engineCount = engineCount;
    }

    public int getEngineCount() {
        return engineCount;
    }

    public void setEngineCount(int engineCount) {
        this.engineCount = engineCount;
    }

    @Override
    public String toString() {
        return super.toString() +
               "Engine Count: " + engineCount + "\n";
    }
}
// CommercialAirliner Class inherits from Airplane
class CommercialAirliner extends Airplane {
    private int seatingCapacity;
    private double fuelCapacity;

    public CommercialAirliner(String brand, double speed, int passengers, double cargoWeight, int engineCount, int seatingCapacity, double fuelCapacity) {
        super(brand, speed, passengers, cargoWeight, engineCount);
        this.seatingCapacity = seatingCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public double getSpeed() {
        // Commercial airliners fly at a very high speed, so we add a bonus
        return super.getSpeed() + 250; // adding 250 mph
    }

    @Override
    public String toString() {
        return super.toString() +
               "Seating Capacity: " + seatingCapacity + " passengers\n" +
               "Fuel Capacity: " + fuelCapacity + " gallons\n" +
               "Modified Speed: " + getSpeed() + " mph\n";
    }
}
// PrivateJet Class inherits from Airplane
class PrivateJet extends Airplane {
    private boolean hasWiFi;
    private String interiorMaterial;

    public PrivateJet(String brand, double speed, int passengers, double cargoWeight, int engineCount, boolean hasWiFi, String interiorMaterial) {
        super(brand, speed, passengers, cargoWeight, engineCount);
        this.hasWiFi = hasWiFi;
        this.interiorMaterial = interiorMaterial;
    }

    public boolean hasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public String getInteriorMaterial() {
        return interiorMaterial;
    }

    public void setInteriorMaterial(String material) {
        this.interiorMaterial = material;
    }

    @Override
    public double getSpeed() {
        // Private jets are faster than commercial airliners, so we add more speed
        return super.getSpeed() + 300;
    }

    @Override
    public String toString() {
        return super.toString() +
               "Has WiFi: " + (hasWiFi ? "Yes" : "No") + "\n" +
               "Interior Material: " + interiorMaterial + "\n" +
               "Modified Speed: " + getSpeed() + " mph\n";
    }
}
// ElectricScooter Class inherits from Vehicle Class
class ElectricScooter extends Vehicle {
    private double batteryCapacity;  // in kWh
    private int maxRange;            // in miles

    public ElectricScooter(String brand, double speed, int passengers, double cargoWeight, double batteryCapacity, int maxRange) {
        super(brand, speed, passengers, cargoWeight);
        this.batteryCapacity = batteryCapacity;
        this.maxRange = maxRange;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public double getSpeed() {
        // Electric scooters typically have a speed limit, so we cap it at 25 mph
        return Math.min(super.getSpeed(), 25);
    }

    @Override
    public String toString() {
        return super.toString() +
               "Battery Capacity: " + batteryCapacity + " kWh\n" +
               "Max Range: " + maxRange + " miles\n" +
               "Modified Speed: " + getSpeed() + " mph\n";
    }
}
// Motorcycle Class inherits from Vehicle
class Motorcycle extends Vehicle {
    private int wheels = 2;        // Motorcycles typically have 2 wheels
    private boolean isSportBike;   // True if the motorcycle is a sport bike

    // Constructor
    public Motorcycle(String brand, double speed, int passengers, double cargoWeight, boolean isSportBike) {
        super(brand, speed, passengers, cargoWeight);  // Call Vehicle constructor
        this.isSportBike = isSportBike;
    }

    // Getter and Setter for the sport bike status
    public boolean isSportBike() {
        return isSportBike;
    }

    public void setSportBike(boolean isSportBike) {
        this.isSportBike = isSportBike;
    }

    @Override
    public String toString() {
        return super.toString() +
               "Wheels: " + wheels + "\n" +
               "Sport Bike: " + (isSportBike ? "Yes" : "No") + "\n";
    }
}
