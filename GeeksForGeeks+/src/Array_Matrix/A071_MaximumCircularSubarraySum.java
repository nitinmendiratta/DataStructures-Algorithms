package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 * Time Complexity: O(n)
 * Note that the above algorithm doesn’t work if all numbers are negative e.g., {-1, -2, -3}. It returns 0 in this case. 
 * This case can be handled by adding a pre-check to see if all the numbers are negative before running the above algorithm.
 */
public class A071_MaximumCircularSubarraySum {

	public int maxSum(int[] arr){
		int n = arr.length,max_wrap  =  0, i = 0;
		// Case 1: get the maximum sum using standard kadane's algorithm
		int max_kadane = kadane(arr);

		// Case 2: Now find the maximum sum that includes corner elements.
		for(i=0; i<n; i++){
			max_wrap += arr[i]; // Calculate array-sum
			arr[i] = -arr[i];  // invert the array (change sign)
		}

		// max sum with corner elements will be: array-sum - (-max subarray sum of inverted array)
		//through kadane(arr) we are trying to claculate the max -ve sum, and adding gives us the left sum from the whole array
		max_wrap = max_wrap + kadane(arr);
		// The maximum circular sum will be maximum of two sums
		return (max_wrap > max_kadane)? max_wrap: max_kadane;
	}

	public int kadane(int[] arr){

		int startIndx = 0, endIndx = 0, maxSum = 0, currentSum = 0, maxstartIndx = 0, maxendIndx = 0;
		for(int i = 0;i < arr.length; i++){
			currentSum += arr[i];
			if(currentSum < 0){
				startIndx = i+1;
				endIndx = i+1;
				currentSum = 0;
			}
			if(currentSum > maxSum){
				maxSum = currentSum;
				endIndx = i;
				maxendIndx = i;
				maxstartIndx = startIndx;
			}
			
		}
		return maxSum;
	}

	public static void main(String[] args) {
		A071_MaximumCircularSubarraySum obj = new A071_MaximumCircularSubarraySum();
		int[] arr = {11, 10, -20, 5, -3, -5, 8, -13, 10};
		System.out.println("Max sum:"+obj.maxSum(arr));
	}
}
