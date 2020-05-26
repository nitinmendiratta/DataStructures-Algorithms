package Medium;

/*
 * https://leetcode.com/problems/find-peak-element/
 */
public class M_0162_FindPeakElement {

	/* https://www.youtube.com/watch?v=a7D77DdhlFc
	 * Solution:
		1: Initialize start = 0, end = array.length - 1
		2: Repeat following steps till peak element is found:
		   (a) Find mid = start + (end - start) / 2
		   (b) If mid is peak element, return array[mid]
		   (c) If array[mid-1] is greater than array[mid], find peak in left half of array  set end = mid - 1
		   (d) Else find peak in right half of array  set start = mid + 1

		Time Complexity: O(log n)
		Space Complexity: O(1)
	*/
	public int findPeakElement(int[] nums) {
		int len = nums.length, start = 0, end = len - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == len - 1 || nums[mid] > nums[mid + 1])) {
				// case 1: we are at start and next elt is < curr elt
				// case 2: we are at end prev elt is < curr elt
				return mid;
			} else if (mid > 0 && nums[mid - 1] > nums[mid]) {
				end = mid - 1; // prev elt is greater then curr elt we have peak on left
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		M_0162_FindPeakElement obj = new M_0162_FindPeakElement();
		System.out.println(obj.findPeakElement(new int[] { 1, 2, 3 }));
		System.out.println(obj.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}
}
