import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07073 {
public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<MonHoc> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(MonHoc.newMonHoc(sc));
        }

        list.sort((a, b) -> {
            return a.code.compareTo(b.code);
        });
        list.stream()
        .filter(a->!"Truc tiep".equals(a.thucHanh))
        .forEach(System.out::println);

    }
    static class MonHoc{
        private String code, tenMon, lyThuyet, thucHanh;
        private Integer soTin;
        MonHoc(String code,String tenMon,Integer soTin,String lyThuyet,String thucHanh){
            this.code=code;
            this.tenMon=tenMon;
            this.lyThuyet=lyThuyet;
            this.thucHanh=thucHanh;
            this.soTin=soTin;
        }
        public static MonHoc newMonHoc(Scanner sc){
            String code=sc.nextLine();
            String tenMon=sc.nextLine();
            Integer soTin=Integer.parseInt(sc.nextLine());
            String lyThuyet=sc.nextLine();
            String thucHanh=sc.nextLine();
            return new MonHoc(code, tenMon, soTin, lyThuyet, thucHanh);
        }
        @Override
        public String toString(){
            return code+" "+tenMon+" "+soTin+" "+lyThuyet+" "+thucHanh;
        }
    }
}
