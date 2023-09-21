import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07071 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<DanhSach> list = new ArrayList<>();
        List<DanhSach> list2 = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            list.add(DanhSach.newDanhSach(sc));
        }
        int t = Integer.parseInt(sc.nextLine());
        List<String[]> tenVietTat = new ArrayList<>();
        while (t-- > 0) {
            String[] s=sc.nextLine().split("\\.");
            tenVietTat.add(s);
        }
        list.sort((a, b) -> {
            if (a.lastName.equals(b.lastName)) {
                return a.firstName.compareTo(b.firstName);
            }
            return a.lastName.compareTo(b.lastName);
        });    
        String[] k2 = { "T", "*", "D" };
        tenVietTat.add(k2);
        for (String[] i : tenVietTat) {
            list2.addAll( list.stream()
                    .filter(a -> {
                        if (i.length!=a.fullName.split("\\s").length)return false;
                        if (i[i.length-1].equals("*")) {
                            return (a.first.equals(i[0]) &&
                                    a.middle.equals(i[1]));
                        } else if (i[1].equals("*")) {
                            return (a.first.equals(i[0]) &&
                                    a.last.equals(i[i.length-1]));
                        } else {
                            return (a.middle.equals(i[1]) &&
                                    a.last.equals(i[i.length-1]));
                        }
                    }).collect(Collectors.toList()));
        }
        
        list2.forEach(System.out::println);
    }

    static class DanhSach {
        private String fullName, firstName, lastName, middleName;
        private String first, last, middle;

        DanhSach(String name) {
            this.fullName = normalizeName(name);
            String[] s = this.fullName.split(" ");
            this.lastName = s[s.length - 1];
            this.firstName = s[0];
            this.middleName = s[1];
            this.first = Character.toString(this.firstName.charAt(0));
            this.last = Character.toString(this.lastName.charAt(0));
            this.middle = Character.toString(this.middleName.charAt(0));
        }

        public static DanhSach newDanhSach(Scanner sc) {
            String name = sc.nextLine().trim();
            return new DanhSach(name);
        }

        private String normalizeName(String name) {
            String[] s = name.split("\\s+");
            String s1 = "";
            for (String i : s) {
                s1 += (i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
            }
            return s1.trim();
        }

        @Override
        public String toString() {
            return fullName;
        }
    }
}
