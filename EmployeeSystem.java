// Abstract class
abstract class Employee implements Department {
    // Class fields
    protected int employeeId;
    protected String name;
    protected double baseSalary;
    protected String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Method to get employee ID
    public int getEmployeeId() {
        return employeeId;
    }

    // Method to get employee name
    public String getName() {
        return name;
    }

    // Method to get base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method to calculate salary
    abstract double calculateSalary();

    // Method to assign department
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    // Method to get department details
    @Override
    public String getDepartmentDetails() {
        return department;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Base Salary: " + getBaseSalary());
        System.out.println("New Salary: " + calculateSalary());
    }
}

// Interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Subclass
class FullTimeEmployee extends Employee {
    // Class fields
    private double incrementAmount;

    // Subclass constructor
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double incrementAmount) {
        // Calling superclass constructor
        super(employeeId, name, baseSalary);
        this.incrementAmount = incrementAmount;
    }

    // Method to calculate salary
    @Override
    public double calculateSalary() {
        return getBaseSalary() + incrementAmount;
    }
}

// Subclass
class PartTimeEmployee extends Employee {
    // Class fields
    private int workHours;
    private double salaryPerHour;

    // Subclass constructor
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double salaryPerHour) {
        // Calling superclass constructor
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.salaryPerHour = salaryPerHour;
    }

    // Method to calculate salary
    @Override
    public double calculateSalary() {
        return workHours * salaryPerHour;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(101, "Sehaj", 50000, 5500);
        fullTimeEmployee.assignDepartment("DevOps");
        employees[0] = fullTimeEmployee;

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(102, "Alice", 2000, 60, 800);
        partTimeEmployee.assignDepartment("Web Development");
        employees[1] = partTimeEmployee;

        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
            System.out.println();
        }
    }
}

/*
Output:
    Employee ID: 101
    Name: Sehaj
    Department: DevOps
    Base Salary: 50000.0
    New Salary: 55500.0

    Employee ID: 102
    Name: Alice
    Department: Web Development
    Base Salary: 2000.0
    New Salary: 48000.0
 */