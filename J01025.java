import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long xMin = 1001;
        long yMin = 1001;
        long xMax = 0;
        long yMax = 0;
        int t = 4;
        while ((t--) > 0) {
            long xTemp = sc.nextLong();
            long yTemp = sc.nextLong();
            xMin = Math.min(xTemp, xMin);
            xMax = Math.max(xTemp, xMax);
            yMin = Math.min(yTemp, yMin);
            yMax = Math.max(yTemp, yMax);
        }
        long canhMax = Math.max((xMax - xMin),(yMax - yMin));
        System.out.println(canhMax*canhMax);
        sc.close();
    }
}
