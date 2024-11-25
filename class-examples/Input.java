import java.util.Scanner;

class Input {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:  ");
        int n = sc. nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("i: " + i);
        }
    }
}
