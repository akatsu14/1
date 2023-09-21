import java.util.Scanner;
import java.lang.Math;

public class J01026 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            long n=sc.nextLong();   
            long n2=(long)Math.sqrt(n);
            if(n2*n2==n){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        sc.close();
    }
}
