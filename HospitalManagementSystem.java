import java.util.ArrayList;

// Abstract class
abstract class Patient {
    // Class fields
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Method to get patient Id
    public int getPatientId() {
        return patientId;
    }

    // Method to get name
    public String getName() {
        return name;
    }

    // Method to get age
    public int getAge() {
        return age;
    }

    // Abstract method to calculate bill
    abstract double calculateBill();

    // Method to get patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
    }
}

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Subclass
class InPatient extends Patient implements MedicalRecord {
    // Class fields
    private int daysAdmitted;
    private double dailyCharge;
    private ArrayList<String> records = new ArrayList<>();

    // Subclass constructor
    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        // Calling superclass constructor
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    // Method to calculate bill
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Method to add record
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

     // Method to view records
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}

// Subclass OutPatient
class OutPatient extends Patient implements MedicalRecord {
    // Class fields
    private double consultationFee;
    private ArrayList<String> records = new ArrayList<>();

    // Subclass constructor
    public OutPatient(int patientId, String name, int age, double consultationFee) {
        // Calling superclass constructor
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    // Method to calculate bill
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Method to add record
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    // Method to view records
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();

        InPatient patient1 = new InPatient(101, "Olivia", 19, 4, 450);
        patient1.addRecord("Diagnosis: Stomach Infection");
        patients.add(patient1);

        OutPatient patient2 = new OutPatient(102, "Alice", 20, 500);
        patient2.addRecord("Consultation: Medicine prescribed");
        patients.add(patient2);

        System.out.println("Patient Details:");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: Rs." + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println();
        }
    }
}

/*
Output:
    Patient Details:
    Patient ID: 101
    Name: Olivia
    Age: 19
    Total Bill: Rs.1800.0
    Medical Records: [Diagnosis: Stomach Infection]

    Patient ID: 102
    Name: Alice
    Age: 20
    Total Bill: Rs.500.0
    Medical Records: [Consultation: Medicine prescribed]
 */