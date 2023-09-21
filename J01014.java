import java.util.Scanner;

public class J01014 {
    private static long snt(long n) {
        long tong = 0;
        long maxSnt = 1;
        long k = n;
        while (n % 2 == 0) {
            maxSnt = 2;
            n /= 2;
        }
        while (n % 3 == 0) {
            maxSnt = 3;
            n /= 3;
        }

        for (long i = 5; i <= k; i += 6) {
            while (n % i == 0) {
                n /= i;
                if (n == 1) {
                    maxSnt = i;
                    break;
                }
            }
            while (n % (i + 2) == 0) {
                n /= (i + 2);
                tong = tong + i + 2;
                if (n == 1) {
                    maxSnt = i + 2;
                    break;
                }
            }
            if (n == 1) {
                break;
            }
        }
        return maxSnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            System.out.println(snt(n));
        }
        ;
        sc.close();
    }
}
