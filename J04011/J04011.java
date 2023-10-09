package J04011;

import java.util.Scanner;

/**
 * J04011
 */
class Point3D {
    private double x, y, z;

    Point3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point3D(Point3D p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }

    private Double getX() {
        return x;
    }

    private Double getY() {
        return y;
    }

    private Double getZ() {
        return z;
    }

    public Double distance(Point3D secondPoint) {
        return Math.sqrt(Math.pow(Math.abs(this.x - secondPoint.x), 2) + Math.pow(Math.abs(this.y - secondPoint.y), 2)
                + Math.pow(Math.abs(this.z - secondPoint.z), 2));
    }

    public static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        double a1 = p2.x - p1.x;
        double b1 = p2.y - p1.y;
        double c1 = p2.z - p1.z;
        double a2 = p3.x - p1.x;
        double b2 = p3.y - p1.y;
        double c2 = p3.z - p1.z;
        double a3 = p4.x - p1.x;
        double b3 = p4.y - p1.y;
        double c3 = p4.z - p1.z;
        double d1 = a1 * b2 * c3 + a2 * b3 * c1 + a3 * b1 * c2;
        double d2 = a1 * b3 * c2 + a2 * b1 * c3 + a3 * b2 * c1;
        return d1 == d2;
    }

    @Override
    public String toString() {
        return x + y + z + "";
    }
}

public class J04011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Point3D p1 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());

            if (Point3D.check(p1, p2, p3, p4)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}