class Solution9 {
    public static void main(String []args) {
        String msg = "This is some sample string with some words that have been repeated some times";
        System.out.println("Original Stirng:  " + msg + "\n");

        int len = msg.length();
        System.out.println("Total Number of Characters:  " + len);
        
        String uppr = msg.toUpperCase();
        System.out.println("Converted to Uppercase:  " + uppr);

        String lowr = msg.toLowerCase();
        System.out.println("Converted to Lowercase:  " + lowr);

        int idxs = msg.indexOf("some");
        System.out.println("Index of 'some':  " + idxs);

        String subs1 = msg.substring(8), subs2 = msg.substring(8, 19);
        System.out.println("Substring from index-8:  " + subs1);
        System.out.println("Substring from index 8 to 19:  " + subs2);

        String ms = "     hello world!      ";
        System.out.println("Original String:  " + ms);

        ms = ms.trim();
        System.out.println("String with trimmed spaces:  " + ms);
        
        ms = ms.replace("world", "universe");
        System.out.println("Replacing 'world' with 'universe':  " + ms);
        
        StringBuffer rev = new StringBuffer(ms).reverse();
        System.out.println("Reversing:  " + ms + " -> " + rev);
    }
}