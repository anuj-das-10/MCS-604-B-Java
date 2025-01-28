import java.io.PrintStream;
import java.util.Scanner;

class Sol4 {
    static PrintStream ps = System.out;
    static void check(int n) {
        if(n == 1) {
            ps.println("1 is neither prime nor composite!");
        }

        for(int i = 2; i < (int) n / 2; i++) {
            if(n % i == 0) {
                ps.println(n + " is not a prime number!");
                return;
            }
        }

        ps.println(n + " is a prime number!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ps.print("Enter a number:  ");
        int n = sc.nextInt();

        check(n);
        sc.close();
    }    
}
