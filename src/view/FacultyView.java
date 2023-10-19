package view;

import controller.FacultyController;

public class FacultyView {
    
    private FacultyController facultyController;

    public FacultyView(FacultyController facultyController) {
        this.facultyController = facultyController;
    }

    public static void view() {
        System.out.println("1. View all courses");
        System.out.println("2. Register teaching in a course");
        System.out.println("3. Withdraw from a course");
        System.out.println("4. View all courses are registered in");
        System.out.println("5. Exit");
    }

    public void select_1() {
        this.facultyController.viewAllCourse();
    }

    public void select_2() {
        this.facultyController.registerCourse();
    }

    public void select_3() {
        this.facultyController.withDrawCourse();
    }

    public void select_4() {
        this.facultyController.viewAllCourseRegistered();
    }

    public void select_5() {
        System.out.println("Goodbye!");
    }
}
