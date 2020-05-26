package Heap_Hash;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/convert-array-reduced-form/
 * time complexity is O(n Log n).
 */
public class Ha34_ConvertArrayToReducedForm {

	static void convert(int arr[]){
		int n = arr.length;
		// Create a temp array and copy contents of arr[] to temp
		int temp[] = new int[n];

		System.arraycopy(arr, 0, temp, 0, temp.length);

		// Sort temp array
		Arrays.sort(temp);

		// Create a hash table
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();

		// One by one insert elements of sorted
		// temp[] and assign them values from 0
		// to n-1
		int val = 0;
		for (int i = 0; i < n; i++)
			hp.put(temp[i], val++);

		// Convert array by taking positions from map
		for (int i = 0; i < n; i++)
			arr[i] = hp.get(arr[i]);
	}

	public static void main(String[] args) {
		int arr[] = {10, 20, 15, 12, 11, 50};
		convert(arr);

		System.out.println("\n\nConverted Array is \n");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
}
