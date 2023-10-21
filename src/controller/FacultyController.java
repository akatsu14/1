package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.CourseDAOImpl;
import dao.DataRepository;
import dao.FacultyDAOImpl;
import data.Course;
import data.Faculty;

public class FacultyController {

    private Faculty session;

    public FacultyController(String id) {
        DataRepository<Faculty> faculties;
        try {
            faculties = new FacultyDAOImpl("faculty.csv");
            this.session = faculties.findById(id).get();
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void displayInformation() {
        System.out.println("ID: " + session.getId());
        System.out.println("Name: " + session.getName());
        System.out.println("Email: " + session.getEmail());
        System.out.println("Address: " + session.getAddress());
        System.out.println("Phone Number: " + session.getPhoneNumber());
        System.out.println("Department: " + session.getDepartment());
    }

    public void viewAllCourse() {
        try {
            DataRepository<Course> courseRepo = new CourseDAOImpl("course.csv");
            System.out.println("Courses are free in below:");
            courseRepo.findAll()
                    .stream()
                    .filter(e -> e.getCourseInstructor() == null
                            && this.session.getCourseId().contains(e.getCourseId()) == false)
                    .forEach(e -> {
                        System.out.println("Course ID: " + e.getCourseId());
                        System.out.println("Course Name: " + e.getCourseName());
                        System.out.println("Course Section: " + e.getCourseSection());
                        System.out.println("Course Location: " + e.getCourseLocation());
                        System.out.println("==================================================");
                    });
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void registerCourse() {
        try {
            DataRepository<Course> courseRepo = new CourseDAOImpl("course.csv");
            System.out.print("Enter course's ID: ");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            scanner.close();
            Optional<Course> target = courseRepo.findById(id);
            if (target.isPresent()) {
                Course course = target.get();
                course.setCourseInstructor(this.session.getId());
                courseRepo.deleteById(id);
                courseRepo.save(course);

                List<String> courseId = new ArrayList<>(this.session.getCourseId());
                courseId.add(id);
                this.session.setCourseId(courseId);
                DataRepository<Faculty> facultyRepo = new FacultyDAOImpl("faculty.csv");
                facultyRepo.deleteById(this.session.getId());
                facultyRepo.save(this.session);
                System.out.println("Add course successfully!");
            }
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void viewAllCourseRegistered() {
        System.out.println("Courses are teaching:");
        this.session.getCourseId().forEach(e -> System.out.println(e));
    }

    public void withDrawCourse() {
        try {
            this.viewAllCourse();
            System.out.println("Enter course ID to withdraw: ");
            Scanner scanner = new Scanner(System.in);
            String courseId = scanner.next();
            scanner.close();
            if (this.session.getCourseId().contains(courseId)) {
                List<String> courseIds = new ArrayList<>(this.session.getCourseId());
                courseIds.remove(courseId);
                this.session.setCourseId(courseIds);
                DataRepository<Faculty> facultyRepo = new FacultyDAOImpl("faculty.csv");
                facultyRepo.deleteById(this.session.getId());
                facultyRepo.save(session);
            } else {
                System.out.println("Invalid ID!");
            }
        } catch (IOException ioException) {
            System.out.println("Data source problem!");
        }
    }
}
