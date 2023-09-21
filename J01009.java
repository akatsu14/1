import java.util.Scanner;

public class J01009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tong = 0, tich = 1;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            tich *= i;
            tong += tich;
        }
        System.out.print(tong);
        sc.close();
    }
}
