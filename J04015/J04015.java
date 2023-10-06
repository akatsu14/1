package J04015;

/**
 * J04015
 */
class GiaoVien {
    private String maNgach, hoTen;
    private Long luongCoBan;

    GiaoVien(String maNgach, String hoTen, Long luongCoBan) {
        this.maNgach = maNgach;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    private Long bacLuong() {
        return Long.parseLong(maNgach.substring(2));
    }

    private Long phuCap() {
        String chucVu = maNgach.substring(0, 2);
        if (chucVu.equals("HT"))
            return (long) 2000000;
        else if (chucVu.equals("HP"))
            return (long) 900000;
        else if (chucVu.equals("GV"))
            return (long) 500000;
        else
            return (long) 0;
    }

    @Override
    public String toString() {
        return String.format(
                maNgach + " " + hoTen + " " + bacLuong() + " " + phuCap() + " "
                        + String.format("%d", luongCoBan * bacLuong() + phuCap()));
    }
}

public class J04015 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        GiaoVien gv = new GiaoVien(sc.nextLine(), sc.nextLine(), sc.nextLong());
        System.out.println(gv);
        sc.close();
    }

}