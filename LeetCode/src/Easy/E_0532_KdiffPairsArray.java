package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class E_0532_KdiffPairsArray {

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)   return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				//count how many elements in the array that appear more than twice.
				if (entry.getValue() >= 2) {
					count++;
				} 
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}
	
	// using sort and 2 pointers
	public int findPairsApproach2(int[] nums, int k) {
		if (k < 0) return 0;
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0, j = 1; j < nums.length;) {
			if (j <= i || nums[i] + k > nums[j]) {
				j++;
			} else if (i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]) {
				i++;
			} else {
				ans++;
				i++;
			}
		}
		return ans;
	}
	
	// using sort and binary search
	public int findPairsApproach3(int[] nums, int k) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (search(nums, i + 1, nums[i] + k)) res++;
        }
        return res;
    }
    private boolean search(int[] nums, int l, int target) {
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
	public static void main(String[] args) {
		E_0532_KdiffPairsArray obj = new E_0532_KdiffPairsArray();
		int[] arr = {3, 1, 4, 1, 5};
		System.out.println(obj.findPairs(arr, 2));
		System.out.println(obj.findPairsApproach2(arr, 2));
		System.out.println(obj.findPairsApproach3(arr, 2));
	}
}
