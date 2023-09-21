import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) > 0) {
            int n = sc.nextInt();
            long tong = 0;
            long vt[] = new long[n+5];
            for (int i = 0; i < n; i++) {
                vt[i] = sc.nextLong();
                tong += vt[i];
            }
            tong-= vt[0];
            long tong2 = 0;
            int index = -1;
            for (int i = 0; i < n - 1; i++) {
                
                tong2 += vt[i];
                tong -= vt[i+1];
                if (tong2 == tong) {
                    index=i+2;
                    break;
                }
            }
            System.out.println(index);
        }
        sc.close();
    }
}
