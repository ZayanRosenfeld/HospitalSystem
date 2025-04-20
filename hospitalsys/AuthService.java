package hospitalsys;

import java.util.List;
import java.util.Scanner;

public class AuthService {
    public static User login(List<User> users, Scanner scanner) {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getId() == id && user.getPassword().equals(password)) {
                System.out.println("Access granted, welcome, " + user.getName());
                return user;
            }
        }

        System.out.println("Access denied. Entered data is not valid.");
        return null;
    }
}
