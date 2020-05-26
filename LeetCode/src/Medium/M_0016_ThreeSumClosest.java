package Medium;
import java.util.Arrays;
// https://leetcode.com/problems/3sum-closest/
// http://buttercola.blogspot.com/2014/07/leetcode-3sum-closest.html
public class M_0016_ThreeSumClosest {

	// O(n2)
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0, diff = Integer.MAX_VALUE;

		for(int i = 0; i < nums.length-2; i++) {
			int start = i+1, 
			end = nums.length-1, 
			newTarget = target - nums[i], 
			currentSum = 0;

			while(start < end) {
				currentSum = nums[start] + nums[end];

				if(currentSum == newTarget) {
					return target;
				}else if(currentSum > newTarget) {
					end--;
				}else {
					start++;
				}
				int newDiff = newTarget - currentSum;
				if(Math.abs(newDiff) < Math.abs(diff)) {
					diff = newDiff;
					res = currentSum + nums[i];
				}
			}
		}
		return res;
	}

	// similar approach but copied code
	public int threeSumClosestSameApproach(int[] nums, int target) {
		int ans = nums[0] + nums[1] + nums[2];

		// Sort the array
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int newTarget = target - nums[i];

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				// save the current result
				int diff = Math.abs(nums[i] + nums[start] + nums[end] - target);

				if (diff < Math.abs(ans - target)) {
					ans = nums[i] + nums[start] + nums[end];
				}

				if (nums[start] + nums[end] == newTarget) {
					return target;
				} else if (nums[start] + nums[end] < newTarget) {
					start++;
				} else {
					end--;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		M_0016_ThreeSumClosest obj = new M_0016_ThreeSumClosest();
		int[] num = {1,2,5,10,11};
		System.out.println(obj.threeSumClosest(num, 12));
	}
}
