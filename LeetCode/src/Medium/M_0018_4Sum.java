package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/4sum/
 */
public class M_0018_4Sum {


	public List<List<Integer>> fourSum(int[] nums, int target) {
		// define return value
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length < 4) return ans;
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			/*Ignored when the value of k is equal to the previous value*/
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			/* Get the current minimum value. If the minimum value is greater than the target value, it means that the larger and larger values ​​later are not good.*/
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				break;
			/* Get the current maximum value. If the maximum value is smaller than the target value, it means that the smaller and smaller values ​​later will not work at all. Ignore */            
			if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
				continue;
			for (int j = i + 1; j < len - 2; j++) {
				/* Ignore when the value of j is equal to the previous value */
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int l = j + 1, r = len - 1;
				/* Get the current minimum value. If the minimum value is greater than the target value, it means that the later increasing value is not good. Ignore */                
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
					break;
				/* Get the current maximum value. If the maximum value is smaller than the target value, it means that the smaller and smaller values ​​later will not work at all. Ignore */                
				if (nums[i] + nums[j] + nums[r - 1] + nums[r] < target)
					continue;
				while (l < r) {
					int curr = nums[i] + nums[j] + nums[l] + nums[r];
					if (target == curr) {
						ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						/* Duplicate */                        
						l++;
						while (l < r && nums[l] == nums[l - 1]) l++;
						r--;
						while (r > l && nums[r] == nums[r + 1]) r--;
					} else if (target > curr) {
						l++;
					} else
						r--;
				}
			}
		}
		return ans;
	}

	// my working code
	public List<List<Integer>> fourSum2(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if(len < 4) return res;
		Arrays.sort(nums);

		for(int i = 0; i < len-3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])	continue;

			for(int j = i+1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;

				int start = j+1;
				int end = len-1;

				while(start < end) {
					int currentSum = nums[start] + nums[end];
					if(currentSum == target-nums[j]-nums[i]) {
						res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

						while(start < end && nums[start] == nums[start+1]) start++;
						while(start < end && nums[end] == nums[end-1]) end--;
						start++;
						end--;
					}
					else if(currentSum > target-nums[j]-nums[i]) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M_0018_4Sum obj = new M_0018_4Sum();
		//int[] nums = {1, 0, -1, 0, -2, 2};
		int[] nums = {0, 0, 0, 0, 0, 0};
		List<List<Integer>> result = obj.fourSum(nums, 0);
		for(int i = 0; i < result.size(); i++) {
			List<Integer> res = result.get(i);
			System.out.println(res);
		}
	}
}
