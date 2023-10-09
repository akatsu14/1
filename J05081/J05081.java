package J05081;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * J05081
 */
class MatHang {
    private String ma, ten, donVi;
    private Long giaMua, giaBan, loiNhuan;
    Long cnt = (long) 1;

    MatHang(Integer ma, String ten, String donVi, Long giaMua, Long giaBan) {
        this.ma = String.format("MH%03d", ma);
        this.ten = ten;
        this.donVi = donVi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.loiNhuan = giaBan - giaMua;
    }

    public Long getLoiNhuan() {
        return loiNhuan;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + giaMua + " " + giaBan + " " + loiNhuan;
    }
}

public class J05081 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = n;
        List<MatHang> list = new ArrayList<MatHang>();
        while (n-- > 0) {
            String ten = sc.nextLine();
            String donVi = sc.nextLine();
            long giaMua = Long.parseLong(sc.nextLine());
            long giaBan = Long.parseLong(sc.nextLine());
            MatHang mh = new MatHang((k - n), ten, donVi, giaMua, giaBan);
            list.add(mh);
        }
        Collections.sort(list, (a, b) -> b.getLoiNhuan().compareTo(a.getLoiNhuan()));
        for (MatHang matHang : list) {
            System.out.println(matHang);
        }
    }
}