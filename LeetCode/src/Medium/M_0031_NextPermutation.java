package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/next-permutation/
 */
public class M_0031_NextPermutation {

	/*
	 * here is an example: 2,3,6,5,4,1
	 * 
	 * Solution: Step1, from right to left, find the first number which not increase
	 * in a ascending order. In this case which is 3.
	 *  
	 * Step2, here we can have two situations:
	 * 
	 * We cannot find the number, all the numbers increasing in a ascending order.
	 * This means this permutation is the last permutation, we need to rotate back
	 * to the first permutation. So we reverse the whole array, for example,
	 * 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.
	 * 
	 * We can find the number, then the next step, we will start from right most to
	 * leftward, try to find the first number which is larger than 3, in this case
	 * it is 4. Then we swap 3 and 4, the list turn to 2,4,6,5,3,1. 
	 * 
	 * Step 3:
	 * Last, we reverse
	 * numbers on the right of 4, we finally get 2,4,1,3,5,6.
	 * 
	 * Time complexity is: O(3*n)=O(n).
	 */
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		// find first non decreasing elt
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		M_0031_NextPermutation obj = new M_0031_NextPermutation();
		int[] nums = new int[] {1,1};
		obj.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
