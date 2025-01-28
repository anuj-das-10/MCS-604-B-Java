// 11. Write a program to implement nested try-catch block to handle Exception.

import java.io.PrintStream;

class Sol11 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        try {
            ps.println("Outer block started!");
            int arr[] = {1, 2, 3};
            ps.println(arr[1]);
            try {
                ps.println("Inner block started!");
                int result = 10 / 0;
                ps.println("Result:  " + result);
            }
            catch(ArithmeticException e) {
                ps.println("Error: " + e.getMessage());
            }

            ps.println("Outer block continues!");
            ps.println(arr[5]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            ps.println(e.getMessage());
        }

        ps.println("Continues after the try-catch blocks.");
    }
}
