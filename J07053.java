import java.util.*;
import java.io.*;


public class J07053 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Candidate> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(Candidate.newCandidate(sc));
        }

        list.forEach(System.out::println);
    }

    static class Candidate {
        private String code, name, rank;
        private Double theoreticalPoint, praticePoint;
        private int age;
        public static int cnt = 1;

        Candidate(String name, String date, Double theoreticalPoint, Double praticePoint) {
            this.code = String.format("PH%02d" , cnt++);
            this.name = normalizeName(name);
            this.age = 2021-Integer.parseInt(getYear(date).substring(6,10));
            this.theoreticalPoint = theoreticalPoint;
            this.praticePoint = praticePoint;
            switch (totalPoint()) {
                case 10:
                case 9:
                    this.rank = "Xuat sac";
                    break;
                case 8:
                    this.rank = "Gioi";
                    break;
                case 7:
                    this.rank = "Kha";
                    break;
                case 6:
                case 5:
                    this.rank = "Trung binh";
                    break;
                default:
                    this.rank = "Truot";
                    break;
            }

        }

        public static Candidate newCandidate(Scanner sc) {
            String name = sc.nextLine();
            String date = sc.nextLine();
            Double theoreticalPoint = Double.parseDouble(sc.nextLine());
            Double praticePoint = Double.parseDouble(sc.nextLine());
            return new Candidate(name, date, theoreticalPoint, praticePoint);
        }

        private String normalizeName(String name) {
            String[] s = name.trim().split("\\s+");
            String s1 = "";
            for (String i : s) {
                s1 += (i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
            }
            return s1.trim();
        }

        private String getYear(String date) {

            StringBuilder sb = new StringBuilder(date);
            if (sb.charAt(2) != '/')
                sb.insert(0, '0');
            if (sb .charAt(5) != '/')
                sb.insert(3, '0');
            return sb.toString();

        }

        private Double extraPoint() {
            Double point = (double) 0;
            if (praticePoint >= 7.5 && theoreticalPoint >= 7.5)
                point = 0.5;
            if (praticePoint >= 8 && theoreticalPoint >= 8)
                point = (double) 1;
            return point;
        }

        private Integer totalPoint() {
            return (int) Math.min(Math.round((theoreticalPoint + praticePoint) / 2 + extraPoint()), 10);
        }

        

        @Override
        public String toString() {
            return code + " " + name + " " + age + " " + totalPoint() + " " + rank;
        }
    }
}
