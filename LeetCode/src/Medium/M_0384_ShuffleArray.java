package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class M_0384_ShuffleArray {

	private int[] array;
	private int[] original;

	Random rand = new Random();

	private int randRange(int min, int max) {
		return rand.nextInt(max - min) + min;
	}

	private void swapAt(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public M_0384_ShuffleArray(int[] nums) {
		array = nums;
		original = nums.clone();
	}

	public int[] reset() {
		array = original;
		/*
		 * This is to make sure the changes in "array" does not change the "original" as
		 * when we write array = original, we make both array and original to an array
		 * of integers present in the same memory location.
		 * 
		 * hence original = original.clone(); will make original point to new array
		 * integers which is a clone of values pointed by original previously. Think of
		 * this as a deep copy.
		 */
		original = original.clone();
		return original;
	}

	public int[] shuffle() {
		for (int i = 0; i < array.length; i++) {
			swapAt(i, randRange(i, array.length));
		}
		return array;
	}

	public static void main(String[] args) {
		M_0384_ShuffleArray obj = new M_0384_ShuffleArray(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(obj.reset()));
		System.out.println(Arrays.toString(obj.shuffle()));

	}

}
