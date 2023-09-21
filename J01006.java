import java.util.Scanner;

public class J01006 {
    private static void fibo(int n) {
        long t = 0;
        long m = 1;
        while (n > 1) {
            n--;
            t = t + m;
            long temp = t;
            t = m;
            m = temp;
        }
        System.out.println(m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            fibo(n);
        }
        sc.close();
    }
}
