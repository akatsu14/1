package J08012;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * J08012
 */
public class J08012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for (int i = 0; i < t - 1; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            mp.put(a, mp.getOrDefault(a, 0) + 1);
            mp.put(b, mp.getOrDefault(b, 0) + 1);

        }

        System.out.println(mp.containsValue(t - 1) ? "Yes" : "No");
        sc.close();
    }
}