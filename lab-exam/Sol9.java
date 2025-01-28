// 9. Write a program to demonstrate the use of different String class methods.

import java.io.PrintStream;

class Sol9 {
    static PrintStream ps = System.out;
    public static void main(String[] args) {
        String s = "This is some sample string with some words!";
        ps.println("Original String:  " + s);

        int len = s.length();
        ps.println("Total number of characters:  " + len);

        String lower = s.toLowerCase();
        ps.println("Lowercase: " + lower);
        String upper = s.toUpperCase();
        ps.println("Uppercase: " + upper);

        int idx = s.indexOf("some");
        ps.println("Index of \"some\": " + idx);

        char ch = s.charAt(8);
        ps.println("Character at index-7:  " + ch);

        String sub1 = s.substring(8), sub2 = s.substring(8, 15);
        ps.println("Substring from index-8:  " + sub1);
        ps.println("Substring from index 8 to 15:  " + sub2);
    }
}
