package controller;
import java.io.IOException;
import java.util.Optional;

import dao.AccountDAOImpl;
import dao.DataRepository;
import dao.FacultyDAOImpl;
import data.Account;
import data.Faculty;

public class FacultyController {
    
    private Faculty session;

    public FacultyController(String id, String password) throws IOException {
        DataRepository<Account> accountRepo = new AccountDAOImpl("account.csv");
        Optional<Account> account = accountRepo.findById(id);
        if (account.isPresent() && account.get().getPassword().equals(password) && account.get().getRole().equals("faculty")) {
            DataRepository<Faculty> faculties = new FacultyDAOImpl("faculty.csv");
            this.session = faculties.findById(id).get();
        } else {
            throw new IOException("username or password is incorrect");
        }
    }

    public void displayInformation() {
        System.out.println("ID: " + session.getId());
        System.out.println("Name: " + session.getName());
        System.out.println("Email: " + session.getEmail());
        System.out.println("Address: " + session.getAddress());
        System.out.println("Phone Number: " + session.getPhoneNumber());
        System.out.println("Department: " + session.getDepartment());
        System.out.println("Courses are teaching:");
        session.getCourseId().forEach(e -> System.out.println(e));
    }

    public void viewAllCourse() {

    }
}
