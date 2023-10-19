package view;

import controller.AdminController;

public class AdminView {

    private AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
    }

    public static void selection() {
        System.out.println("1. Course Management");
        System.out.println("2. Reports");
    }

    
    public static class Management {

        public static void selection() {
            System.out.println("1. Create a new course");
            System.out.println("2. Delete a course");
            System.out.println("3. Edit a course");
            System.out.println("4. Display info for a course");
            System.out.println("5. Register a student");
            System.out.println("6. Exit");
        }
    }

    public void selection_1_1() {
        adminController.createNewCourse();
    }

    public void selection_1_2() {
        adminController.deleteCourse();
    }

    public void selection_1_3() {
        adminController.editCourse();
    }

    public void selection_1_4() {
        adminController.displayInformation();
    }

    public void selection_1_5() {
        adminController.registerAStudent();
    }

    public void selection_1_6() {
        System.out.println("Goodbye!");
    }

    public static class Reports {

        public static void selection() {
            System.out.println("1. View all courses");
            System.out.println("2. View all full courses (only display id and name)");
            System.out.println("3. View names of students registered to specific course");
            System.out.println("4. View list of courses a student is registered in");
            System.out.println("5. Sort courses on current # of students registered");
            System.out.println("6. Exit");
        }
    }

    public void selection_2_1() {
        adminController.viewAllCourses();
    }

    public void selection_2_2() {
        adminController.viewAllFullCourses();
    }

    public void selection_2_3() {
        adminController.viewNamesOfStudents();
    }

    public void selection_2_4() {
        adminController.viewListOfCourses();
    }

    public void selection_2_5() {
        adminController.sortCourses();
    }

    public void selection_2_6() {
        System.out.println("Goodbye!");
    }
}
