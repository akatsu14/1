import java.util.Scanner;

public class J01007 {

    private static boolean fibo(long n) {
        long a = 100;        
        if(n==0)return true;
        long t = 0;
        long m = 1;
        while (a > 1) {
            a--;
            t = t + m;
            long temp = t;
            t = m;
            m = temp;
            if (n == m) 
                return true;
             if (n < m) 
                return false;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            if (fibo(n))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}