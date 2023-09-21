import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07059 {
    public static void main(String[] args) throws Exception{
        Scanner sc =new Scanner(new File("CATHI.in"));
        int n=Integer.parseInt(sc.nextLine());
        List<MonThi> list=new ArrayList<>();
        while (n-->0) {
            list.add(MonThi.newMonThi(sc));
        }
        list.sort((a, b) -> {
            if(a.ngayThi.equals(b.ngayThi)){
                
                if(a.gioThi.equals(b.gioThi)) {
                    return a.maMon.compareTo(b.maMon);
                }
                return a.gioThi.compareTo(b.gioThi);
            }
            return a.ngayThi.compareTo(b.ngayThi);
        });
        list.forEach(System.out::println);
    }
    static class MonThi{
        private String maMon,gioThi,phongThi,ngayThi;
        public static int cnt=1;
        MonThi(String ngayThi,String gioThi,String phongThi ){
            this.maMon=String.format("C%03d", cnt++);
            this.ngayThi=ngayThi;            
            this.gioThi=gioThi;
            this.phongThi=phongThi;
        }
        public static MonThi newMonThi(Scanner sc){
            String ngayThi=sc.nextLine().trim();
            String gioThi=sc.nextLine().trim();
            String phongThi =sc.nextLine().trim();
            return new MonThi(ngayThi, gioThi, phongThi);
        }
        @Override
        public String toString(){
            return maMon + " " + ngayThi + " " + gioThi + " " + phongThi;
        }
    }
}
