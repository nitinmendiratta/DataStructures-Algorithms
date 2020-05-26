package Medium;

/*
 * A064: http://www.geeksforgeeks.org/maximum-product-subarray/
 * http://leetcodesolution.blogspot.com/2014/09/leetcode-maximum-product-subarray.html
 * M_152: https://leetcode.com/problems/maximum-product-subarray/
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class M_0152_MaximumProductSubarray {

	// best sol
	public int getMaxProductSubarray(int[] nums) {
		// store the result that is the max we have found so far
		int res = nums[0];

		// imax/imin stores the max/min product of
		// subarray that ends with the current number nums[i]
		for (int i = 1, imax = res, imin = res; i < nums.length; i++) {
			// multiplied by a negative makes big number smaller, small number bigger
			// so we redefine the extremums by swapping them
			if (nums[i] < 0) {
				// swap(imax, imin)
				int temp = imax;
				imax = imin;
				imin = temp;
			}

			// max/min product for the current number is either the current number itself
			// or the max/min by the previous number times the current one
			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);

			// the newly computed max value is a candidate for our global result
			res = Math.max(res, imax);
		}
		return res;
	}

	public static void main(String[] args) {
		M_0152_MaximumProductSubarray obj = new M_0152_MaximumProductSubarray();
		int[] arr = { 1, -2, -3, 0, 7, -8, -2 };
		int result = obj.getMaxProductSubarray(arr);
		System.out.print("Max product is:" + result);
	}
}
