package J04013;

import java.util.Scanner;

/**
 * J04013
 */
class ThiSinh {
    private String ma, ten;
    private Double diemToan, diemLy, diemHoa;

    ThiSinh(String ma, String ten, Double diemToan, Double diemLy, Double diemHoa) {
        this.ma = ma;
        this.ten = ten;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    private Double tongDiem() {
        return diemToan * 2 + diemLy + diemHoa;
    }

    private Double diemUuTien() {
        switch (ma.substring(0, 3)) {
            case "KV1":
                return 0.5;
            case "KV2":
                return 1.0;
            case "KV3":
                return 2.5;
            default:
                return 0.0;
        }
    }

    private String trangThai() {
        if (tongDiem() + diemUuTien() >= 24.0) {
            return "TRUNG TUYEN";
        } else {
            return "TRUOT";
        }
    }

    @Override
    public String toString() {
        if (diemUuTien() == diemUuTien().longValue()) {
            if (tongDiem() == tongDiem().longValue()) {
                return ma + " " + ten + " " + diemUuTien().longValue()
                        + " " + tongDiem().longValue() + " " + trangThai();
            } else
                return ma + " " + ten + " " + diemUuTien().longValue()
                        + " " + tongDiem() + " " + trangThai();
        } else {
            if (tongDiem() == tongDiem().longValue()) {
                return ma + " " + ten + " " + diemUuTien()
                        + " " + tongDiem().longValue() + " " + trangThai();
            } else {
                return ma + " " + ten + " " + diemUuTien()
                        + " " + tongDiem() + " " + trangThai();
            }
        }
    }
}

public class J04013 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ThiSinh ts = new ThiSinh(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(ts);
        sc.close();

    }
}