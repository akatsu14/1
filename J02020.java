import java.util.Scanner;

public class J02020 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int a[]=new int[k];
        for(int i=0;i<k;i++){
            a[i]=i+1;
        }
        int cnt=0;
        
        while(true) {
            for (int x : a) {
                System.out.print(x+" ");
            }
            cnt++;
            System.out.println();
            if(a[0]==n-k+1)break;
            int i=k-1;
            while(a[i]==n-k+i+1)i--;
            a[i]++;
            for (int j = i+1;j<k; j++) {
                a[j]=a[j-1]+1;
            }
            
        }
        System.out.println("Tong cong co "+cnt+" to hop");
        sc.close();
    }
}
