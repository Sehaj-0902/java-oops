import java.util.ArrayList;

// Abstract class
abstract class Vehicle implements Insurable {
    // Class fields
    private String vehicleNumber;
    protected String type;
    protected double rentalRate;
    private String insurancePolicyNumber;
    private double insuranceRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceRate = insuranceRate;
    }

    // Method to get vehicle number
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    // Method to get insurance policy number
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // Method to get insurance rate
    public double getInsuranceRate() {
        return insuranceRate;
    }

    // Abstract method to calculate rental cost
    abstract double calculateRentalCost(int days);

    // Method to display vehicle details
    public void displayVehicleDetails(int days) {
        System.out.println("Vehicle Number: " + getVehicleNumber());
        System.out.println("Type: " + type);
        System.out.println("Rental Rate (per day): " + rentalRate);
        System.out.println("Rental Cost: " + calculateRentalCost(days));
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println("Insurance Details: " + getInsuranceDetails());
    }
}

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Subclass
class Car extends Vehicle {
    // Subclass constructor
    public Car(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        // Calling superclass constructor
        super(vehicleNumber, type, rentalRate, insurancePolicyNumber, insuranceRate);
    }

    // Method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    // Method to calculate insurance
    @Override
    public double calculateInsurance() {
        return rentalRate * getInsuranceRate();
    }

    // Method to get insurance details
    @Override
    public String getInsuranceDetails() {
        return "\nInsurance Policy Number: " + getInsurancePolicyNumber();
    }
}

// Subclass
class Bike extends Vehicle {
    // Subclass constructor
    public Bike(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        // Calling superclass constructor
        super(vehicleNumber, type, rentalRate, insurancePolicyNumber, insuranceRate);
    }

    // Method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    // Method to calculate insurance
    @Override
    public double calculateInsurance() {
        return rentalRate * getInsuranceRate();
    }

    // Method to get insurance details
    @Override
    public String getInsuranceDetails() {
        return "\nInsurance Policy Number: " + getInsurancePolicyNumber();
    }
}

// Subclass
class Truck extends Vehicle {
    // Subclass constructor
    public Truck(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        // Calling superclass constructor
        super(vehicleNumber, type, rentalRate, insurancePolicyNumber, insuranceRate);
    }

    // Method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    // Method to calculate insurance
    @Override
    public double calculateInsurance() {
        return rentalRate * getInsuranceRate();
    }

    // Method to get insurance details
    @Override
    public String getInsuranceDetails() {
        return "\nInsurance Policy Number: " + getInsurancePolicyNumber();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car("AB123", "Car", 35, "CI000123", 1.5);
        vehicles.add(vehicle1);

        Vehicle vehicle2 = new Bike("MN123", "Bike", 25, "BI000123", 0.5);
        vehicles.add(vehicle2);

        Vehicle vehicle3 = new Car("XY123", "Truck", 45, "TI000123", 2.5);
        vehicles.add(vehicle3);

        for ( Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails(3);
            System.out.println();
        }
    }
}

/*
Output:
    Vehicle Number: AB123
    Type: Car
    Rental Rate (per day): 35.0
    Rental Cost: 105.0
    Insurance Cost: 52.5
    Insurance Details:
    Insurance Policy Number: CI000123

    Vehicle Number: MN123
    Type: Bike
    Rental Rate (per day): 25.0
    Rental Cost: 75.0
    Insurance Cost: 12.5
    Insurance Details:
    Insurance Policy Number: BI000123

    Vehicle Number: XY123
    Type: Truck
    Rental Rate (per day): 45.0
    Rental Cost: 135.0
    Insurance Cost: 112.5
    Insurance Details:
    Insurance Policy Number: TI000123
 */