class Solution2 {
    public static void main(String ...args) {
        int sum = 0, min = Integer.parseInt(args[0]), 
        max = Integer.parseInt(args[0]), n = args.length;

        System.out.print("Given 'n' numbers:  ");
        for(String num : args) {
            System.out.print(num + " ");
            int x = Integer.parseInt(num);
            sum += x;
            if(x < min) {
                min = x;
            }

            if(x > max) {
                max = x;
            }
        }
        System.out.println("\n\nMax Value: " + max);
        System.out.println("Min Value: " + min);
        System.out.println("The Sum of Integers: " + sum);
        System.out.println("The Average of Integers: " + (float)sum/n);
    }
}