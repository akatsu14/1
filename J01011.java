import java.math.BigInteger;
import java.util.Scanner;

public class J01011 {
    private static BigInteger gcd(long a, long b) {
        BigInteger num1 = new BigInteger(Long.toString(a));
        BigInteger num2 = new BigInteger(Long.toString(b));

        BigInteger gcd = num1.gcd(num2);
        return gcd;
    }

    private static void solve(long a, long b) {
        System.out.print(a*b/gcd(a, b).longValue());
        System.out.print(" ");       
        System.out.println(gcd(a, b));

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long a = sc.nextLong();
            long b = sc.nextLong();
            solve(a, b);
            
        }
        sc.close();
    }
}
