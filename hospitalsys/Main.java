package hospitalsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating users, here you can basically change and add users, their id shold be a string tho
        List<User> users = new ArrayList<>();
        users.add(new Doctor(101, "Dr. Henry Rosenfeld", "redroses"));
        users.add(new Patient(201, "Ryan Gosling", "bladerunner"));
        users.add(new Nurse(301, "Sabrina Carpenter", "espresso"));
        users.add(new Anesthetist(401, "Holy Spirit", "jesus"));
        users.add(new TechManager(501, "Leon Kennedy", "techpass"));

        Scanner scanner = new Scanner(System.in);
        User loggedInUser = AuthService.login(users, scanner);

        if (loggedInUser != null) {
            boolean running = true;

            while (running) {
                System.out.println("\nWelcome, " + loggedInUser.getName());
                System.out.println("1. Create Procedure");
                System.out.println("2. Authorize Procedure");
                System.out.println("3. Consult Records");
                System.out.println("0. Log Out");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (loggedInUser instanceof Doctor) {
                            ProcedureService.createProcedure((Doctor) loggedInUser, scanner);
                        } else {
                            System.out.println("Only doctors can create procedures.");
                        }
                        break;

                    case 2:
                        if (loggedInUser instanceof TechManager) {
                            ProcedureService.authorizeProcedure((TechManager) loggedInUser, scanner);
                        } else {
                            System.out.println("Only the Technical Manager can authorize procedures.");
                        }
                        break;

                    case 3:
                        if (loggedInUser instanceof Patient) {
                            ProcedureService.viewMedicalRecords((Patient) loggedInUser, scanner);
                        } else {
                            System.out.println("Only patients can consult their records.");
                        }
                        break;

                    case 0:
                        System.out.println("Logging out...");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Login failed. Exiting program.");
        }
    }
}
