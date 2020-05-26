package Medium;

/*
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class M_0376_WiggleSubsequence {

	// read leetcode solution
	// Greedy O(n)
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int prevdiff = nums[1] - nums[0];
		int count = prevdiff != 0 ? 2 : 1;
		for (int i = 2; i < nums.length; i++) {
			int diff = nums[i] - nums[i - 1];
			if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
				count++;
				prevdiff = diff;
			}
		}
		return count;
	}

	// O(n)
	public int wiggleMaxLengthApproach2(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int down = 1, up = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				up = down + 1;
			else if (nums[i] < nums[i - 1])
				down = up + 1;
		}
		return Math.max(down, up);
	}

	/*
	 * Time complexity : O(n^2). Loop inside a loop. Space complexity :O(n). Two
	 * arrays of the same length are used for dp
	 */
	public int wiggleMaxLengthApproach3(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					up[i] = Math.max(up[i], down[j] + 1);
				} else if (nums[i] < nums[j]) {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
		}
		return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
	}

	public static void main(String[] args) {
		M_0376_WiggleSubsequence obj = new M_0376_WiggleSubsequence();
		System.out.println(obj.wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
	}
}
