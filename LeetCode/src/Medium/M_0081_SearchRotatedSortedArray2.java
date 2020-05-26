package Medium;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class M_0081_SearchRotatedSortedArray2 {

	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {

			while (start < end && nums[start] == nums[start + 1])
				start++; // skip duplicates from the left
			while (end > start && nums[end] == nums[end - 1])
				end--; // skip duplicates from the right

			int mid = start + (end - start) / 2;

			if (target == nums[mid])
				return true;

			// there exists rotation; the middle element is in the left part of the PIVOT
			if (nums[mid] > nums[end]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}
			// there exists rotation; the middle element is in the right part of the PIVOT
			else if (nums[mid] < nums[start]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
			// there is no rotation; just like normal binary search
			else {
				if (target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return false;
	}

	// Approach2
	public boolean searchApproach2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return true;
			}
			if (nums[left] < nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] == nums[mid]) {
				left++;
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		M_0081_SearchRotatedSortedArray2 obj = new M_0081_SearchRotatedSortedArray2();
		// System.out.println(obj.search(new int[] {2,5,6,0,0,1,2}, 0));
		System.out.println(obj.search(new int[] { 1, 3, 1, 1, 1 }, 3));
	}
}
