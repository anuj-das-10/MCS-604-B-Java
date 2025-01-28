// 2. Write a program to find the sum, average, min and max of the 'n' numbers using user input.

import java.io.PrintStream;

class Sol2 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        int sum = 0, max = 0, min = Integer.MAX_VALUE;
        int n = args.length;

        for(String x : args) {
            int num = Integer.parseInt(x);
            sum += num;

            if(max < num) {
                max = num;
            }

            if(min > num) {
                min = num;
            }
        }

        float avg = (float) sum / n;
        ps.println("Sum: " + sum);
        ps.println("Average: " + avg);
        ps.println("Max: " + max);
        ps.println("Min: " + min);
    }    
}
