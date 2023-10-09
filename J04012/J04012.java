package J04012;

import java.util.Scanner;

/**
 * J04012
 */
class TinhCong {
    private Integer cnt = 1;
    private Long luongCB, soNgayCong;
    private String tenNV, chucVu, maNV;

    public TinhCong(String tenNV, Long luongCB, Long soNgayCong, String chucVu) {
        this.maNV = String.format("NV%02d", cnt++);
        this.tenNV = tenNV;
        this.luongCB = luongCB;
        this.soNgayCong = soNgayCong;
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public Long getLuongCB() {
        return luongCB;
    }

    public Long getSoNgayCong() {
        return soNgayCong;
    }

    public void setMaNv(Integer cnt) {
        this.maNV = String.format("NV%02d", cnt);
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setLuongCB(Long luongCB) {
        this.luongCB = luongCB;
    }

    public void setSoNgayCong(Long soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    private Long LuongThang() {
        return luongCB * soNgayCong;
    }

    private Long Thuong() {
        return soNgayCong >= 25 ? LuongThang() / 5 : soNgayCong >= 22 ? LuongThang() / 10 : 0;
    }

    private Integer PhuCap() {
        switch (chucVu) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            case "NV":
                return 150000;
            default:
                return 0;
        }
    }

    private Long TongLuong() {
        return LuongThang() + Thuong() + PhuCap();
    }

    @Override
    public String toString() {
        return maNV + " " + tenNV + " " + LuongThang() + " " + Thuong() + " " + PhuCap() + " " + TongLuong();
    }
}

public class J04012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TinhCong tc = new TinhCong(sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()),
                sc.nextLine());
        System.out.println(tc);
        sc.close();
    }
}