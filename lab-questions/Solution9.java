class Solution9 {
    public static void main(String []args) {
        String msg = "This is some sample string with some words that have been repeated some times";
        System.out.println("Original Stirng:  " + msg + "\n");
    
        System.out.println("Total Number of Characters:  " + msg.length());
        System.out.println("Converted to Uppercase:  " + msg.toUpperCase());
        System.out.println("Converted to Lowercase:  " + msg.toLowerCase());
        System.out.println("Index of 'some':  " + msg.indexOf("some"));
        System.out.println("Substring starting from index-8:  " + msg.substring(8));
        System.out.println("Substring starting from index 8 to 19:  " + msg.substring(8, 19));

        String ms = "     hello world!      ";
        System.out.println("Original String:  " + ms);
        ms = ms.trim();
        System.out.println("String with trimmed spaces:  " + ms);
        System.out.println("Replacing 'world' with 'universe':  " + ms.replace("world", "universe"));
        System.out.println("Reversing:  \n" + ms + " -> " + new StringBuffer(ms).reverse());
    }
}