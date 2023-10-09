package J04009;

import java.util.*;

/**
 * J04009
 */
class Point {
    private double x, y;

    Point() {
        x = 0;
        y = 0;
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
        return Math.sqrt(Math.pow(Math.abs(this.x - secondPoint.x), 2) + Math.pow(Math.abs(this.y - secondPoint.y), 2));
    }

    @Override
    public String toString() {
        return x + y + "";
    }
}

public class J04009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            Point x = new Point(sc.nextDouble(), sc.nextDouble());
            Point y = new Point(sc.nextDouble(), sc.nextDouble());
            Point z = new Point(sc.nextDouble(), sc.nextDouble());
            Double a = x.distance(y);
            Double b = y.distance(z);
            Double c = x.distance(z);
            if (a + b > c && a + c > b && b + c > a && Math.abs(a - c) < b && Math.abs(a - b) < c
                    && Math.abs(b - c) < a) {
                System.out.printf("%.2f\n", Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (c - a + b)) / 4);
            } else
                System.out.println("INVALID");
        }
        sc.close();
    }
}