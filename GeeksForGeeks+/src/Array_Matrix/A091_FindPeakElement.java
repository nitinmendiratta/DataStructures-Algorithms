package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * 1. Use DnC to find a peak in O(Logn) time. The idea is Binary Search based, we compare middle element with its neighbors. 
 * 2. If middle element is not smaller than any of its neighbors, then we return it.
 * 3. If the middle element is smaller than the its left neighbor, then there is always a peak in left half.
 * 4. If the middle element is smaller than the its right neighbor, then there is always a peak in right half 
 */
 
public class A091_FindPeakElement {

	public int peak(int[] arr,int low,int high){
		int n = arr.length;
		// Fin index of middle element
		int mid = low + (high - low)/2;  /* (low + high)/2 */

		// Compare middle element with its neighbours (if neighbours exist)
		if ((mid == 0 || arr[mid-1] <= arr[mid]) &&	(mid == n-1 || arr[mid+1] <= arr[mid]))
			return mid;

		// If middle element is not peak and its left neighbor is greater than it then left half must have a peak element
		else if (mid > 0 && arr[mid-1] > arr[mid])
			return peak(arr, low, (mid -1));

		// If middle element is not peak and its right neighbor is greater than it then right half must have a peak element
		else return peak(arr, (mid + 1), high);
	}

	public static void main(String[] args) {
		A091_FindPeakElement obj = new A091_FindPeakElement();
		int[] arr = {1, 4, 4, 5, 10, 8};
		int result = obj.peak(arr,0,arr.length);
		System.out.println("Peak elem is:"+arr[result]);
	}
}
