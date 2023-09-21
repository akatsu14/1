import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class J07051 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Customer> list = new ArrayList<>();

        while (n-- > 0) {
            list.add(Customer.newCustomer(sc));
        }
        list.sort((a, b) -> (b.price() - a.price()));
        list.forEach(System.out::println);
    }

    static class Customer {
        private String name, code, numRoom;
        private Date dateIn, dateOut;
        private Integer serviceCost;
        public static Integer cnt = 1;

        Customer(String name, String numRoom, String dateIn, String dateOut, Integer serviceCost) {
            this.name = normalizeName(name);
            this.numRoom = numRoom;
            this.dateIn = toDate(dateIn);
            this.dateOut = toDate(dateOut);

            this.code =cnt<10? String.format("KH0" + cnt++):String.format("KH" + cnt++);
            this.serviceCost=serviceCost;
        }

        public static Customer newCustomer(Scanner sc) throws Exception {
            String name = sc.nextLine().trim();
            String numRoom = sc.nextLine().trim();
            String dateIn = sc.nextLine().trim();
            String dateOut = sc.nextLine().trim();
            Integer serviceCost = Integer.parseInt(sc.nextLine().trim());
            return new Customer(name, numRoom, dateIn, dateOut, serviceCost);
        }

        public Date toDate(String s) {
            try {
                StringBuilder sb = new StringBuilder(s);
                if (s.charAt(2) != '/')
                    sb.insert(0, '0');
                if (s.charAt(5) != '/')
                    sb.insert(3, '0');
                return new SimpleDateFormat("dd/MM/yyyy").parse(sb.toString());
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }

        public String normalizeName(String name) {
            String[] s = name.split("\\s+");
            String s2 = "";
            for (String i : s) {

                s2 = s2 + i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + ' ';
            }
            return s2;
        }

        public String Floor() {
            return numRoom.substring(0, 1);
        }

        public Integer price() {
            int res = 0;
            switch (Floor()) {
                case "1":
                    res = 25;
                    break;
                case "2":
                    res = 34;
                    break;
                case "3":
                    res = 50;
                    break;
                case "4":
                    res = 80;
                    break;
                default:
                    break;
            }
            return res*time()+ serviceCost;
        }
        public Integer time(){
            return  (int)((dateOut.getTime()-dateIn.getTime())/(3600*24*1000)+1);
        }
        @Override
        public String toString() {
            return code + " " + name + " "+numRoom+" " + time() + " " + price();
        }
    }
}
