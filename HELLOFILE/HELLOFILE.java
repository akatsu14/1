package HELLOFILE;

import java.io.*;
import java.util.Scanner;

public class HELLOFILE {
    private final static String FILE_URL = "./Hello.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(FILE_URL));
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
