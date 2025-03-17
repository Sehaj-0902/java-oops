import java.util.ArrayList;

// Abstract class
abstract class Product {
    // Class fields
    protected int productId;
    protected String name;
    protected double price;
    protected double finalPrice;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Method to get product ID
    public int getProductId() {
        return productId;
    }

    // Method to get product name
    public String getName() {
        return name;
    }

    // Method to get product price
    public double getPrice() {
        return price;
    }

    // Abstract method to calculate discount
    abstract double calculateDiscount();

    // Method to calculate final price
    public double calculateFinalPrice() {
        return finalPrice;
    };

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Discount: " + calculateDiscount());
        // To check if tax is applicable on product
        if(this instanceof Taxable) {
            ((Taxable) this).calculateTax();
            System.out.println("Tax: " + ((Taxable) this).getTaxDetails());
        }
        System.out.println("Final Price: " + calculateFinalPrice());
    }
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Subclass
class Electronics extends Product implements Taxable {
    // Class fields
    private double discountAmount;
    private double taxAmount;

    // Subclass constructor
    public Electronics(int productId, String name, double price, double discountAmount, double taxAmount) {
        // Calling superclass constructor
        super(productId, name, price);
        this.discountAmount = discountAmount;
        this.taxAmount = taxAmount;
    }

    // Method to calculate discount
    @Override
    public double calculateDiscount() {
        return getPrice() * discountAmount / 100;
    }

    // Method to calculate tax
    @Override
    public double calculateTax() {
        return getPrice() * taxAmount / 100;
    }

    // Method to get tax details
    @Override
    public String getTaxDetails() {
        return taxAmount + " %";
    }

    // Method to calculate final price
    @Override
    public double calculateFinalPrice() {
        return price + taxAmount - discountAmount;
    }
}

// Subclass
class Clothing extends Product implements Taxable {
    // Class fields
    private double discountAmount;
    private double taxAmount;

    // Subclass constructor
    public Clothing(int productId, String name, double price, double discountAmount, double taxAmount) {
        super(productId, name, price);
        this.discountAmount = discountAmount;
        this.taxAmount = taxAmount;
    }

    // Method to calculate discount
    @Override
    public double calculateDiscount() {
        return discountAmount;
    }

    // Method to calculate tax
    @Override
    public double calculateTax() {
        return getPrice() * taxAmount / 100;
    }

    // Method to get tax details
    @Override
    public String getTaxDetails() {
        return taxAmount + " %";
    }

    // Method to calculate final price
    @Override
    public double calculateFinalPrice() {
        return price + taxAmount - discountAmount;
    }
}

// Subclass
class Groceries extends Product {
    // Class fields
    private double discountAmount;

    // Subclass constructor
    public Groceries(int productId, String name, double price, double discountAmount) {
        // Calling superclass constructor
        super(productId, name, price);
        this.discountAmount = discountAmount;
    }

    // Method to calculate discount
    @Override
    public double calculateDiscount() {
        return price * discountAmount / 100;
    }

    // Method to calculate final price
    @Override
    public double calculateFinalPrice() {
        return price - discountAmount;
    }
}

public class ECommerceSystem {
    public static void main(String[] args ) {
        ArrayList<Product> products = new ArrayList<>();

        Electronics product1 = new Electronics(101, "Laptop", 50000.0, 20, 5);
        products.add(product1);

        Clothing product2 = new Clothing(102, "Jacket", 4500.0, 0, 2);
        products.add(product2);

        Groceries product3 = new Groceries(103, "Fruits", 800.0, 3.0);
        products.add(product3);

        for(Product product : products) {
            product.displayProductDetails();
            System.out.println();
        }
    }
}

/*
Output:
    Product ID: 101
    Name: Laptop
    Price: 50000.0
    Discount: 10000.0
    Tax: 5.0 %
    Final Price: 49985.0

    Product ID: 102
    Name: Jacket
    Price: 4500.0
    Discount: 0.0
    Tax: 2.0 %
    Final Price: 4502.0

    Product ID: 103
    Name: Fruits
    Price: 800.0
    Discount: 24.0
    Final Price: 797.0
 */