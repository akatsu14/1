import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07057 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<ElectricBill> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(ElectricBill.newElectricBill(sc));
        }

        list.sort((a, b) -> {
            if (b.diemTong - a.diemTong == 0)
                return a.code.compareTo(b.code);
            return b.diemTong.compareTo(a.diemTong);
        });
        list.forEach(System.out::println);

    }

    static class ElectricBill {
        private String name, code, trangThai;
        private Double diemTong, uuTien1, uuTien2;

        public static Integer cnt = 1;

        ElectricBill(String name, String danToc, Integer khuVuc, Double diemThi) {
            this.code = String.format("TS%02d", cnt++);
            this.name = normalizeName(name);
            switch (khuVuc) {
                case 1:
                    this.uuTien1 = 1.5;
                    break;
                case 2:
                    this.uuTien1 = (double) 1;
                    break;
                default:
                    this.uuTien1 = (double) 0;
                    break;
            }
            switch (danToc) {
                case "Kinh":
                    this.uuTien2 = (double) 0;
                    break;
                default:
                    this.uuTien2 = 1.5;
                    break;
            }
            this.diemTong = diemThi + this.uuTien1 + this.uuTien2;
            if (this.diemTong < 20.5)
                this.trangThai = "Truot";
            else
                this.trangThai = "Do";

        }

        public static ElectricBill newElectricBill(Scanner sc) {
            String name = sc.nextLine().trim();
            Double diemThi = Double.parseDouble(sc.nextLine());
            String danToc = sc.nextLine().trim();
            Integer khuVuc = Integer.parseInt(sc.nextLine());

            return new ElectricBill(name, danToc, khuVuc, diemThi);
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
            return code + " " + name + " " + String.format("%.1f", diemTong) + " " + trangThai;
        }
    }
}
