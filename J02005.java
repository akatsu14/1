import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Set<Integer> st = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            st.add(x);
        }
        Set<Integer> st2 = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (st.contains(x))
                st2.add(x);
        }
        for (Integer x : st2) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
