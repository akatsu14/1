package J04003;

import java.util.Scanner;

/**
 * J04003
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
        // if (mauSo == 0)
        // return "";
        // if (tuSo % mauSo == 0)
        // return (tuSo / mauSo) + " ";
        return tuSo / uocChungLonNhat() + "/" + mauSo / uocChungLonNhat();
    }
}

public class J04003 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PhanSo s = new PhanSo(sc.nextLong(), sc.nextLong());
        System.out.println(s);
        sc.close();
    }

}