package hospitalsys;

import java.util.Scanner;

public class ProcedureService {
    public static void createProcedure(Doctor doctor, Scanner scanner) {
        System.out.println("Creating a new procedure...");
        System.out.print("Enter procedure type (1: Consultation, 2: Cosmetic, 3: Surgical): ");
        int procedureType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter procedure name: ");
        String procedureName = scanner.nextLine();

        System.out.print("Enter procedure date (--/--/----): ");
        String procedureDate = scanner.nextLine();//Though you don't need ask for a date, that gotta be in a real system

        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        switch (procedureType) {
            case 1:
                System.out.println("Consultation procedure created for patient ID " + patientId);
                break;

            case 2:
                System.out.println("Cosmetic procedure created for patient ID " + patientId);
                break;

            case 3:
                System.out.print("Enter nurse ID: ");
                int nurseId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter anesthetist ID: ");
                int anesthetistId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Surgical procedure created with Nurse ID " + nurseId + " and Anesthetist ID " + anesthetistId);
                break;

            default:
                System.out.println("Invalid procedure type. Procedure creation failed.");
                return;
        }

        System.out.println("Procedure '" + procedureName + "' created for patient ID " + patientId + " on " + procedureDate);
    }

    public static void authorizeProcedure(TechManager techManager, Scanner scanner) {
        System.out.println("Authorizing a procedure...");
        System.out.print("Enter procedure ID: ");
        int procedureId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Procedure ID " + procedureId + " has been authorized.");
    }

    public static void viewMedicalRecords(Patient patient, Scanner scanner) {
        System.out.println("Viewing medical records...");
        System.out.print("Enter your ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        if (patient.getId() == patientId) {
            System.out.println("Displaying medical records for patient ID " + patientId);
        } else {
            System.out.println("Invalid ID. Access denied.");
        }
    }
}