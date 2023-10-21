import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import controller.AdminController;
import controller.FacultyController;
import controller.StudentController;
import dao.AccountDAOImpl;
import dao.DataRepository;
import data.Account;
import view.AdminView;
import view.FacultyView;
import view.StudentView;

public class Main {

    private static String username, password;

    public static void main(String[] args) {
        DataRepository<Account> accountRepository;
        try {
            accountRepository = new AccountDAOImpl("account.csv");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();
            // scanner.close();
            Optional<Account> account = accountRepository.findById(username);
            if (account.isPresent()) {
                if (account.get().getPassword().equals(password)) {
                    switch (account.get().getRole()) {
                        case "admin":
                            AdminController adminController = new AdminController();
                            AdminView adminView = new AdminView(adminController);
                            AdminView.selection();
                            Scanner newScanner = new Scanner(System.in);
                            int selection = newScanner.nextInt();
                            // newScanner.close();

                            switch (selection) {
                                case 1:
                                    AdminView.Management.selection();
                                    Scanner newScanner1 = new Scanner(System.in);
                                    int selection1 = newScanner1.nextInt();
                                    // newScanner1.close();
                                    switch (selection1) {
                                        case 1:
                                            adminView.selection_1_1();
                                            break;
                                        case 2:
                                            adminView.selection_1_2();
                                            break;
                                        case 3:
                                            adminView.selection_1_3();
                                            break;
                                        case 4:
                                            adminView.selection_1_4();
                                            break;
                                        case 5:
                                            adminView.selection_1_5();
                                            break;
                                        case 6:
                                            adminView.selection_1_6();
                                            break;
                                        default:
                                            System.out.println("Invalid selection!");
                                            break;
                                    }
                                    break;
                                case 2:
                                    AdminView.Reports.selection();
                                    Scanner newScanner2 = new Scanner(System.in);
                                    int selection2 = newScanner.nextInt();
                                    // newScanner2.close();
                                    switch (selection2) {
                                        case 1:
                                            adminView.selection_2_1();
                                            break;
                                        case 2:
                                            adminView.selection_2_2();
                                            break;
                                        case 3:
                                            adminView.selection_2_3();
                                            break;
                                        case 4:
                                            adminView.selection_2_4();
                                            break;
                                        case 5:
                                            adminView.selection_2_5();
                                            break;
                                        case 6:
                                            adminView.selection_2_6();
                                            break;
                                        default:
                                            System.out.println("Invalid selection!");
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid selection!");
                                    break;
                            }
                            break;
                        case "student":
                            StudentController studentController = new StudentController(username);
                            StudentView studentView = new StudentView(studentController);
                            StudentView.view();
                            // Scanner scanner2 = new Scanner(System.in);
                            int selection2 = scanner.nextInt();
                            // scanner2.close();
                            switch (selection2) {
                                case 1:
                                    studentView.select_1();
                                    break;
                                case 2:
                                    studentView.select_2();
                                    break;
                                case 3:
                                    studentView.select_3();
                                    break;
                                case 4:
                                    studentView.select_4();
                                    break;
                                case 5:
                                    studentView.select_5();
                                    break;
                                case 6:
                                    studentView.select_6();
                                    break;
                                default:
                                    System.out.println("Invalid selection!");
                                    break;
                            }
                            break;
                        case "faculty":
                            FacultyController instructorController = new FacultyController(username);
                            FacultyView instructorView = new FacultyView(instructorController);
                            FacultyView.view();
                            Scanner scanner3 = new Scanner(System.in);
                            int selection3 = scanner3.nextInt();
                            // scanner3.close();
                            switch (selection3) {
                                case 1:
                                    instructorView.select_1();
                                    break;
                                case 2:
                                    instructorView.select_2();
                                    break;
                                case 3:
                                    instructorView.select_3();
                                    break;
                                case 4:
                                    instructorView.select_4();
                                    break;
                                case 5:
                                    instructorView.select_5();
                                    break;
                                default:
                                    System.out.println("Invalid selection!");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Invalid role!");
                            break;
                    }
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Account not found!");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
    }
}
