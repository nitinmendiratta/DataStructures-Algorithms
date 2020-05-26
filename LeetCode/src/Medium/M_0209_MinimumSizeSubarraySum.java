package Medium;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class M_0209_MinimumSizeSubarraySum {

	/*
	 * As to NLogN solution, logN immediately reminds you of binary search. In this
	 * case, you cannot sort as the current order actually matters. How does one get
	 * an ordered array then? Since all elements are positive, the cumulative sum
	 * must be strictly increasing. Then, a subarray sum can expressed as the
	 * difference between two cumulative sum. Hence, given a start index for the
	 * cumulative sum array, the other end index can be searched using binary
	 * search.
	 */
	private int solveNLogN(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];
		
		for (int i = 1; i < sums.length; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		
		int minLen = Integer.MAX_VALUE;
		
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
			
			if (end == sums.length)
				break;
			if (end - i < minLen)
				minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int binarySearch(int lo, int hi, int key, int[] sums) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (sums[mid] >= key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	// Approach2: my approach
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length, curr_sum = 0, minLen = Integer.MAX_VALUE, start = 0, end = 0;

		while (end < len) {
			curr_sum += nums[end]; // new window

			while (curr_sum >= s) {
				minLen = Math.min(minLen, end - start + 1);
				curr_sum -= nums[start];
				start++;
			}
			end++;
		}

		return (minLen != Integer.MAX_VALUE) ? minLen : 0;
	}

	public static void main(String[] args) {
		M_0209_MinimumSizeSubarraySum obj = new M_0209_MinimumSizeSubarraySum();
		System.out.println(obj.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(obj.minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
	}
}
