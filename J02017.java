import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J02017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>lt=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            lt.add(sc.nextInt());
        }
        while(true){
            boolean check=true;
            for (int i = 0; i <lt.size()-1; i++) {
                if((lt.get(i)+lt.get(i+1))%2==0){
                    lt.remove(i);                   
                    lt.remove(i);
                    check=false;
                }
            }
            if(check)break;
        }
        System.out.println(lt.size());
        sc.close();
    }
}
