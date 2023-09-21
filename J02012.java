import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class J02012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            list.add(x);
        }
        PriorityQueue<Long> result = new PriorityQueue<Long>();
        for (int i = 0; i < n; i++) {
            System.out.print("Buoc " + cnt + ": ");
            cnt++;
            for (int j = 0; j < cnt ; j++) {
                result.add(list.get(j));
            }
            while (!result.isEmpty()) {
                System.out.print(result.poll()+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
