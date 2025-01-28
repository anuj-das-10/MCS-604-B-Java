// 14. Write a program to implement the concept of multiple interfaces.

import java.io.PrintStream;

interface Area {
    public void calcArea();
}

interface Perimeter {
    public void calcPerimeter();    
}

class Rectangle implements Area, Perimeter {
    int len, wid;
    Rectangle(int len, int wid) {
        this.len = len;
        this.wid = wid;
    }

    @Override
    public void calcArea() {
        int area = len * wid;
        System.out.println("Area of Rectangle:  " + area);
    }

    @Override
    public void calcPerimeter() {
        int peri = 2 * (len + wid);
        System.out.println("Perimeter of Rectangle:  " + peri);
    }
}

class Sol14 {
    static PrintStream ps = System.out;

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        r.calcArea();
        r.calcPerimeter();
    }
}