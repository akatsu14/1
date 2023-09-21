import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07054 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<StudentPtit> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(StudentPtit.newStudentPtit(sc));
        }
        
        list.sort((a, b) -> {
            if (a.totalPoint == b.totalPoint)
                return a.code.compareTo(b.code);
            return b.totalPoint.compareTo(a.totalPoint);
        });
        int count=2;
        list.get(0).rank=1;
        for(int i=1;i<list.size();i++){
            if(list.get(i).totalPoint-list.get(i-1).totalPoint==0)list.get(i).rank=list.get(i-1).rank;
            else list.get(i).rank=count;
            count++;
        }
        list.forEach(System.out::println);

    }

    static class StudentPtit {
        private String name, code ;
        private Double totalPoint;        
        private int rank;
        public static int cnt = 1;

        StudentPtit(String name, Double point1, Double point2, Double point3) {
            this.name = normalizeName(name);
            this.code = String.format("SV%02d", cnt++);
            this.totalPoint=(point1*3+point2*3+point3*2)/8;
        }

        public static StudentPtit newStudentPtit(Scanner sc) {
            String name = sc.nextLine().trim();
            Double point1 = Double.parseDouble(sc.nextLine().trim());
            Double point2 = Double.parseDouble(sc.nextLine().trim());
            Double point3 = Double.parseDouble(sc.nextLine().trim());
            return new StudentPtit(name, point1, point2, point3);
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
            return code + " " + name + " " +String.format("%.2f", totalPoint) + " " + rank;
        }
    }
}
