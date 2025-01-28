class Solution11 {
    public static void main(String[] args) {
        try {
            // Outer try block
            System.out.println("Outer try block started.");

            int[] num = {1, 2, 3};
            System.out.println("Accessing an element: " + num[2]);

            try {
                // Inner try block
                System.out.println("Inner try block started.");
                int result = 10 / 0;    
                System.out.println("Result: " + result);
            } 
            catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Outer try block continues...");
            System.out.println("Accessing an invalid index: " + num[5]);        // This will cause an ArrayIndexOutOfBoundsException
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues after the try-catch blocks.");
    }
}
