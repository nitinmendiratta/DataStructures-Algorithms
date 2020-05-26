package Array_Matrix;
/* http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
 T(n) = 2T(n/2) + o(n)
 The Kadane�s Algorithm for this problem takes O(n) time.
*/
public class A084_NC_MaximumSubarraySum {

	// Find the maximum possible sum in arr[] auch that arr[m] is part of it
	int maxCrossingSum(int arr[], int l, int m, int h){
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MAX_VALUE;
	    for (int i = m; i >= l; i--){
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++){
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	 
	// Returns sum of maxium sum subarray in aa[l..h]
	int maxSubArraySum(int arr[], int l, int h){
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h));
	}
	// A utility funtion to find maximum of two integers
	int max(int a, int b) { 
		return (a > b)? a : b; 
	}
	 
	// A utility funtion to find maximum of three integers
	int max(int a, int b, int c) { 
		return max(max(a, b), c); 
	}
	
	public static void main(String[] args) {
		A084_NC_MaximumSubarraySum obj = new A084_NC_MaximumSubarraySum();
		int arr[] = {-2, -5, 6, -2, -3, 1, 5, -6};
		int n = arr.length;
	   	System.out.println("Max sum is: "+obj.maxSubArraySum(arr, 0, n-1));
		
	}

}
