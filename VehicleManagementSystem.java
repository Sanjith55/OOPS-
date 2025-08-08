import java.time.Year;


class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double basePrice;

    public Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: ₹" + basePrice);
    }

    public double calculateResaleValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        return basePrice * Math.pow(0.85, age);
    }
}


class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, double basePrice, int numberOfDoors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public double calculateInsurance() {
        return 5000 + (1000 * numberOfDoors);
    }

    public double calculateMaintenanceCost() {
        return 3000 + (500 * numberOfDoors);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance Cost: ₹" + calculateInsurance());
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
        System.out.printf("Resale Value: ₹%.2f\n", calculateResaleValue());
        System.out.println("----------------------------------");
    }
}


class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    public double calculateInsurance() {
        return hasSidecar ? 2500 + 1500 : 2500;
    }

    public double calculateMaintenanceCost() {
        return hasSidecar ? 2000 + 1000 : 2000;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance Cost: ₹" + calculateInsurance());
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
        System.out.printf("Resale Value: ₹%.2f\n", calculateResaleValue());
        System.out.println("----------------------------------");
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020, 1500000, 4);
        Motorcycle motorcycle = new Motorcycle("Royal Enfield", "Classic 350", 2019, 180000, true);

        System.out.println("🚗 Car Details:");
        car.displayInfo();

        System.out.println("🏍️ Motorcycle Details:");
        motorcycle.displayInfo();
    }
}