import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07055 {
    public static void main (String[] args) throws Exception{
        Scanner sc=new Scanner(new File("BANGDIEM.in"));
        int n=Integer.parseInt(sc.nextLine());
        List<OOPRank> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(OOPRank.newOOPRank(sc));
        }
        
        list.sort((a, b) -> {
            return b.totalPoint.compareTo(a.totalPoint);
        });
        list.forEach(System.out::println);

    }
    static class OOPRank {
        private String name, rank, code;
        private Double totalPoint;
        public static int cnt = 1;

        OOPRank(String name, Double exercisePoint, Double practicePoint, Double finalExam) {
            this.code = String.format("SV%02d", cnt++);
            this.name = normalizeName(name);
            this.totalPoint = exercisePoint * 0.25 + practicePoint * 0.35 + finalExam * 0.4;
            if (this.totalPoint >= 8)
                this.rank = "GIOI";
            else if (this.totalPoint >= 6.5)
                this.rank = "KHA";
            else if (this.totalPoint >= 5)
                this.rank = "TRUNG BINH";
            else
                this.rank = "KEM";
        }

        public static OOPRank newOOPRank(Scanner sc) {
            String name = sc.nextLine().trim();
            Double exercisePoint = Double.parseDouble(sc.nextLine());
            Double practicePoint = Double.parseDouble(sc.nextLine());
            Double finalExam = Double.parseDouble(sc.nextLine());
            return new OOPRank(name, exercisePoint, practicePoint, finalExam);
        }
        private String normalizeName(String name) {
            String[] s = name.split("\\s+");
            String s1 = "";
            for (String i : s) {
                s1 += (i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
            }
            return s1.trim();
        }
        @Override
        public String toString() {
            return code + " " + name + " " + String.format("%.2f",totalPoint) + " " + rank;
        }
    }
}
