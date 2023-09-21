import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Staff> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(Staff.newStaff(sc));
        }

        list.forEach(System.out::println);
    }
}

class Staff{
    private String code,name,dob,rank;
    private Double lt,th;
    private int age;
    public static int count = 1;

    public Staff(String name, String dob, Double lt, Double th) {
        this.code = String.format("PH%02d", count++);
        this.name = Normalize(name);
        this.age = 2021 - Integer.parseInt(formatDate(dob).substring(6, 10));;
        this.lt = lt;
        this.th = th;
        
        switch(getScore()){
            case 10: this.rank = "Xuat sac"; break;
            case 9: this.rank = "Xuat sac"; break;
            case 8: this.rank = "Gioi"; break;
            case 7: this.rank = "Kha"; break;
            case 6: this.rank = "Trung binh"; break;
            case 5: this.rank = "Trung binh"; break;
            default: this.rank = "Truot"; break;
        }

    }

    public static Staff newStaff(Scanner sc){
        String name = sc.nextLine();
        String dob = sc.nextLine();
        Double lt = Double.parseDouble(sc.nextLine());
        Double th = Double.parseDouble(sc.nextLine());
        return new Staff(name, dob, lt, th);
    }

    public String Normalize(String s){
        String[] arr = s.trim().split("\\s+");
        String res = "";
        for (String string : arr) {
            res += string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    public String formatDate(String s)  {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(2) != '/')
            sb.insert(0, '0');
        if (sb.charAt(5) != '/')
            sb.insert(3, '0');
        return sb.toString();
    }

    public double bonus(){
        if(this.lt >= 8 && this.th >= 8) return 1;
        else if(this.lt >= 7.5 && this.th >= 7.5) return 0.5;
        else return 0;
    }

    public int getScore() {
        return (int) Math.min(10, Math.round((lt + th) / 2 + bonus()));
    }

    @Override
    public String toString(){
        return code + " " + name + " " + age + " " + getScore() + " " + rank;
    }
}
