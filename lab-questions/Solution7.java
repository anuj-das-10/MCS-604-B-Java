class Rectangle { 
    int l, b;
    Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    void calcArea() {
        System.out.println("Area of the given Rectangle is: " + l*b);
    }

    void calcPerimeter() {
        int p = 2*(l+b);
        System.out.println("Perimeter of the given Rectangle is: " + p);
    }
}

class Box extends Rectangle {
    int h;
    Box(int l, int b, int h) {
        super(l, b);
        this.h = h;
    }

    void calcVolume() {
        System.out.println("Volume of the given Box is: " + l*b*h);
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