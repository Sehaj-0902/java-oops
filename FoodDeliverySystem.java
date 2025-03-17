import java.util.ArrayList;

// Abstract class
abstract class FoodItem {
    // Class fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to get item name
    public String getItemName() {
        return itemName;
    }

    // Method to get price
    public double getPrice() {
        return price;
    }

    // Method to get quantity
    public int getQuantity() {
        return quantity;
    }

    // Abstract method to calculate total price
    abstract double calculateTotalPrice();

    // Method to get item details
    public void getItemDetails() {
        System.out.println("Item: " + getItemName());
        System.out.println("Price: Rs " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total Price: Rs " + calculateTotalPrice());
    }
}

// Interface
interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

// Subclass
class VegItem extends FoodItem implements Discountable {
    // Subclass constructor
    public VegItem(String itemName, double price, int quantity) {
        // Calling superclass constructor
        super(itemName, price, quantity);
    }

    // Method to calculate total price
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Method to apply discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.25;
    }

    // Method to get discount details
    @Override
    public void getDiscountDetails() {
        System.out.println("Discount on Veg Item: Rs " + applyDiscount());
    }
}

// Subclass
class NonVegItem extends FoodItem implements Discountable {
    // Class fields
    private double additionalCharge = 15.0;

    // Subclass constructor
    public NonVegItem(String itemName, double price, int quantity) {
        // Calling superclass constructor
        super(itemName, price, quantity);
    }

    // Method to calculate total price
    @Override
    public double calculateTotalPrice() {
        return (getPrice() + additionalCharge) * getQuantity();
    }

    // Method to apply discount
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.25;
    }

    // Method to get discount details
    @Override
    public void getDiscountDetails() {
        System.out.println("Discount on Non-Veg Item: Rs " + applyDiscount());
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> items = new ArrayList<>();

        VegItem item1 = new VegItem("Cheese Chilli", 450, 1);
        items.add(item1);

        NonVegItem item2 = new NonVegItem("Chicken Tikka", 650, 1);
        items.add(item2);

        VegItem item3 = new VegItem("Veg Biryani", 350, 2);
        items.add(item3);

        for (FoodItem item : items) {
            item.getItemDetails();
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
                ((Discountable) item).getDiscountDetails();
            }
            double totalPrice = item.calculateTotalPrice() - discount;
            System.out.println("Total Price after Discount: Rs " + totalPrice);
            System.out.println();
        }
    }
}

/*
Output:
    Item: Cheese Chilli
    Price: Rs 450.0
    Quantity: 1
    Total Price: Rs 450.0
    Discount on Veg Item: Rs 112.5
    Total Price after Discount: Rs 337.5

    Item: Chicken Tikka
    Price: Rs 650.0
    Quantity: 1
    Total Price: Rs 665.0
    Discount on Non-Veg Item: Rs 166.25
    Total Price after Discount: Rs 498.75

    Item: Veg Biryani
    Price: Rs 350.0
    Quantity: 2
    Total Price: Rs 700.0
    Discount on Veg Item: Rs 175.0
    Total Price after Discount: Rs 525.0
*/