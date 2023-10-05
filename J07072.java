import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07072 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<DanhSach> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(DanhSach.newDanhSach(sc));
        }
        list.sort((a, b) -> {
            if (a.lastName.equals(b.lastName)) {
                if (a.firstName.equals(b.firstName)) {
                    return a.middleName.compareTo(b.middleName);
                }
                return a.firstName.compareTo(b.firstName);
            }
            return a.lastName.compareTo(b.lastName);
        });
        list.forEach(System.out::println);
    }

    static class DanhSach {
        private String fullName, firstName, lastName, middleName;

        DanhSach(String name) {
            this.fullName = normalizeName(name);
            String[] s = this.fullName.split(" ");
            this.lastName = s[s.length - 1];
            this.firstName = s[0];
            this.middleName = s[1];
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