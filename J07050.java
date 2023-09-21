import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07050 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Items> list = new ArrayList<>();
        while (n-- > 0) {
            // sc.nextLine();//thêm vào để chạy trên vscode bỏ đi để nộp codeptit
            list.add(Items.newItem(sc));
        }
        list.sort((a,b) -> (int)(b.getprice() - a.getprice()));
        list.forEach(System.out::println);
        
    }

    static class Items {
        private String code, name, group;
        private Double in, out;
        public static int cnt = 1;

        Items(String name, String group, Double in, Double out) {
            this.code = String.format("MH%02d", cnt++);
            this.name = name;
            this.group = group;
            this.in = in;
            this.out = out;
        }
        static Items newItem(Scanner sc){
            String name= sc.nextLine();            
            String group= sc.nextLine();
            Double in= Double.parseDouble(sc.nextLine());
            Double out= Double.parseDouble(sc.nextLine());

            return new Items(name, group, in, out);
        }
        Double getprice(){
            return this.out-this.in;
        }
        String toprice(){
            return String.format("%.2f", getprice());
        }

        @Override
        public String toString() {
            return code + " " + name + " " + group + " " + toprice();
        }
    }
}
