package Medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
 */
public class M_0300_LongestIncreasingSubsequence {

	/******************************* Using Binary Search *********************************/
	// https://www.youtube.com/watch?v=1RpMc3fv0y4
	public int lengthOfLIS(int[] nums) {
		int increasingSub[] = new int[nums.length + 1]; // Tracking ends of each increasing subsequence.
		int length = 0; // Length of longest subsequence.

		for (int i = 0; i < nums.length; i++) {
			// Binary search
			int low = ceilIndex(nums, increasingSub, length, i);
			// Replace or append
			increasingSub[low] = i;

			// Update the length of the longest subsequence.
			if (low > length)
				length = low;
		}
		return length;
	}

	/**
	 * Returns index in increasingSub for ceiling of curr elt
	 */
	private int ceilIndex(int nums[], int increasingSub[], int end, int currIdx) {
		int low = 1;
		int high = end;
		while (low <= high) {
			int mid = (int) Math.ceil((low + high) / 2);

			if (nums[increasingSub[mid]] < nums[currIdx])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	/******************************* Print LIS Using Binary Search *********************************/
	// same logic as above but this prints the sequence too
	public int printLIS(int[] nums) {
		int parent[] = new int[nums.length]; // Tracking the predecessors/parents of elements of each subsequence.
		int increasingSub[] = new int[nums.length + 1]; // Tracking ends of each increasing subsequence.
		int length = 0; // Length of longest subsequence.

		for (int i = 0; i < nums.length; i++) {
			// Binary search

			int low = ceilIndex(nums, increasingSub, length, i);
			int pos = low;
			// update parent/previous element for LIS
			parent[i] = increasingSub[pos - 1];
			// Replace or append
			increasingSub[pos] = i;

			// Update the length of the longest subsequence.
			if (pos > length)
				length = pos;
		}

		// Generate LIS by traversing parent array
		int LIS[] = new int[length];
		int k = increasingSub[length];
		for (int j = length - 1; j >= 0; j--) {
			LIS[j] = nums[k];
			k = parent[k];
		}

		for (int i = 0; i < length; i++) {
			System.out.print(LIS[i] + ",");
		}
		System.out.println();
		return length;
	}

	/******************************* DP Approach *********************************/
	// https://www.youtube.com/watch?v=CE2b_-XfVDk
	// O(n2)
	public int lengthOfLISApproach2(int[] nums) {
		int max = 1;
		int[] cache = new int[nums.length];

		/* Initialize LIS values for all indexes */
		for (int i = 0; i < nums.length; i++)
			cache[i] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					cache[i] = Math.max(cache[i], cache[j] + 1);
				}
			}
			max = Math.max(max, cache[i]);
		}
		return max;
	}

	/******************************* Print LIS Using DP Approach *********************************/
	public int printLISApproach2(int[] nums) {
		if(nums.length == 0 || nums.length == 1) return nums.length;
		
		int parent[] = new int[nums.length]; // Tracking the predecessors/parents of elements of each subsequence.
		int cache[] = new int[nums.length + 1]; // Tracking ends of each increasing subsequence.
		int maxLength = 0, maxIdx = -1; // Length of longest subsequence.

		//* Initialize LIS values for all indexes */
		Arrays.fill(cache, 1);
		Arrays.fill(parent, -1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && cache[i] < cache[j] + 1) {
					cache[i] = cache[j] + 1;
					parent[i] = j;				
				}
			}
			if (cache[i] > maxLength) {
				maxLength = cache[i];
				maxIdx = i;
			}
		}

		// Generate LIS by traversing parent array
		int LIS[] = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			LIS[i] = nums[maxIdx];
			maxIdx = parent[maxIdx];
		}

		for (int i = 0; i < maxLength; i++) {
			System.out.print(LIS[i] + ",");
		}
		return maxLength;
	}

	public static void main(String[] args) {
		M_0300_LongestIncreasingSubsequence obj = new M_0300_LongestIncreasingSubsequence();
		System.out.println(obj.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		obj.printLIS(new int[] { 10, 9, 2, 5, 3, 7, 18 });
		System.out.println(obj.lengthOfLISApproach2(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		obj.printLISApproach2(new int[] { 10, 9, 2, 5, 3, 7, 18 });
	}

}
