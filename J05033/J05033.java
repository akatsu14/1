package J05033;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * J05033
 */
class ThoiGian {
    Integer gio, phut, giay;

    ThoiGian(Integer gio, Integer phut, Integer giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    @Override
    public String toString() {
        return gio + " " + phut + " " + giay;
    }
}

public class J05033 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThoiGian> list = new ArrayList<ThoiGian>();
        while (n-- > 0) {
            ThoiGian tg = new ThoiGian(sc.nextInt(), sc.nextInt(), sc.nextInt());
            list.add(tg);
        }
        list.sort((a, b) -> {
            if (a.gio.compareTo(b.gio) != 0)
                return a.gio.compareTo(b.gio);
            else if (a.phut.compareTo(b.phut) != 0)
                return a.phut.compareTo(b.phut);
            else
                return a.giay.compareTo(b.giay);
        });
        for (ThoiGian tg : list)
            System.out.println(tg);
    }
}