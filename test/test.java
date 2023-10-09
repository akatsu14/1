import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    class Student {
        private String maSV, ten, lop;

        Student(String maSV, String ten, String lop) {
            this.maSV = maSV;
            this.ten = ten;
            this.lop = lop;
        }

    }

    class DiemDanh {
        private String maSv, diemDanh;

        DiemDanh(String maSv, String diemDanh) {
            this.maSv = maSv;
            this.diemDanh = diemDanh;
        }

    }

    class DanhSach {
        private ArrayList<Student> students;
        private ArrayList<DiemDanh> diemDanhs;
        Scanner sc = new Scanner(System.in);

        DanhSach(Student st) {
            this.students = getStudents();
            this.diemDanhs = getDiemDanhs();
        }

        private Student getStudent() {
            String maSV = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            return new Student(maSV, ten, lop);
        }

        private ArrayList<Student> getStudents() {
            ArrayList<Student> studs = new ArrayList<>();
            int t = sc.nextInt();
            while (t-- > 0) {
                studs.add(getStudent());
            }
            return studs;
        }

        private ArrayList<DiemDanh> getDiemDanhs() {
            ArrayList<DiemDanh> ds = new ArrayList<>();
            int t = sc.nextInt();
            while (t-- > 0) {
                ds.add(getDiemDanh());
            }
            return ds;
        }

        private DiemDanh getDiemDanh() {
            String maSv = sc.nextLine();
            String diemDanh = sc.nextLine();
            return new DiemDanh(maSv, diemDanh);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

    }
}