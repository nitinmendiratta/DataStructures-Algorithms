package Array_Matrix;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/find-minimum-difference-pair/
 * O(n Log n)
 */
public class A151_FindMinimumDiffBetweenAny2Elts {

	// Returns minimum difference between any pair
	public int findMinDiff(int arr[]){
		int n = arr.length;
	   // Sort array in non-decreasing order
	   Arrays.sort(arr);
	 
	   // Initialize difference as infinite
	   int diff = Integer.MAX_VALUE;	 
	   // Find the min diff by comparing adjacent
	   // pairs in sorted array
	   for (int i=0; i<n-1; i++)
	      if (arr[i+1] - arr[i] < diff)
	          diff = arr[i+1] - arr[i];
	 
	   // Return min diff
	   return diff;
	}
	public static void main(String[] args) {
		A151_FindMinimumDiffBetweenAny2Elts obj = new A151_FindMinimumDiffBetweenAny2Elts();
		int arr[] = {1, 5, 3, 19, 18, 25};
		System.out.println("Minimum difference is "+obj.findMinDiff(arr));
	}	
}
