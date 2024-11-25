public class Sum {
    static int add(int x, int y) {
        return x + y;
    }

    public static void main(String []args) {
        int x = 10, y = 34;
        System.out.printf("%d + %d = %d\n", x, y, add(x, y));
    }
}