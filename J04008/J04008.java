package J04008;

import java.util.Scanner;

/**
 * J04008
 */
class Point {
    private double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
    }

    public double distance(Point p1, Point p2) {
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return x + y + "";
    }
}

public class J04008 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
            Double canh1 = p1.distance(p2);
            Double canh2 = p2.distance(p3);
            Double canh3 = p3.distance(p1);
            if (canh1 + canh2 > canh3 && canh2 + canh3 > canh1 && canh3 + canh1 > canh2 && canh1 > 0 && canh2 > 0
                    && canh3 > 0 && Math.abs(canh1 - canh3) < canh2 && Math.abs(canh1 - canh2) < canh3
                    && Math.abs(canh2 - canh3) < canh1)
                System.out.printf("%.3f\n", canh1 + canh2 + canh3);
            else
                System.out.println("INVALID");
        }
        sc.close();
    }
}