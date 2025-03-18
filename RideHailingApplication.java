// Abstract class
abstract class VehicleInfo {
    // Class fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public VehicleInfo(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Method to get vehicle Id
    public String getVehicleIdId() {
        return vehicleId;
    }

    // Method to get driver name
    public String getDriverName() {
        return driverName;
    }

    // Method to get rate per km
    public double getRatePerKm() {
        return ratePerKm;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + getVehicleIdId());
        System.out.println("Driver Name: " + getDriverName());
        System.out.println("Rate per Km: Rs " + getRatePerKm());
    }
}

// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass
class CarInfo extends VehicleInfo implements GPS {
    // Class fields
    private String currentLocation;

    // Subclass constructor
    public CarInfo(String vehicleId, String driverName, String initialLocation) {
        // Calling superclass constructor
        super(vehicleId, driverName, 20.0);
        this.currentLocation = initialLocation;
    }

    // Method to calculate fare
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Method to get current location
    @Override
    public String getCurrentLocation() {
        return "Car's Current Location: " + currentLocation;
    }

    // Method to update location
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Car location updated to: " + newLocation);
    }
}

// Subclass
class BikeInfo extends VehicleInfo implements GPS {
    // Class attributes
    private String currentLocation;

    // Subclass constructor
    public BikeInfo(String vehicleId, String driverName, String currentLocation) {
        // Calling superclass constructor
        super(vehicleId, driverName, 15.0);
        this.currentLocation = currentLocation;
    }

    // Method to calculate fare
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Method to get current location
    @Override
    public String getCurrentLocation() {
        return "Bike's Current Location: " + currentLocation;
    }

    // Method to update location
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Bike location updated to: " + newLocation);
    }
}

// Subclass
class AutoInfo extends VehicleInfo implements GPS {
    // Class attributes
    private String currentLocation;

    // Subclass constructor
    public AutoInfo(String vehicleId, String driverName, String currentLocation) {
        // Calling superclass constructor
        super(vehicleId, driverName, 10.0);
        this.currentLocation = currentLocation;
    }

    // Method to calculate fare
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Method to get current location
    @Override
    public String getCurrentLocation() {
        return "Auto's Current Location: " + currentLocation;
    }

    // Method to update location
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Auto location updated to: " + newLocation);
    }
}


public class RideHailingApplication {
    public static void main(String[] args) {
        VehicleInfo carInfo = new CarInfo("VC000123", "Sehaj", "Home");
        VehicleInfo bikeInfo = new BikeInfo("VB000123", "Olivia", "Office");
        VehicleInfo autoInfo = new AutoInfo("VA000123", "Charlie", "Market");

        double distance = 10.0;

        carInfo.displayVehicleDetails();
        System.out.println("Fare for Car: Rs " + carInfo.calculateFare(distance));
        System.out.println(((GPS) carInfo).getCurrentLocation());
        ((GPS) carInfo).updateLocation("University");

        System.out.println();
        bikeInfo.displayVehicleDetails();
        System.out.println("Fare for Bike: Rs " + bikeInfo.calculateFare(distance));
        System.out.println(((GPS) bikeInfo).getCurrentLocation());
        ((GPS) bikeInfo).updateLocation("Metro Station");

        System.out.println();
        autoInfo.displayVehicleDetails();
        System.out.println("Fare for Auto: Rs " + autoInfo.calculateFare(distance));
        System.out.println(((GPS) autoInfo).getCurrentLocation());
        ((GPS) autoInfo).updateLocation("Home");
    }
}

/*
Output:
    Vehicle ID: VC000123
    Driver Name: Sehaj
    Rate per Km: Rs 20.0
    Fare for Car: Rs 200.0
    Car's Current Location: Home
    Car location updated to: University

    Vehicle ID: VB000123
    Driver Name: Olivia
    Rate per Km: Rs 15.0
    Fare for Bike: Rs 150.0
    Bike's Current Location: Office
    Bike location updated to: Metro Station

    Vehicle ID: VA000123
    Driver Name: Charlie
    Rate per Km: Rs 10.0
    Fare for Auto: Rs 100.0
    Auto's Current Location: Market
    Auto location updated to: Home
 */