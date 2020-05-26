package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/
 * O(n)
 */
public class A138_FindMaximumAverageSubarrayOfkLength {

	// Returns beginning index of maximum average subarray of length 'k'
	public int findMaxAverage(int arr[], int k) {
		int n = arr.length;
	    // Check if 'k' is valid
	    if (k > n)
	        return -1;
	 
	    // Compute sum of first 'k' elements
	    int sum = arr[0];
	    for (int i=1; i<k; i++)
	        sum += arr[i];
	 
	    int max_sum = sum, max_end = k-1;
	 
	    // Compute sum of remaining subarrays
	    for (int i=k; i<n; i++){
	        sum = sum + arr[i] - arr[i-k];
	        if (sum > max_sum){
	            max_sum = sum;
	            max_end = i;
	        }
	    }
	 
	    // Return starting index
	    return max_end - k + 1;
	}
	public static void main(String[] args) {
		A138_FindMaximumAverageSubarrayOfkLength obj = new A138_FindMaximumAverageSubarrayOfkLength();
		int arr[] = {1, 12, -5, -6, 50, 3};
	    int k = 4;
	    System.out.println("The maximum average subarray of length:"+k+" begins at index:"+obj.findMaxAverage(arr, k));
	}
}
