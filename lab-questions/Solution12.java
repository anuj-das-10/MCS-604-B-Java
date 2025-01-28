import java.util.Scanner;

class Solution12 {

	static void divide(int a, int b) throws ArithmeticException {
		if(b == 0) {
			throw new ArithmeticException("Divided by zero is not possible");
		}
		else {
            float res = (float) a / b;
            System.out.println(a + "/" + b + " = " + res);
		}
	}

	public static void main(String[] args) {
		try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the following values:  \na >> ");
            int a = sc.nextInt();
            System.out.print("b >> ");
            int b = sc.nextInt();
			divide(a, b);
		}
		catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
	}
}