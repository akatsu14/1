// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class J07057 {
//     public static void main(String[] args) throws Exception {
//         Scanner sc = new Scanner(new File("THISINH.in"));
//         int n = Integer.parseInt(sc.nextLine());
//         List<ElectricBill> list = new ArrayList<>();
//         while (n-- > 0) {
//             list.add(ElectricBill.newElectricBill(sc));
//         }

//         list.sort((a, b) -> {
//             if (b.diemTong - a.diemTong == 0)
//                 return a.code.compareTo(b.code);
//             return b.diemTong.compareTo(a.diemTong);
//         });
//         list.forEach(System.out::println);

//     }

//     static class ElectricBill {
//         private String name, code, trangThai;
//         private Double diemTong, uuTien1, uuTien2;

//         public static Integer cnt = 1;

//         ElectricBill(String name, String danToc, Integer khuVuc, Double diemThi) {
//             this.code = String.format("TS%02d", cnt++);
//             this.name = normalizeName(name);
//             switch (khuVuc) {
//                 case 1:
//                     this.uuTien1 = 1.5;
//                     break;
//                 case 2:
//                     this.uuTien1 = (double) 1;
//                     break;
//                 default:
//                     this.uuTien1 = (double) 0;
//                     break;
//             }
//             switch (danToc) {
//                 case "Kinh":
//                     this.uuTien2 = (double) 0;
//                     break;
//                 default:
//                     this.uuTien2 = 1.5;
//                     break;
//             }
//             this.diemTong = diemThi + this.uuTien1 + this.uuTien2;
//             if (this.diemTong < 20.5)
//                 this.trangThai = "Truot";
//             else
//                 this.trangThai = "Do";

//         }

//         public static ElectricBill newElectricBill(Scanner sc) {
//             String name = sc.nextLine().trim();
//             Double diemThi = Double.parseDouble(sc.nextLine());
//             String danToc = sc.nextLine().trim();
//             Integer khuVuc = Integer.parseInt(sc.nextLine());

//             return new ElectricBill(name, danToc, khuVuc, diemThi);
//         }

//         private String normalizeName(String name) {
//             String[] s = name.split("\\s+");
//             String s1 = "";
//             for (String i : s) {
//                 s1 += (i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
//             }
//             return s1.trim();
//         }

//         @Override
//         public String toString() {
//             return code + " " + name + " " + String.format("%.1f", diemTong) + " " + trangThai;
//         }
//     }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {
    public static int NUM_ID = 1;
    private String id, name, ethnic, status;
    private Double score, totalScore;
    private int area;

    public Candidate(String name, Double score, String ethnic, int area) {
        this.id = String.format("TS%02d", NUM_ID++);
        this.name = normalizeName(name);
        this.score = score;
        this.ethnic = ethnic;
        this.area = area;
        this.totalScore = getTotalScore();
        this.status = getTotalScore() < 20.5 ? "Truot" : "Do";
    }

    public Double getAreaBonus() {
        switch (area) {
            case 1:
                return 1.5;
            case 2:
                return 1.0;
            case 3:
                return 0.0;
            default:
                return 0.0;
        }
    }

    public Double getEthnicBonus() {
        switch (ethnic) {
            case "Kinh":
                return 0.0;
            default:
                return 1.5;
        }

    }

    public Double getTotalScore() {
        return score + getAreaBonus() + getEthnicBonus();
    }

    public String normalizeName(String name) {
        String[] words = name.trim().split("\\s+");
        String res = "";
        for (String word : words) {
            res += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", totalScore) + " " + status;
    }

    @Override
    public int compareTo(Candidate o) {
        if (this.totalScore - o.totalScore == 0)
            return this.id.compareTo(o.id);
        return o.totalScore.compareTo(this.score);
    }

}

public class J07057 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        ArrayList<Candidate> candidates = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String name = sc.nextLine().trim();
            Double score = Double.parseDouble(sc.nextLine().trim());
            String ethnic = sc.nextLine().trim();
            int area = Integer.parseInt(sc.nextLine().trim());
            candidates.add(new Candidate(name, score, ethnic, area));
        }
        Collections.sort(candidates);
        candidates.forEach(System.out::println);
    }
}