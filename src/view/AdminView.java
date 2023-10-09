package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CourseDAOImpl;
import data.Course;

public class AdminView {

    public void selection() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Course Management");
        System.out.println("2. Reports");
        switch (sc.nextInt()) {
            case 1:
                Management.selection();
                break;
            case 2:
                Reports.selection();
                break;
            default:
                break;
        }
        sc.close();
    }

    private static class Management {

        private static void selection() {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Create a new course");
            System.out.println("2. Delete a course");
            System.out.println("3. Edit a course");
            System.out.println("4. Display info for a course");
            System.out.println("5. Register a student");
            System.out.println("6. Exit");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    select1();
                    break;
                case 2:
                    System.out.println("Enter the id to delete: ");
                    String id = sc.next();
                    select2(id);
                    break;
                case 3:
                    select3();
                    break;
                case 4:
                    select4();
                    break;
                case 5:
                    select5();
                    break;
                case 6:
                    select6();
                    break;
                default:
                    break;
            }
            sc.close();
        }

        private static void select1() {
            try {
                Scanner sc = new Scanner(System.in);
                // Create an instance of the CourseDAOImpl
                CourseDAOImpl courseDAO = new CourseDAOImpl("course.csv");
                System.out.print("Enter the course ID: ");
                String courseId = sc.nextLine().trim(); // Replace with the actual course ID
                System.out.print("Enter the course name: ");
                String courseName = sc.nextLine().trim(); // Replace with the course name
                System.out.print("Enter the max student count: ");
                int maxStudent = Integer.parseInt(sc.nextLine().trim()); // Replace with the max student count
                System.out.print("Enter the current student count: ");
                int currentStudent = Integer.parseInt(sc.nextLine().trim()); // Initial current student count (usually
                                                                             // 0)
                System.out.print("Enter the list of student names: ");
                List<String> nameList = Arrays.asList(sc.nextLine().trim().split(";")); // List of student names
                System.out.print("Enter the course instructor's name: ");
                String courseInstructor = sc.nextLine().trim(); // Replace with the course instructor's name
                System.out.print("Enter the course section: ");
                int courseSection = Integer.parseInt(sc.nextLine().trim()); // Replace with the course section
                System.out.print("Enter the course location: ");
                String courseLocation = sc.nextLine().trim(); // Replace with the course location
                // Create a new Course object with the course details

                Course newCourse = new Course(
                        courseId, courseName, maxStudent, currentStudent, nameList, courseInstructor, courseSection,
                        courseLocation);

                boolean isCourseCreated = courseDAO.save(newCourse);

                if (isCourseCreated) {
                    System.out.println("New course created successfully!");
                } else {
                    System.out.println("Course with the same ID already exists.");
                }
            } catch (Exception e) {
                System.err.println("Error while reading/writing data.");
                e.printStackTrace();
                String errorMessage = e.getMessage();
                System.out.println(errorMessage);
                System.out.println(e);

            }
        }

        private static void select2(String id) {
            try {
                CourseDAOImpl cdaoi = new CourseDAOImpl("course.csv");
                boolean allCourses = cdaoi.deleteById(id);
                System.out.println(allCourses ? "Delete successfully"
                        : "Delete false\n can not find id: " + id + " please check id again");
            } catch (IOException e) {
                System.err.println("Error reading data from source file.");
                e.printStackTrace();
            }
        }

        private static void select3() {

            // Edit a course
        }

        private static void select4() {
            // Display info for a course
        }

        private static void select5() {
            // Register a student
        }

        private static void select6() {
            // Exit
        }
    }

    private static class Reports {

        private static void selection() {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. View all courses");
            System.out.println("2. View all full courses (only display id and name)");
            System.out.println("3. View names of students registered to specific course");
            System.out.println("4. View list of courses a student is registered in");
            System.out.println("5. Sort courses on current # of students registered");
            System.out.println("6. Exit");
            switch (sc.nextInt()) {
                case 1:
                    select1();
                    break;
                case 2:
                    select2();
                    break;
                case 3:
                    select3();
                    break;
                case 4:
                    select4();
                    break;
                case 5:
                    select5();
                    break;
                case 6:
                    select6();
                    break;
                default:
                    break;
            }
            sc.close();
        }

        private static void select1() {
            try {
                CourseDAOImpl cdaoi = new CourseDAOImpl("course.csv");
                List<Course> allCourses = cdaoi.findAll();
                for (Course course : allCourses) {
                    System.out.println(course);
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đọc dữ liệu từ tệp nguồn.");
                e.printStackTrace();
            }

        }

        private static void select2() {
            // View all full courses (only display id and name)

        }

        private static void select3() {
            // View names of students registered to specific course
        }

        private static void select4() {
            // View list of courses a student is registered in
        }

        private static void select5() {
            // Sort courses on current # of students registered
        }

        private static void select6() {
            // Exit
        }
    }
}
