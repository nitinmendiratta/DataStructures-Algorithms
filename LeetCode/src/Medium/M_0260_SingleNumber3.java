package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/single-number-iii/
 * https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 */
public class M_0260_SingleNumber3 {

	/*
	 * Let us see an example.
		   arr[] = {2, 4, 7, 9, 2, 4}
		1) Get the XOR of all the elements.
		     xor = 2^4^7^9^2^4 = 14 (1110)
		2) Get a number which has only one set bit of the xor.   
		   Since we can easily get the rightmost set bit, let us use it.
		     set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
		   Now set_bit_no will have only set as rightmost set bit of xor.
		3) Now divide the elements in two sets and do xor of         
		   elements in each set and we get the non-repeating 
		   elements 7 and 9. Please see the implementation for this step.
	 */
	public int[] singleNumber(int[] nums) {
		int Xor = nums[0]; /* Will hold Xor of all elements */
		int set_bit_no; /* Will have only single set bit of Xor */
		int i, x = 0, y = 0;

		/* Get the Xor of all elements */
		for (i = 1; i < nums.length; i++)
			Xor ^= nums[i];

		/* Get the rightmost set bit in set_bit_no */
		set_bit_no = Xor & ~(Xor - 1);

		/*
		 * Now divide elements in two sets by comparing rightmost set bit of Xor with
		 * bit at same position in each element.
		 */
		for (i = 0; i < nums.length; i++) {
			if ((nums[i] & set_bit_no) == 0)
				x = x ^ nums[i]; /* Xor of first set: elements with set_bit_no not set */
			else
				y = y ^ nums[i]; /* Xor of second set */
		}
		return new int[] { x, y };
	}

	public static void main(String[] args) {
		M_0260_SingleNumber3 obj = new M_0260_SingleNumber3();
		System.out.println(Arrays.toString(obj.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));
	}
}
