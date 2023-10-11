package view;

public class AdminView {

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
}
