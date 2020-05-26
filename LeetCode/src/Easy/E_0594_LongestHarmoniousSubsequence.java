package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class E_0594_LongestHarmoniousSubsequence {

	/*
	 * Time complexity : O(n) 
	 * Space complexity : O(n)
	 */
	public int findLHS(int[] nums) {
		HashMap < Integer, Integer > map = new HashMap < > ();
		int res = 0;
		for (int num: nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.containsKey(num + 1))
				res = Math.max(res, map.get(num) + map.get(num + 1));
			if (map.containsKey(num - 1))
				res = Math.max(res, map.get(num) + map.get(num - 1));
		}
		return res;
	}

	/*
	 * Time complexity : O(nlogn). Sorting takes O(nlogn) time.
	 * Space complexity : O(logn). logn space is required by sorting
	 * in average case.
	 */
	// https://www.youtube.com/watch?v=-aS9kIt3IfQ
	public int findLHSApproach2(int[] nums) {
		Arrays.sort(nums);
		int prev_count = 1, res = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			if (i > 0 && nums[i] - nums[i - 1] == 1) {
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					count++;
					i++;
				}
				res = Math.max(res, count + prev_count);
				prev_count = count;
			} else {
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					count++;
					i++;
				}
				prev_count = count;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_0594_LongestHarmoniousSubsequence obj = new E_0594_LongestHarmoniousSubsequence();
		int[] nums = {2,3,3,2,4};
		System.out.println(obj.findLHS(nums));
	}
}
