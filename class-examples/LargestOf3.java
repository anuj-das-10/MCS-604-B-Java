class LargestOf3 {
    
    static void findLargestMethod1(int x, int y, int z) {
        if(x > y && x > z) {
            System.out.printf("%d is the largest!", x);
        }
        else if(y > x && y > z) {
            System.out.printf("%d is the largest!", y);
        }
        else {
            System.out.printf("%d is the largest!", z);
        }
    }

    static void findLargestMethod2(int x, int y, int z) {
        if(x > y) {
            if(x > z) {
                System.out.printf("%d is the largest!", x);
            }
            else {
                System.out.printf("%d is the largest!", z);
            }
        } 
        else {
            if(y > x) {
                if(y > z) {
                    System.out.printf("%d is the largest!", y);
                }
                else {
                    System.out.printf("%d is the largest!", z);
                }
            }
        }
    }
    
    static void findLargestMethod3(int x, int y, int z) {
        int currMax = x;
        if(currMax < y) {
            currMax = y;
        }
        if(currMax < z) {
            currMax = z;
        }
        System.out.printf("%d is the largest!", currMax);
    }

    static void findLargestMethod4(int x, int y, int z) {
        int currMax = x;
        currMax = y > currMax ? y : z > currMax ? z : x;
        System.out.printf("%d is the largest!", currMax); 
    }

    public static void main(String []args) {
        // findLargestMethod1(23, 45, 16);
        // findLargestMethod2(120, 50, 40);
        // findLargestMethod3(50, 30, 105);
        // findLargestMethod4(22, 20, 24);
    }    
}
