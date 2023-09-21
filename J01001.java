import java.util.Scanner;   
public class J01001 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dai= sc.nextInt();
        int rong=sc.nextInt();
        int chuVi=(dai+rong)*2;
        int dienTich=dai*rong;
        if(dai<=0||rong<=0){
            System.out.print(0);
        }
        else {
            System.out.printf("%d %d",chuVi,dienTich);
        }
        sc.close();
    }
    
}
