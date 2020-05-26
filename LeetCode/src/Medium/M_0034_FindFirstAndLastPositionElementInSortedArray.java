package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class M_0034_FindFirstAndLastPositionElementInSortedArray {

	// returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
	public static void main(String[] args) {
		M_0034_FindFirstAndLastPositionElementInSortedArray obj = new M_0034_FindFirstAndLastPositionElementInSortedArray();
		System.out.println(Arrays.toString(obj.searchRange(new int[] {7,7,7,7,7,7}, 7)));
	}
}
