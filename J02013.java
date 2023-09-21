import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J02013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            list.add(x);
        }
        for (int i = 0; i < n - 1; i++) {
            boolean check = true;
            for (int j = 0; j < n - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    check = false;
                }
            }
            if (check)
                break;
            System.out.print("Buoc " + cnt + ": ");
            cnt++;
            for (int j = 0; j < n; j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();

        }

        sc.close();
    }
}