import java.util.ArrayList;

// Abstract class
abstract class LibraryItem {
    // Class fields
    private int itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Method to get item Id
    public int getItemId() {
        return itemId;
    }

    // Method to get title
    public String getTitle() {
        return title;
    }

    // Method to get author name
    public String getAuthor() {
        return author;
    }

    // Abstract method
    abstract int getLoanDuration();

    // Method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + getItemId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
    }
}

// Interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Subclass
class Book extends LibraryItem implements Reservable {
    // Subclass constructor
    public Book(int itemId, String title, String author) {
        // Calling superclass constructor
        super(itemId, title, author);
    }

    // Method to get loan duration
    @Override
    public int getLoanDuration() {
        return 15;
    }

    // Method to reserve item
    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }

    // Method to check availability
    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Subclass
class Magazine extends LibraryItem implements Reservable{
    // Subclass constructor
    public Magazine(int itemId, String title, String author) {
        // Calling superclass constructor
        super(itemId, title, author);
    }

    // Method to get loan duration
    @Override
    public int getLoanDuration() {
        return 4;
    }

    // Method to reserve item
    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved: " + getTitle());
    }

    // Method to check availability
    @Override
    public boolean checkAvailability() {
        return false;
    }
}

// Subclass
class DVD extends LibraryItem implements Reservable {
    // Subclass constructor
    public DVD(int itemId, String title, String author) {
        // Calling superclass constructor
        super(itemId, title, author);
    }

    // Method to get loan duration
    @Override
    public int getLoanDuration() {
        return 7;
    }

    // Method to reserve item
    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + getTitle());
    }

    // Method to check availability
    @Override
    public boolean checkAvailability() {
        return true;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        Book item1 = new Book(101, "Alice In Wonderland", "Lewis Carroll");
        libraryItems.add(item1);

        Magazine item2 = new Magazine(102, "India Today", "Living Media India Limited");
        libraryItems.add(item2);

        DVD item3 = new DVD(103, "The Lion King", "Roger Allers and Rob Minkoff");
        libraryItems.add(item3);

        System.out.println("Library Items:");
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                System.out.println("Reservable: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }
}

/*
Output:
    Library Items:
    Item ID: 101
    Title: Alice In Wonderland
    Author: Lewis Carroll
    Loan Duration: 15 days
    Reservable: true

    Item ID: 102
    Title: India Today
    Author: Living Media India Limited
    Loan Duration: 4 days
    Reservable: false

    Item ID: 103
    Title: The Lion King
    Author: Roger Allers and Rob Minkoff
    Loan Duration: 7 days
    Reservable: true
 */