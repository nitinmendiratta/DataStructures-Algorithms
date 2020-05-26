package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 * O(Logn) using Binary Search
 */
public class A096_FindMinimumElementInSortedAndRotatedArray {

	public int findMin(int[] arr, int low, int high){
		int n = arr.length;
		// This condition is needed to handle the case when array is not rotated at all
		if (high < low)  return arr[0];
		// If there is only one element left
		if (high == low) return arr[low];
		// Find mid
		int mid = low + (high - low)/2; /*(low + high)/2;*/

		// Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
		if (mid < high && arr[mid+1] < arr[mid])
			return arr[mid+1];
			
		// This case causes O(n) time
    	/*if (arr[low] == arr[mid] && arr[high] == arr[mid])
        	return min(findMin(arr, low, mid-1), findMin(arr, mid+1, high));
         */
		// Check if mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];
		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid-1);
		return findMin(arr, mid+1, high);
	}

	public static void main(String[] args) {
		A096_FindMinimumElementInSortedAndRotatedArray obj = new A096_FindMinimumElementInSortedAndRotatedArray();
		int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
		int result = obj.findMin(arr,0,arr.length-1);
		System.out.println("Min is:"+result);
	}
}
