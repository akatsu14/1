package J04005;

import java.util.Scanner;

/**
 * J04005
 */
class ThiSinh {
    private String hoTen, ngaySinh;
    private Double diemMon1, dienMon2, dienMon3;

    ThiSinh(String hoTen, String ngaySinh, Double diemMon1, Double dienMon2, Double dienMon3) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemMon1 = diemMon1;
        this.dienMon2 = dienMon2;
        this.dienMon3 = dienMon3;
    }

    @Override
    public String toString() {
        return hoTen + " " + ngaySinh + " " + String.format("%.1f", diemMon1 + dienMon2 + dienMon3);
    }

}

public class J04005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh ts = new ThiSinh(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(ts);
        sc.close();
    }

}