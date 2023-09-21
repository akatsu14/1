import java.util.Scanner;

public class J01018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t > 0) {
            t--;
            boolean check = true;
            long n = sc.nextLong();
            long tong = 0;
            while (n > 10) {
                long k = n % 10;
                tong += k;
                n /= 10;
                if (Math.abs(k - n % 10) != 2) {
                    check = false;
                    System.out.println("NO");
                    break;
                }
            }
            if (check) {
                tong += n;
                if (tong % 10 == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        sc.close();
    }
}
