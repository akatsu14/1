package controller;

import java.io.*;
import java.util.*;
import dao.*;
import data.*;

public class StudentController {

    private Student session;

    public StudentController(String id) {
        DataRepository<Student> students;
        try {
            students = new StudentDAOImpl("student.csv");
            this.session = students.findById(id).get();
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void viewAllCourse() {
        try {
            DataRepository<Course> courseRepo = new CourseDAOImpl("course.csv");
            System.out.println("Courses are free in below:");
            courseRepo.findAll()
                    .stream()
                    .filter(e -> this.session.getCourseId().contains(e.getCourseId()) == false)
                    .forEach(e -> {
                        System.out.println("Course ID: " + e.getCourseId());
                        System.out.println("Course Name: " + e.getCourseName());
                        System.out.println("Current Student: " + e.getCurrentStudent());
                        System.out.println("Max Student: " + e.getMaxStudent());
                        System.out.println("Course Instructor: " + e.getCourseInstructor());
                        System.out.println("Course Section: " + e.getCourseSection());
                        System.out.println("Course Location: " + e.getCourseLocation());
                        System.out.println("==================================================");
                    });
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void viewAllCourseNotFull() {
        try {
            DataRepository<Course> courseRepo = new CourseDAOImpl("course.csv");
            System.out.println("Courses are free in below:");
            courseRepo.findAll()
                    .stream()
                    .filter(e -> e.getCurrentStudent() < e.getMaxStudent()
                            && this.session.getCourseId().contains(e.getCourseId()) == false)
                    .forEach(e -> {
                        System.out.println("Course ID: " + e.getCourseId());
                        System.out.println("Course Name: " + e.getCourseName());
                        System.out.println("Current Student: " + e.getCurrentStudent());
                        System.out.println("Max Student: " + e.getMaxStudent());
                        System.out.println("Course Instructor: " + e.getCourseInstructor());
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

                List<String> courseId = this.session.getCourseId();
                courseId.add(id);
                this.session.setCourseId(courseId);
                DataRepository<Student> studentRepo = new StudentDAOImpl("student.csv");
                studentRepo.deleteById(this.session.getId());
                studentRepo.save(this.session);
                System.out.println("Add course successfully!");
            }
        } catch (IOException e) {
            System.out.println("Data source problem!");
        }
    }

    public void withDrawCourse() {
        try {
            this.viewAllCourse();
            System.out.println("Enter course ID to withdraw: ");
            Scanner scanner = new Scanner(System.in);
            String courseId = scanner.next();
            scanner.close();
            if (this.session.getCourseId().contains(courseId)) {
                List<String> courseIds = this.session.getCourseId();
                courseIds.remove(courseId);
                this.session.setCourseId(courseIds);
                DataRepository<Student> studentRepo = new StudentDAOImpl("student.csv");
                studentRepo.deleteById(this.session.getId());
                studentRepo.save(session);
            } else {
                System.out.println("Invalid ID!");
            }
        } catch (IOException ioException) {
            System.out.println("Data source problem!");
        }
    }

    public void viewAllCourseRegistered() {
        System.out.println("Courses are registered:");
        this.session.getCourseId().forEach(e -> System.out.println(e));
    }
}
