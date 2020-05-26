package Medium;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class M_0215_KthLargestElementInArray {

	// O(N lg K) running time + O(K) memory
	public int findKthLargest(int[] nums, int k) {

		final PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : nums) {
			pq.offer(val);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	// https://www.youtube.com/watch?v=hGK_5n81drs
	// https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/KthLargestElement/KthLargestElement.java
	public int findKthLargestApproach2(int[] nums, int k) {
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
		M_0215_KthLargestElementInArray obj = new M_0215_KthLargestElementInArray();
		System.out.println(obj.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	}
}
