package Medium;
/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class M_0033_SearchRotatedSortedArray {
	/*
	 * The idea is that when rotating the array, there must be one half of the array
	 * that is still in sorted order. For example, 6 7 1 2 3 4 5, the order is
	 * disrupted from the point between 7 and 1. So when doing binary search, we can
	 * make a judgement that which part is ordered and whether the target is in that
	 * range, if yes, continue the search in that half, if not continue in the other
	 * half.
	 *
	 * https://www.youtube.com/watch?v=MIFm82gUM8o&list=PLamzFoFxwoNhR2uFoqm6nr8VgsERgTmYy&index=5&t=0s
	 * Solution:
		1: Initialize start = 0, end = array length - 1 
		2: Repeat following steps till start less than or equal to end:
		   (a) Set mid = (start + end)/2 
		   (b) If num == array[mid], return mid.
		   (c) If array[start…mid] is sorted, i.e. array[start] is less than array[mid]
		        (i) If array[start] is less than or equal to num is less than or equal to array[mid], set end = mid-1
		        (ii) Else set start = mid+1
		   (d) Else If array[mid…end] is sorted, i.e. array[mid] less than or equal to array[end]
		        (i) If array[mid] is less than or equal to num is less than or equal to array[end], set start = mid+1
		        (ii) Else set end = mid-1
		3: If not found, return -1.
	*/
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while (start <= end){
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[start] <= nums[mid]){   // array[start...mid] is sorted
				if (target >= nums[start] && target < nums[mid])   // num lies between array[start...mid]
					end = mid - 1;
				else
					start = mid + 1;
			} 
			 // array[mid...end] is sorted
			else if (nums[mid] <= nums[end]){
				if (target > nums[mid] && target <= nums[end])  // num lies between array[mid...end]
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	// Approach 2
	public int searchApproach2(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target == nums[mid])
				return mid;

			// there exists rotation; the middle element is in the left part of the PIVOT:
			// left part is sorted
			if (nums[mid] > nums[end]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}
			// there exists rotation; the middle element is in the right part of the PIVOT:
			// right part is sorted
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
		return -1;
	}
	
	public static void main(String[] args) {
		M_0033_SearchRotatedSortedArray obj = new M_0033_SearchRotatedSortedArray();
		System.out.println(obj.search(new int[] {5,1,3}, 3));
	}
}
