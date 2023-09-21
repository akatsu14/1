import java.util.Scanner;

public class J01017 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();
        while(t>0){
            t--;
            boolean check=true;
            long n=sc.nextLong();
            while(n>10){
                long k=n%10;
                n/=10;
                if(Math.abs(k-n%10)!=1){
                    check=false;
                    System.out.println("NO");
                    break;
                }
            }                    
            if(check)System.out.println("YES");
        }
        sc.close();
    }
}
