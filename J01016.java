import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        int cnt4 = 0, cnt7 = 0;
        while (t > 0) {
            long n = t % 10;
            t /= 10;
            if (n == 4)
                cnt4++;
            else if (n == 7)
                cnt7++;
        }
        int sumCount = cnt4 + cnt7;
        switch (sumCount) {
            case 4:
                System.out.println("YES");
                break;
            case 7:
                System.out.println("YES");
                break;
            default:
                System.out.println("NO");
                break;
        }
        sc.close();
    }
}
