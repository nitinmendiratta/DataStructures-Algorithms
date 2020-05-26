package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class M_0080_RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] nums) {
		int n = nums.length;

		/*
		 * This index will move when we modify the array in-place to include an element
		 * so that it is not repeated more than twice.
		 */
		int slow = 0;

		for (int fast = 0; fast < n; fast++) {
			/*
			 * If the current element is equal to the element at index i+2, then skip the
			 * current element because it is repeated more than twice.
			 */
			if (fast < n - 2 && nums[fast] == nums[fast + 2]) {
				continue;
			}

			nums[slow] = nums[fast];
			slow++;
		}

		return slow;
	}
	public static void main(String[] args) {
		M_0080_RemoveDuplicatesFromSortedArray2 obj = new M_0080_RemoveDuplicatesFromSortedArray2();
		System.out.println(obj.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
	}

}
