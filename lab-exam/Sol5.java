// 5. Write a program to find out the HCF and LCM.
import java.io.PrintStream;
import java.util.Scanner;

class Sol5 {
    static PrintStream ps = System.out;

    static int findHFC(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int findLCM(int a, int b) {
        return (a*b)/findHFC(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ps.print("Enter two numbers:\na >> ");
        int a = sc.nextInt();
        ps.print("b >> ");
        int b = sc.nextInt();

        int hcf = findHFC(a, b), lcm = findLCM(a, b);
        ps.printf("The HCF of %d & %d is %d\n", a, b, hcf);
        ps.printf("The LCM of %d & %d is %d\n", a, b, lcm);
        sc.close();
    }    
}
