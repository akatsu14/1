package J04009;

import java.util.*;

/**
 * J04009
 */
class Point {
    private double x, y;

    Point() {
        x = 1;
        y = 1;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    private Double getX() {
        return x;
    }

    private Double getY() {
        return y;
    }

    public Double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(Math.abs(this.x - secondPoint.x), 2) +
                Math.pow(Math.abs(this.y - secondPoint.y), 2));
    }

    @Override
    public String toString() {
        return x + y + "";
    }
}
// class Point {
// private double x, y;

// Point() {
// x = 1;
// y = 1;
// }

// Point(Double x, Double y) {
// this.x = x;
// this.y = y;
// }

// double getX() {
// return x;
// }

// double getY() {
// return y;
// }

// double distance(Point secondPoint) {
// return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y -
// secondPoint.y, 2));
// }

// double distance(Point p1, Point p2) {
// return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
// }

// public String toString() {
// return x + " " + y;
// }
// }

public class J04009 {
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int test = sc.nextInt();
    // while (test-- > 0) {
    // Point x = new Point(sc.nextDouble(), sc.nextDouble());
    // Point y = new Point(sc.nextDouble(), sc.nextDouble());
    // Point z = new Point(sc.nextDouble(), sc.nextDouble());
    // Double a = x.distance(y);
    // Double b = y.distance(z);
    // Double c = x.distance(z);
    // if (a + b > c && a + c > b && b + c > a && Math.abs(a - c) < b && Math.abs(a
    // - b) < c
    // && Math.abs(b - c) < a) {
    // System.out.printf("%.2f\n", Math.sqrt((a + b + c) * (a + b - c) * (a - b + c)
    // * (c - a + b)) / 4);
    // } else
    // System.out.println("INVALID");
    // }
    // sc.close();
    // }
    // (a + b + c) * (a + b - c) * (b + (c - a)) * (c + a - b)//sai
    // (a + b + c) * (a + b - c) * (a - b + c) * (c - a + b)//dung
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Point p1 = new Point(x, y);
            x = sc.nextDouble();
            y = sc.nextDouble();
            Point p2 = new Point(x, y);
            x = sc.nextDouble();
            y = sc.nextDouble();
            Point p3 = new Point(x, y);
            double a = p1.distance(p2);
            double b = p2.distance(p3);
            double c = p3.distance(p1);
            if (a == 0 || b == 0 || c == 0 || a + b <= c || b + c <= a || a + c <= b) {
                System.out.println("INVALID");
            } else {
                double s = Math.sqrt((a + b + c) * (b - c + a) * (b + (c - a)) * (c + (a - b))) * 0.25;
                System.out.printf("%.2f \n", s);
            }
        }
    }

}