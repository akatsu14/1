import java.util.Scanner;
import java.lang.Math;
public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            double n = sc.nextDouble();
            float h = sc.nextFloat();
            // float dienTich = h / 2;
            for (float i = 1; i < n; i++) {
                double day=(Math.sqrt(n));
                double result = (h * Math.sqrt(i)) / day;
                System.out.printf("%.6f ", result);
            }
            System.out.println();
        }
        sc.close();
    }
}
