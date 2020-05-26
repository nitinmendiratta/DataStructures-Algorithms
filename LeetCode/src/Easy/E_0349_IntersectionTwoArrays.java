package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class E_0349_IntersectionTwoArrays {

	public int[] set_intersection(HashSet<Integer> smallSet, HashSet<Integer> bigSet) {
		int [] output = new int[smallSet.size()];
		int idx = 0;
		for (Integer s : smallSet)
			if (bigSet.contains(s)) output[idx++] = s;

		return Arrays.copyOf(output, idx);
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1) set1.add(n);
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums2) set2.add(n);

		if (set1.size() < set2.size()) return set_intersection(set1, set2);
		else return set_intersection(set2, set1);
	}

	public int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}
		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	public boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		E_0349_IntersectionTwoArrays obj = new E_0349_IntersectionTwoArrays();
		int[] nums1 = new int[]{1,2,2,1};
		int[] nums2 = new int[] {2,2};
		System.out.println(Arrays.toString(obj.intersection(nums1, nums2)));
		System.out.println(Arrays.toString(obj.intersectionUsingBinarySearch(nums1, nums2)));
	}
}
