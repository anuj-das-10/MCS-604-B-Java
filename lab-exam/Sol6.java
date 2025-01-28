// 6. Write a program to calculate Simple Interest and data is taken as input from users.
import java.io.PrintStream;
import java.util.Scanner;

class Sol6 {
    static PrintStream ps = System.out; 

    static void calculateSI(float principal, float rate, float time) {
        float si = (principal * rate * time) / 100;
        ps.println("\nPrincipal Amount:  " + principal);
        ps.println("Rate of Interest:  " + rate);
        ps.println("Time Period in years:  " + time);
        ps.println("SIMPLE INTEREST:  " + si);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ps.print("Enter Principal Amount:  ");
        float p = sc.nextFloat();
        ps.print("Enter Rate of Interest:  ");
        float r = sc.nextFloat();
        ps.print("Enter Time Period in years:  ");
        float t = sc.nextFloat();
        calculateSI(p, r, t);
        sc.close();
    }    
}
