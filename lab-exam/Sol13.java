// 13. Write a program to implement custom Exception.

import java.io.PrintStream;
import java.util.Scanner;

class NegativeRadiusException extends Exception {
    @Override
    public String getMessage() {
        return "Radius can not be negative!";
    }

    @Override
    public String toString() {
        return "Radius can not be negative!";
    }
}

class Sol13 {
    static PrintStream ps = System.out;

    static void calcArea(int rad) throws NegativeRadiusException {
        if(rad < 0) {
            throw new NegativeRadiusException();
        }
        else {
            float area = (float) Math.PI * rad * rad;
            ps.println("Area of Circle:  " + area);
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        ps.print("Enter the radius of the circle:  ");
        int rad = sc.nextInt();

        try {
            calcArea(rad);
        }
        catch(NegativeRadiusException e) {
            ps.println(e.getMessage());
        }
        sc.close();
    }
}
