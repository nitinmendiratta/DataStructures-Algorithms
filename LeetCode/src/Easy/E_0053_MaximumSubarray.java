package Easy;
/**
 * https://leetcode.com/problems/maximum-subarray/
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * 
 * Kadane's Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < a[i])
            max_ending_here = a[i]
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */
public class E_0053_MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for(int i = 0; i < len; i++){
			max_ending_here += nums[i];
			if(max_ending_here < nums[i]){
				max_ending_here = nums[i];
			}
			if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
	public int maxSubArrayWithIndex(int[] nums) {
		int len = nums.length;
		int startIndx = 0, endIndx = 0, maxstartIndx = 0, i;
		int max_so_far, max_ending_here;
		max_so_far = Integer.MIN_VALUE;
		max_ending_here = 0;

		for(i = 0; i < len; i++){
			max_ending_here += nums[i];
			// this condition is true only if max_ending_here is -ve till now and we get a number bigger then current sum
			if(nums[i] > max_ending_here){
				max_ending_here = nums[i]; 
				startIndx = i;
			}
			if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
				endIndx = i;
				maxstartIndx = startIndx;
			}
		}
		for(i = maxstartIndx; i <= endIndx; i++){
			System.out.print(nums[i]+",");
		}
		return max_so_far;
	}
	public static void main(String[] args) {
		E_0053_MaximumSubarray obj = new E_0053_MaximumSubarray();
		int[] arr = new int[] {-1,-2,-3,-4,-5};
		System.out.println(obj.maxSubArray(arr));
	}
}
