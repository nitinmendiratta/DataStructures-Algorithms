package Medium;

/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class M_0153_FindMinimumRotatedSortedArray {

	// https://www.ideserve.co.in/learn/find-an-element-in-a-sorted-rotated-array
	/*
	 * 	Algorithm for finding index of pivot element:
	    1. If array[0] <= array[length of array - 1], it means the array is not rotated, so return 0.
	    2. Initialize start = 0, end = length of array - 1.
	    3. Repeat following steps till start <= end
	       a). Set mid = (start+end)/2.
	       b). If mid+1 is pivot, then break.
	       c). If array[start] <= array[mid], it means from start to mid, all elements are in sorted order. Set start = mid+1, so that we look for pivot in second half of the array.
	       d). Else set end = mid-1, to look for pivot in first half.
	 */
	public int findMin(int[] nums) {
		int len = nums.length, start = 0, end = len - 1, mid = 0;
		
		if (len == 1 || nums[0] < nums[len - 1]) {
            return nums[0];
        }
		while (start <= end) {
			mid = start + (end - start) / 2;

            // check if mid+1 is pivot
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

		}
		return nums[0];
	}

	public static void main(String[] args) {
		M_0153_FindMinimumRotatedSortedArray obj = new M_0153_FindMinimumRotatedSortedArray();
		//System.out.println(obj.findMin(new int[] {5,3}));
		System.out.println(obj.findMin(new int[] {4,5,1,2,3}));
	}
}
