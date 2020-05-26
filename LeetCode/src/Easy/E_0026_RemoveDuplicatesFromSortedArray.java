package Easy;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class E_0026_RemoveDuplicatesFromSortedArray {


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
			if (fast < n - 1 && nums[fast] == nums[fast + 1]) {
				continue;
			}

			nums[slow] = nums[fast];
			slow++;
		}

		return slow;
	}

	public int removeDuplicatesApproach2(int[] A) {
		if (A.length < 2)
			return A.length;

		int j = 0;
		int i = 1;

		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		return j + 1;
	}

	public static void main(String[] args) {
		E_0026_RemoveDuplicatesFromSortedArray obj = new E_0026_RemoveDuplicatesFromSortedArray();
		int arr[] = {-999,-999,-998,-998,-997,-997,-996,-996,-995,-995,-994,-994,-993,-993};
		System.out.println("New Length:"+obj.removeDuplicates(arr));
		for(int i = 0;i < arr.length;i++) System.out.print(arr[i]);
	}
}
