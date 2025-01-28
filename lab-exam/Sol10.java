// 10. Write a program to handle multiple Exceptions.

import java.io.PrintStream;
import java.util.*;

class Sol10 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xt = 0, yt = 0;
        try {
            ps.print("Enter the value of x: ");
            int x = sc.nextInt();
            ps.print("Enter the value of y: ");
            int y = sc.nextInt();
            xt = x; 
            yt = y;
            float div = (float) x / y;
            ps.println(x + " / " + y + " = " + div);
        }
        catch(InputMismatchException e) {
            ps.println("The value of X & Y must be an integer!");
            return;
        }
        catch(ArithmeticException e) {
            ps.println("Cannot divide an integer by 0!");
        }
        catch(Exception e) {
            ps.println(e.getMessage());
        }
        finally {
            sc.close();
        }

        ps.println(xt + " * " + yt + " = " + (xt * yt));
        ps.println(xt + " + " + yt + " = " + (xt + yt));
        ps.println(xt + " - " + yt + " = " + (xt - yt));
        
    }    
}
