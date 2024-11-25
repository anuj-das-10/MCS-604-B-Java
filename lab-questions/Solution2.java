class Solution2 {
    public static void main(String ...args) {
        int sum = 0, min = Integer.parseInt(args[0]), max = Integer.parseInt(args[0]), n = args.length;

        for(String num : args) {
            System.out.print(num + " ");
            int nmbr = Integer.parseInt(num);
            sum += nmbr;
            if(nmbr < min) {
                min = nmbr;
            }

            if(nmbr > max) {
                max = nmbr;
            }
        }
        System.out.println("\n\nMax Value: " + max);
        System.out.println("Min Value: " + min);
        System.out.println("The Sum of Integers: " + sum);
        System.out.println("The Average of Integers: " + (float)sum/n);
    }
}