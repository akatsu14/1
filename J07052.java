import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07052 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(Student.newStudent(sc));
        }
        list.sort((a, b) -> {
            if (a.admissionPoint() - b.admissionPoint() == 0) {
                return a.studentID.compareTo(b.studentID);
            }
            ;
            return b.admissionPoint().compareTo(a.admissionPoint());
        });
        int targetNum = Integer.parseInt(sc.nextLine());
        Double targetPoint = list.get(targetNum).admissionPoint();
        Student.targetPoint = (targetPoint);

        System.out.printf("%.1f\n", targetPoint);
        list.forEach(System.out::println);
    }

    static class Student {
        private String studentID, name;
        private Double mathPoint, physicPoint, chemisPoint;
        public static Double targetPoint;

        Student(String studentID, String name, Double mathPoint, Double physicPoint, Double chemisPoint) {
            this.name = normalizeName(name);
            this.chemisPoint = chemisPoint;
            this.mathPoint = mathPoint;
            this.physicPoint = physicPoint;
            this.studentID = studentID;
        }

        public static Student newStudent(Scanner sc) {
            String studentId = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            Double mathPoint = Double.parseDouble(sc.nextLine().trim());
            Double physicPoint = Double.parseDouble(sc.nextLine().trim());
            Double chemisPoint = Double.parseDouble(sc.nextLine().trim());
            return new Student(studentId, name, mathPoint, physicPoint, chemisPoint);

        }

        private String normalizeName(String name) {
            String[] s = name.split("\\s+");
            String s2 = "";
            for (String i : s) {
                s2 += (i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
            }
            return s2;
        }

        private String areaNum() {
            return studentID.substring(2, 3);
        }

        private Double priorityPoint() {
            double point = 0;
            switch (areaNum()) {
                case "1":
                    point = 0.5;
                    break;
                case "2":
                    point = 1.0;
                    break;
                case "3":
                    point = 2.5;
                    break;
                default:
                    break;
            }
            return point;
        }

        private Double admissionPoint() {
            return mathPoint * 2 + chemisPoint + physicPoint + priorityPoint();
        }

        public String getTarget() {
            return admissionPoint() >= targetPoint ? "TRUNG TUYEN" : "TRUOT";
        }

        @Override
        public String toString() {
            return studentID + " " + name + " "
                    + ((priorityPoint() == priorityPoint().intValue()) ? priorityPoint().intValue()
                            : String.format("%.1f", priorityPoint()))
                    + " " + ((admissionPoint() == admissionPoint().intValue()) ? admissionPoint().intValue()
                            : String.format("%.1f", admissionPoint()))
                    + " " + getTarget();
        }
    }
}
