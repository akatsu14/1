package view;

import controller.StudentController;

public class StudentView {
    
    private StudentController studentController;

    public StudentView(StudentController studentController) {
        this.studentController = studentController;
    }

    public static void view() {
        System.out.println("1. View all courses");
        System.out.println("2. View all courses that are NOT full");
        System.out.println("3. Register in a course ");
        System.out.println("4. Withdraw from a course");
        System.out.println("5. View all courses are registered in");
        System.out.println("6. Exit");
    }

    public void select_1() {
        this.studentController.viewAllCourse();
    }

    public void select_2() {
        this.studentController.viewAllCourseNotFull();
    }

    public void select_3() {
        this.studentController.registerCourse();
    }

    public void select_4() {
        this.studentController.withDrawCourse();
    }

    public void select_5() {
        this.studentController.viewAllCourseRegistered();
    }

    public void select_6() {
        System.out.println("Goodbye!");
    }
}
