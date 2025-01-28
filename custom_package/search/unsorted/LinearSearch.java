package search.unsorted;

public class LinearSearch {
    public void search(int[] arr, int x) {
		for(int i=0; i < arr.length; i++) {
		    if(arr[i]==x) {
		        System.out.println(x + " found at index " + i);
		        return;
		    }
	    }
        System.out.println(x + " not found in this array!");
    }
}
