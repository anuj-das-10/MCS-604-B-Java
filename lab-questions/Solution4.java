import java.util.Scanner;

class Solution4 {

    static void checkPrime(int n) {
        if(n == 1) {
            System.out.println(n + " is neither prime nor composite!");
            return;
        }

        for(int i = 2; i < (int) n/2; i++) {
            if(n % i == 0) {
                System.out.println(n + " is not a prime number!");
                return;
            }
        }
        System.out.println(n + " is a prime number!");
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:  ");
        int num = sc.nextInt();
        checkPrime(num);
        sc.close();
    }
}