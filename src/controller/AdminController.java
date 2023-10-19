package controller;

import java.io.*;
import java.util.*;
import dao.*;
import data.Course;

public class AdminController {

    public AdminController() {
    }

    // Create a new course
    public void createNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String name = scanner.nextLine();
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        System.out.println("Enter course max students: ");
        int maxStudents = scanner.nextInt();
        System.out.println("Enter course instructor: ");
        String instructor = scanner.nextLine();
        System.out.println("Enter course section: ");
        int section = scanner.nextInt();
        System.out.println("Enter course location: ");
        String location = scanner.nextLine();
        Course course = new Course(id, name, maxStudents, 0, null, instructor, section, location);
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            if (courseRepository.findById(id).isPresent()) {
                System.out.println("Course already exists");
            } else {
                courseRepository.save(course);
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // Delete a course
    public void deleteCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                courseRepository.deleteById(id);
            } else {
                System.out.println("Course does not exist");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // Edit a course
    public void editCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                System.out.println("Enter new course name: ");
                String name = scanner.nextLine();
                System.out.println("Enter new course id: ");
                String newId = scanner.nextLine();
                System.out.println("Enter new course max students: ");
                int maxStudents = scanner.nextInt();
                System.out.println("Enter new course instructor: ");
                String instructor = scanner.nextLine();
                System.out.println("Enter new course section: ");
                int section = scanner.nextInt();
                System.out.println("Enter new course location: ");
                String location = scanner.nextLine();
                Course newCourse = new Course(newId, name, maxStudents, 0, null, instructor, section, location);
                courseRepository.deleteById(course.get().getCourseId());
                courseRepository.save(newCourse);
            } else {
                System.out.println("Course does not exist");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // Display info for a course
    public void displayInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                System.out.println("ID: " + course.get().getCourseId());
                System.out.println("Name: " + course.get().getCourseName());
                System.out.println("Max Students: " + course.get().getMaxStudent());
                System.out.println("Current Students: " + course.get().getCurrentStudent());
                System.out.println("Instructor: " + course.get().getCourseInstructor());
                System.out.println("Section: " + course.get().getCourseSection());
                System.out.println("Location: " + course.get().getCourseLocation());
            } else {
                System.out.println("Course does not exist");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // Register a student
    public void registerAStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();
                course.get().addStudent(name);
                course.get().setCurrentStudent(course.get().getCurrentStudent() + 1);
                courseRepository.deleteById(course.get().getCourseId());
                courseRepository.save(course.get());
            } else {
                System.out.println("Course does not exist");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // View all courses
    public void viewAllCourses() {
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            List<Course> courses = courseRepository.findAll();
            for (Course course : courses) {
                System.out.println("ID: " + course.getCourseId());
                System.out.println("Name: " + course.getCourseName());
                System.out.println("Max Students: " + course.getMaxStudent());
                System.out.println("Current Students: " + course.getCurrentStudent());
                System.out.println("Instructor: " + course.getCourseInstructor());
                System.out.println("Section: " + course.getCourseSection());
                System.out.println("Location: " + course.getCourseLocation());
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
    }

    // View all full courses
    public void viewAllFullCourses() {
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            List<Course> courses = courseRepository.findAll();
            for (Course course : courses) {
                if (course.getCurrentStudent() == course.getMaxStudent()) {
                    System.out.println("ID: " + course.getCourseId());
                    System.out.println("Name: " + course.getCourseName());
                }
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
    }

    // View names of students registered to specific course
    public void viewNamesOfStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course id: ");
        String id = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                List<String> names = course.get().getNames();
                for (String name : names) {
                    System.out.println(name);
                }
            } else {
                System.out.println("Course does not exist");
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // View list of courses a student is registered in
    public void viewListOfCourses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            List<Course> courses = courseRepository.findAll();
            for (Course course : courses) {
                List<String> names = course.getNames();
                for (String studentName : names) {
                    if (studentName.equals(name)) {
                        System.out.println("ID: " + course.getCourseId());
                        System.out.println("Name: " + course.getCourseName());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
        scanner.close();
    }

    // Sort courses on current # of students registered
    public void sortCourses() {
        DataRepository<Course> courseRepository;
        try {
            courseRepository = new CourseDAOImpl("course.csv");
            List<Course> courses = courseRepository.findAll();
            courses.sort((c1, c2) -> c1.getCurrentStudent() - c2.getCurrentStudent());
            for (Course course : courses) {
                System.out.println("ID: " + course.getCourseId());
                System.out.println("Name: " + course.getCourseName());
                System.out.println("Max Students: " + course.getMaxStudent());
                System.out.println("Current Students: " + course.getCurrentStudent());
                System.out.println("Instructor: " + course.getCourseInstructor());
                System.out.println("Section: " + course.getCourseSection());
                System.out.println("Location: " + course.getCourseLocation());
            }
        } catch (IOException e) {
            System.out.println("Datasource problem!");
        }
    }
}