import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J01012 {
    private static void snt(long n) {
        long cnt = 0;
        Set<Long> st = new HashSet<>();
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                st.add(i);
                if (n % (n / i) == 0) {
                    st.add(n / i);
                }
            }

        }
        for (Long i : st) {
            if (i % 2 == 0)
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextLong();
            if (n % 2 != 0) {
                System.out.println(0);
                continue;
            }
            snt(n);
        }
        sc.close();
    }
}
