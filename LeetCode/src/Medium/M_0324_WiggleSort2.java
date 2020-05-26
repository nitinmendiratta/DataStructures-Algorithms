package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class M_0324_WiggleSort2 {

	// Brute force: O(nlogn)
	public void wiggleSortApproach2(int[] nums) {
	    int n = nums.length, m = (n + 1) >> 1;
	    int[] copy = Arrays.copyOf(nums, n);
	    Arrays.sort(copy);
	    
	    // copy to even positions smaller numbers starting from mid-1 of copyarray
	    for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
	    
	    // copy to odd positions larger numbers starting from end of copyarray until mid
	    for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
	}
	
	// O(n) time and O(1) space solution by combining partition and placement
	// https://leetcode.com/problems/wiggle-sort-ii/discuss/77684/Summary-of-the-various-solutions-to-Wiggle-Sort-for-your-reference
	public void wiggleSort(int[] nums) {
		int n = nums.length, 
				
		// >> (right shift) Takes two numbers, right shifts the bits of the first operand, the second operand decides the number of places to shift.
		// Similarly right shifting (x>>y) is equivalent to dividing x with 2^y.
		m = (n + 1) >> 1; // here it means to get mid of array
		
		int median = findKthLargest(nums, m);

		for (int i = 0, j = 0, k = n - 1; j <= k;) {
			if (nums[A(j, n)] > median) {
				swap(nums, A(i++, n), A(j++, n));
			} else if (nums[A(j, n)] < median) {
				swap(nums, A(j, n), A(k--, n));
			} else {
				j++;
			}
		}
	}

	private int A(int i, int n) {
		return (2 * i + 1) % (n | 1);
	}

	// same M_0215. Kth Largest Element in an Array
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	int quickSelect(int[] nums, int low, int high, int k) {
		int pivot = low;

		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		for (int j = low; j < high; j++) {
			if (nums[j] <= nums[high]) {
				swap(nums, pivot++, j);
			}
		}
		swap(nums, pivot, high);

		// count the nums that are > pivot from high
		int count = high - pivot + 1;
		// pivot is the one!
		if (count == k)
			return nums[pivot];
		// pivot is too small, so it must be on the right
		if (count > k)
			return quickSelect(nums, pivot + 1, high, k);
		// pivot is too big, so it must be on the left
		return quickSelect(nums, low, pivot - 1, k - count);
	}

	public void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		M_0324_WiggleSort2 obj = new M_0324_WiggleSort2();
		int[] arr = new int[] { 1, 5, 1, 1, 6, 4 };
		obj.wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
