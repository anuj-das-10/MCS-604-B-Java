import java.util.Scanner;

class Solution5 { 

    static int findHCF(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int findLCM(int a, int b) {
        return (a * b) / findHCF(a, b);
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: \na >>  ");
        int a = sc.nextInt();
        System.out.print("b >>  ");
        int b = sc.nextInt();

        int hcf = findHCF(a, b), lcm = findLCM(a, b);

        System.out.printf("\nThe HCF of %d and %d is %d", a, b, hcf);
        System.out.printf("\nThe LCM of %d and %d is %d\n\n", a, b, lcm);

        sc.close();
    }
}