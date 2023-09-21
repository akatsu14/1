import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07056 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<ElectricBill> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(ElectricBill.newElectricBill(sc));
        }

        list.sort((a, b) -> {
            return b.totalCost.compareTo(a.totalCost);
        });
        list.forEach(System.out::println);

    }

    static class ElectricBill {
        private String name, code;
        private Long totalCost, vuotDinhMuc, trongDinhMuc, dinhMuc;

        public static Integer cnt = 1;

        ElectricBill(String name, String loaiHoGiaDinh, Long chiSoDau, Long chiSoCuoi) {
            this.code = String.format("KH%02d", cnt++);
            this.name = normalizeName(name);
            switch (loaiHoGiaDinh) {
                case "A":
                    this.dinhMuc = (long) 100;
                    break;
                case "B":
                    this.dinhMuc = (long) 500;
                    break;
                default:
                    this.dinhMuc = (long) 200;
                    break;
            }

            this.trongDinhMuc = Math.min(chiSoCuoi - chiSoDau, this.dinhMuc) * 450;
            this.vuotDinhMuc = Math.max(chiSoCuoi - chiSoDau - this.dinhMuc, 0) * 1000;
            this.totalCost = this.trongDinhMuc + this.vuotDinhMuc * 105 / 100;
        }

        public static ElectricBill newElectricBill(Scanner sc) {
            String name = sc.nextLine().trim();
            String[] s2 = sc.nextLine().trim().split(" ");

            String loaiHoGiaDinh = s2[0];
            Long chiSoDau = Long.parseLong(s2[1]);
            Long chiSoCuoi = Long.parseLong(s2[2]);
            return new ElectricBill(name, loaiHoGiaDinh, chiSoDau, chiSoCuoi);
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
            return code + " " + name + " " + trongDinhMuc + " " + vuotDinhMuc + " " + (long)(vuotDinhMuc * 0.05) + " "
                    + totalCost;
        }
    }
}
