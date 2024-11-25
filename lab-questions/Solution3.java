class Solution3 {
    public static void main(String []args) {
        double d = 14325.7534591234;
        System.out.println("double: " + d);

        float ff = (float)d;
        System.out.println("double to float:  " + ff);

        int n = (int)ff;
        System.out.println("float to int:  " + n);
        
        byte b = (byte)n;
        System.out.println("int to byte:  " + b);
    }
}