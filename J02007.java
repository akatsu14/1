import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 1;
        while ((t--) > 0) {
            System.out.println("Test " + cnt + ":");
            cnt++;
            int n =sc.nextInt();
            Map<Integer,Integer>mp=new LinkedHashMap<>();
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                mp.put(x,mp.getOrDefault(x,0)+1);
            }
            for(Map.Entry<Integer,Integer>result:mp.entrySet()){
                System.out.println(result.getKey()+" xuat hien "+result.getValue()+" lan");
            }
        }
        sc.close();
    }
}
