import java.util.Scanner;

public class J01013 {
    private static long snt(long n) {
        long tong = 0;
        long k=n;
        while (n % 2 == 0) {
            tong += 2;
            n /= 2;
        }
        while (n % 3 == 0) {
            tong += 3;
            n /= 3;
        }
        for (long i = 5; i <= k; i += 6) {
            while (n % i == 0) {
                n /= i;
                tong = tong + i;
            }
            while (n % (i + 2) == 0) {
                n /= (i + 2);
                tong = tong + i + 2;
            }
            if (n == 1)
                break;
        }
        return tong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long tong = 0;
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            tong += snt(n);
        }
        System.out.println(tong);
        sc.close();
    }
}
