import java.util.Scanner;
import java.lang.Math;

public class J01010 {
    private static void solve(long n) {
        double a = 0;
        boolean check = true;
        String s1 = Long.toString(n);
        String s2;
        while (n >= 1) {
            long t = n % 10;
            s2 = Long.toString(n);
            n = n / 10;
            if (t == 0 || t == 1) {
                a = a + t * Math.pow(10, s1.length() - s2.length());
            } else if (t == 8) {
                a = a + 0 * Math.pow(10, s1.length() - s2.length());
            } else if (t == 9) {
                a = a + 0 * Math.pow(10, s1.length() - s2.length());
            } else {
                check = false;
                break;
            }
        }
        long result = Double.valueOf(a).longValue();
        
        if (check&&result>0)
            System.out.println(result);
        else{
            System.out.println("INVALID");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            solve(n);
        }
        sc.close();
    }
}
