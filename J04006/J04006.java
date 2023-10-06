package J04006;

import java.util.Scanner;

/**
 * J04006
 */
class SinhVien {
    private String maSV, hoTen, lop, ngaySinh;
    private Double GPA;

    SinhVien(String hoTen, String lop, String ngaySinh, Double GPA) {
        this.maSV = "B20DCCN001";
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
        this.GPA = GPA;
    }

    private String chuanHoaNgaySinh(String ngaySinh) {
        StringBuilder sb = new StringBuilder(ngaySinh);
        if (sb.charAt(1) == '/') {
            sb.insert(0, '0');
        }
        if (sb.charAt(4) == '/') {
            sb.insert(3, '0');
        }
        return sb.toString();

    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + lop + " " + ngaySinh + " " + String.format("%.2f", GPA);
    }

}

public class J04006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien sv = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
        System.out.println(sv);
        sc.close();
    }
}