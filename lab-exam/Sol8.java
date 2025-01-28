// 8. Write a program to design a class Shape to implement 
// runtime polymorphism using abstract method and classes.

import java.io.PrintStream;
import java.util.Scanner;

abstract class Shape {
    abstract void calcArea();
    abstract void calcPerimeter();
}

class Rectangle extends Shape {
    int length, width;
    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void calcArea() {
        int area = length * width;
        System.out.println("Area of Rectangle:  " + area);
    }

    @Override
    void calcPerimeter() {
        int peri = 2 * (length + width);
        System.out.println("Perimeter of Rectangle:  " + peri);
    }
}

class Sol8 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ps.print("Enter length of the rectangle:  ");
        int l = s.nextInt();
        ps.print("Enter width of the rectangle:  ");
        int w = s.nextInt();

        Rectangle r = new Rectangle(l, w);
        r.calcArea();
        r.calcPerimeter();
        s.close();
    }
}
