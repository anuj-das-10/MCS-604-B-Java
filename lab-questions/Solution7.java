class Rectangle { 
    int l, b;
    Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    void calcArea() {
        System.out.println("The Area of the given Rectangle is: " + l*b);
    }

    void calcPerimeter() {
        System.out.println("The Perimeter of the given Rectangle is: " + 2*(l+b));
    }
}

class Box extends Rectangle {
    int h;
    Box(int l, int b, int h) {
        super(l, b);
        this.h = h;
    }

    void calcVolume() {
        System.out.println("The Volume of the given Box is: " + l*b*h);
    }
}

class Solution7 { 
    public static void main(String []args) {
        Rectangle r = new Rectangle(8, 4);
        r.calcArea();
        r.calcPerimeter();

        Box b = new Box(8, 4, 5);
        b.calcVolume();
    }
}