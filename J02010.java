import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J02010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 1;

        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            list.add(x);
        }

        for (int i = 0; i < n-1; i++) {
            System.out.print("Buoc " + cnt + ": ");
            cnt++;
            for (int j = i+1; j < n; j++) {
                if (list.get(i) > list.get(j))
                    Collections.swap(list, i, j);
            }
            for (int j = 0; j < n; j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
