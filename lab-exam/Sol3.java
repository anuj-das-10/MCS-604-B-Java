// 3. Write a program to demonstrate type casting.
import java.io.PrintStream;

class Sol3 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        double d = 4312.9845783423;
        ps.println("Double: " + d);
        float f = (float) d;
        ps.println("Float: " + f);
        int x = (int) f;
        ps.println("Integer: " + x);
        byte b = (byte) x;
        ps.println("Byte: " + b);
    }
}
