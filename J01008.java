import java.util.Scanner;

public class J01008 {

    private static void snt(long n) {
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                n = n / i;
                cnt++;
            }
            if (cnt > 0) {
                System.out.print(i);
                System.out.printf("(%d) ", cnt);
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.printf("Test %d: ", i + 1);
            snt(n);
        }
        sc.close();
    }
}