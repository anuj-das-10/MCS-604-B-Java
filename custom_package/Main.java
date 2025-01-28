import java.util.Scanner;
import search.unsorted.LinearSearch;

public class Main {

    static void display(int arr[], String caption) {
        System.out.print(caption);
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println("");
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearSearch ls = new LinearSearch();

        System.out.print("Enter the size of array:  ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " numbers!");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        display(arr, "Given array:  ");

        System.out.print("Enter the number to be searched:  ");
        int target = sc.nextInt();

        ls.search(arr, target);
        sc.close();
    }   
}
