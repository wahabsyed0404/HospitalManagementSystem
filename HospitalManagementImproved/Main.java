import model.Patient;
import service.PatientService;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final PatientService service = new PatientService();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = getInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> service.viewPatients();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addPatient() {
        System.out.print("Enter ID: ");
        int id = getInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Age: ");
        int age = getInt();
        System.out.print("Enter Disease: ");
        String disease = sc.next();

        service.addPatient(new Patient(id, name, age, disease));
    }

    private static void updatePatient() {
        System.out.print("Enter ID to update: ");
        int id = getInt();
        System.out.print("Enter New Name: ");
        String name = sc.next();
        System.out.print("Enter New Age: ");
        int age = getInt();
        System.out.print("Enter New Disease: ");
        String disease = sc.next();

        service.updatePatient(id, new Patient(id, name, age, disease));
    }

    private static void deletePatient() {
        System.out.print("Enter ID to delete: ");
        int id = getInt();
        service.deletePatient(id);
    }

    private static int getInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
