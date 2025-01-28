// 12. Write a program to that implement throw and throws.

import java.io.PrintStream;
import java.util.Scanner;

class Sol12 {
    static PrintStream ps = System.out;

    static void divide(int x, int y) throws ArithmeticException {
        if(y == 0) {
            throw new ArithmeticException("Cannot divide an integer by zero!");
        }
        else {
            ps.println(x + " / " + y + " = " + (float)x / y);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ps.println("Enter the following values:");
        try {
            ps.print("x >> ");
            int x = sc.nextInt();
            ps.print("y >> ");
            int y = sc.nextInt();

            divide(x, y);
        }
        catch(ArithmeticException e) {
            ps.println(e.getMessage());
        }

        sc.close();
    }
}
