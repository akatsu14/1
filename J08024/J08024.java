package J08024;

import java.util.*;

/**
 * J08024
 */
public class J08024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        while (n-- > 0) {
            Integer a = sc.nextInt();
            Queue<String> q = new LinkedList<String>();
            q.add("9");
            while (q.size() > 0) {
                String s = q.poll();
                if (Long.parseLong(s) % a == 0) {
                    System.out.println(s);
                    break;
                }
                q.add(s + "0");
                q.add(s + "9");
            }

        }
        sc.close();
    }
}