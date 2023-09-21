import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07058 {
    public static void main(String[] args) throws Exception{
        Scanner sc =new Scanner(new File("MONHOC.in"));
        int n=Integer.parseInt(sc.nextLine());
        List<MonThi> list=new ArrayList<>();
        while (n-->0) {
            list.add(MonThi.newMonThi(sc));
        }
        list.sort((a, b) -> {
            return a.maMon.compareTo(b.maMon);
        });
        list.forEach(System.out::println);
    }
    static class MonThi{
        private String maMon,tenMon,hinhThucThi;
        MonThi(String maMon,String tenMon,String hinhThucThi ){
            this.maMon=maMon;
            this.hinhThucThi=hinhThucThi;
            this.tenMon=tenMon;

        }
        public static MonThi newMonThi(Scanner sc){
            String maMon=sc.nextLine().trim();
            String tenMon=sc.nextLine().trim();
            String hinhThucThi =sc.nextLine().trim();
            return new MonThi(maMon, tenMon, hinhThucThi);
        }
        @Override
        public String toString(){
            return maMon+" "+tenMon+" "+ hinhThucThi;
        }
    }
}
