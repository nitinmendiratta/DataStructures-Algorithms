package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/summary-ranges/
 */
public class M_0228_SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList();
		int len = nums.length, i = 0, j = 1;
		if (len == 0)
			return res;

		for (; j < len; j++) {

			while (j < len && nums[j] - nums[j - 1] == 1) {
				j++;
			}

			if (i == j - 1) {
				res.add(nums[i] + "");
			} else {
				res.add(nums[i] + "->" + nums[j - 1]);
			}
			i = j;
		}
		// special end case if ending is continuous increasing like 4,5,6
		if (i < len && i == j - 1) {
			res.add(nums[i] + "");
		}
		return res;
	}

	// using bianry search
	public List<String> summaryRangesApproach2(int[] nums) {
		List<String> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		int low = 0, high = nums.length - 1, index = 0;

		while (index < nums.length) {

			while (high > low) {
				int mid = 1 + (high + low) / 2;
				if (mid - index == nums[mid] - nums[index]) {
					low = mid;
				} else {
					high = mid - 1;
				}
			}
			if (index == low)
				ans.add("" + nums[low]);
			else
				ans.add(nums[index] + "->" + nums[low]);
			index = ++low;
			high = nums.length - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		M_0228_SummaryRanges obj = new M_0228_SummaryRanges();
		System.out.println(obj.summaryRanges(new int[] { 0, 1, 2, 4, 5, 6 }));
		System.out.println(obj.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(obj.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
	}
}
