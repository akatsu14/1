package J04007;

import java.util.Scanner;

/**
 * J04007
 */
class NhanVien {
    private String maNV, hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKyHopDong;

    NhanVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue,
            String ngayKyHopDong) {
        this.maNV = "00001";
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKyHopDong = ngayKyHopDong;
    }

    @Override
    public String toString() {
        return maNV + " " + hoTen + " " + gioiTinh + " " + ngaySinh + " " + diaChi + " " + maSoThue + " "
                + ngayKyHopDong;
    }
}

public class J04007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                sc.nextLine(), sc.nextLine());
        System.out.println(nv);
        sc.close();
    }

}