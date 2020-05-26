package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/majority-element-ii/
 */
public class M_0229_MajorityElement2 {

	public List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}

	public static void main(String[] args) {
		M_0229_MajorityElement2 obj = new M_0229_MajorityElement2();
		System.out.println(obj.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(obj.majorityElement(new int[] { 1, 1, 2, 3, 3, 2, 2, 2 }));
		System.out.println(obj.majorityElement(new int[] { 8, 9, 8, 9, 8 }));
	}
}
