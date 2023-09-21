import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t > 0) {
            t = t - 1;
            long n = sc.nextLong();
            long tong = (n + 1) * n / 2;
            System.out.println(tong);
        }
        sc.close();
    }
}
