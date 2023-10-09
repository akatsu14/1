package J04002;

import java.util.Scanner;

/**
 * J04002
 */
class Rectange {
    private Double width, height;
    private String color;

    Rectange() {
        this.width = 1.0;
        this.height = 1.0;
    }

    Rectange(Double width, Double height, String color) {
        this.width = width;
        this.height = height;
        this.color = chinhColor(color);
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String chinhColor(String color) {
        return color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
    };

    public Double findArea() {
        return height * width;
    }

    public Double findPerimeter() {
        return (height + width) * 2;
    }

    @Override
    public String toString() {
        return findPerimeter().longValue() + " " + findArea().longValue() + " " + color;
    }

}

public class J04002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height, width;
        height = sc.nextDouble();
        width = sc.nextDouble();
        String color = sc.next();
        Rectange rec = new Rectange(width, height, color);
        if (height > 0 && width > 0)
            System.out.print(rec);
        else
            System.out.print("INVALID");
        sc.close();
    }
}