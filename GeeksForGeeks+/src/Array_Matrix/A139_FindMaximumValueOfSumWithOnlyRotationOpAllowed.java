package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 * 1) Compute sum of all array elements. Let this sum be 'arrSum'.
 * 2) Compute R0 by doing i*arr[i] for given array. Let this value be currVal.
 * 3) Initialize result: maxVal = currVal // maxVal is result.
 * // This loop computes Rj from  Rj-1
 * 4) Do following for j = 1 to n-1
		......a) currVal = currVal + arrSum-n*arr[n-j];
		......b) If (currVal > maxVal)
            		maxVal = currVal   

 * 5) Return maxVal
 */
public class A139_FindMaximumValueOfSumWithOnlyRotationOpAllowed {

	// Returns max possible value of i*arr[i]
	public int maxSum(int arr[]){
		int n = arr.length;
	    // Find array sum and i*arr[i] with no rotation
	    int arrSum = 0;  // Stores sum of arr[i]
	    int currVal = 0;  // Stores sum of i*arr[i]
	    for (int i=0; i<n; i++){
	        arrSum = arrSum + arr[i];
	        currVal = currVal+(i*arr[i]);
	    }
	 
	    // Initialize result as 0 rotation sum
	    int maxVal = currVal;
	 
	    // Try all rotations one by one and find
	    // the maximum rotation sum.
	    for (int j=1; j<n; j++){
	        currVal = currVal + arrSum-n*arr[n-j];
	        if (currVal > maxVal)
	            maxVal = currVal;
	    }
	 
	    // Return result
	    return maxVal;
	}
	
	public static void main(String[] args) {
		A139_FindMaximumValueOfSumWithOnlyRotationOpAllowed obj = new A139_FindMaximumValueOfSumWithOnlyRotationOpAllowed();
		int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	    System.out.println("\nMax sum is: "+obj.maxSum(arr));
	}

}
