package J04004;

import java.util.Scanner;

/**
 * J04004
 */
class PhanSo {
    private Long tuSo, mauSo;

    PhanSo(Long tuSo, Long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    private long uocChungLonNhat() {
        long a = tuSo;
        long b = mauSo;
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    @Override
    public String toString() {
        return tuSo / uocChungLonNhat() + "/" + mauSo / uocChungLonNhat();
    }
}

public class J04004 {

    public static void main(String[] args) {
        Long tuSo1, mauSo1, tuSo2, mauSo2;
        Scanner sc = new Scanner(System.in);
        tuSo1 = sc.nextLong();
        mauSo1 = sc.nextLong();
        tuSo2 = sc.nextLong();
        mauSo2 = sc.nextLong();
        PhanSo s1 = new PhanSo(tuSo1 * mauSo2 + tuSo2 * mauSo1, mauSo1 * mauSo2);
        System.out.println(s1);
        sc.close();
    }

}