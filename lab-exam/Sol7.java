// 7. Write a program to create a simple class to find out the 
// Area and Perimeter of Rectangle and Box using super and this keyword.

import java.io.PrintStream;

class Rectangle {
    int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    int calcArea() {
        int area = length * width;
        return area;
    }

    int calcPerimeter() {
        int peri = 2 * (length + width);
        return peri;
    }
}

class Box extends Rectangle {
    int height;
    Box(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    int calcVolume() {
        int vol = calcArea() * height;
        return vol;
    }
}

class Sol7 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        Rectangle r = new Rectangle(8, 3);
        ps.println("Area of Rectangle: " + r.calcArea());
        ps.println("Perimeter of Rectangle: " + r.calcPerimeter());

        Box b = new Box(8, 4, 6);
        ps.println("Volume of Box: " + b.calcVolume());
    }
}
