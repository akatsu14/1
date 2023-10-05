import java.util.Scanner;
import java.util.Vector;

public class J02022 {
    public static Boolean soLienTiepLonHon1(Long n) {
        while (n > 0) {
            Long tmp = n % 10;
            Long tmp2 = (n / 10) % 10;
            if (Math.abs(tmp - tmp2) == 1) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static Boolean khongChuaSo(Long n, Long k) {
        while (n > 0) {
            Long tmp = n % 10;
            if (tmp == k) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Long dau = (long) Math.pow(10, n - 1);
            for (Long i = dau; i < dau * 10; i++) {
                Boolean check = true;
                if (khongChuaSo(i, (long) 0) == false) {
                    check = false;

                }
                if (soLienTiepLonHon1(i) == false) {
                    check = false;
                }
                for (Long j = (long) 1; j <= n; j++) {
                    if (khongChuaSo(i, j) == true) {
                        check = false;
                        break;
                    }
                    if (check == false)
                        break;
                }
                if (check == true)
                    System.out.print(i + " ");
            }

        }
        sc.close();
    }
}
