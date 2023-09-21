import java.util.Scanner;

public class J01003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        if (a == 0 && b == 0) {
            System.out.print("VSN");
        } else if (a == 0 && b != 0) {
            System.out.print("VN");

        } else {
            System.out.printf("%.2f",-b / a);
        }
        sc.close();
    }
}
