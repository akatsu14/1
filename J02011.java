import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J02011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 1;

        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            list.add(x);
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print("Buoc " + cnt + ": ");
            cnt++;
            long min = list.get(i);
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (min > list.get(j)) {
                    minIndex = j;
                    min = list.get(j);
                }
            }
            Collections.swap(list, i, minIndex);
            for (int j = 0; j < n; j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
