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

    void calcArea() {
        int area = length * width;
        System.out.println("The Area of the given Rectangle is " + area);
    }
    void calcPerimeter() {
        int peri = 2 * (length + width);
        System.out.println("The Perimeter of the given Rectangle is " + peri);
    }
}

class Solution8 {
    public static void main(String []args) {
        Rectangle r = new Rectangle(12, 6);
        r.calcArea();
        r.calcPerimeter();
    }
}