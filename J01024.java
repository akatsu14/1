import java.util.Scanner;

public class J01024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            boolean check = true;
            while (n > 0) {
                long h = n % 10;
                n /= 10;
                if (h > 2) {
                    check = false;
                    System.out.println("NO");
                    break;
                }
            }
            if (check)
                System.out.println("YES");
        }
        sc.close();
    }
}
