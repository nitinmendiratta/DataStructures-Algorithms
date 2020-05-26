package Heap_Hash;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/find-missing-elements-of-a-range/
 * Time complexity is O(n + (high-low+1)).
 */
public class Ha30_FindMissingElementsOfaRange {

	// Print all elements of range [low, high] that are not present in arr[0..n-1]
	static void printMissing(int arr[], int low, int high){
		int n = arr.length;
		// Insert all elements of arr[] in set
		Set<Integer> s = new HashSet<Integer>();
		for (int i=0; i<n; i++)
			s.add(arr[i]);

		// Traverse throught the range an print all missing elements
		for (int x=low; x<=high; x++)
			if (!s.contains(x))
				System.out.print(x+", ");
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 4};
		int low = 1, high = 10;
		printMissing(arr,low, high);
	}
}
