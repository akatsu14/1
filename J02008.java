import java.util.Scanner;

public class J02008 {
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static long BCNN(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while ((t--) > 0) {
            long n = sc.nextInt();
            if(n<=2){
                System.out.println(n);
                continue;
            }
            long temp = BCNN(2, 3);
            for (long i = 4; i <= n; i++) {
                temp = BCNN(temp, i);
            }
            System.out.println(temp);
        }
        sc.close();
    }
}
