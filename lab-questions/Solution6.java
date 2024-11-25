import java.util.Scanner;

class Solution6 { 

    static void calculateSI(int principal, float rate, int time) {
        System.out.println("Principal Amount: Rs. " + principal);
        System.out.println("Rate: " + rate);
        System.out.println("Time: " + time);

        float si = (principal * rate * time) / 100;
        System.out.println("Simple Interest: Rs. " + si);
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount:  Rs. ");
        int p = sc.nextInt();

        System.out.print("Enter rate: ");
        float r = sc.nextFloat();

        System.out.print("Enter time (in year):  ");
        int t = sc.nextInt();

        calculateSI(p, r, t);
        sc.close();
    }
}