package Medium;

import java.util.*;

// https://leetcode.com/problems/largest-number/
public class M_0179_LargestNumber {
	private class LargerNumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			String order1 = a + b;
			String order2 = b + a;
			return order2.compareTo(order1);
		}
	}

	public String largestNumber(int[] nums) {
		// Get input integers as strings.
		String[] asStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}

		// Sort strings according to custom comparator.
		Arrays.sort(asStrs, new LargerNumberComparator());

		// If, after being sorted, the largest number is `0`, the entire number
		// is zero.
		if (asStrs[0].equals("0")) {
			return "0";
		}

		// Build largest number from sorted array.
		StringBuilder result = new StringBuilder();
		for (String numAsStr : asStrs) {
			result.append(numAsStr);
		}

		return result.toString();
	}

	// Approach2
	public String largestNumberApproach2(int[] num) {
		int i = 0;
		// check if we have atleast 1 number other then 0
		for (i = 0; i < num.length; i++) {
			if (num[i] == 0)
				continue;
			else
				break;
		}
		System.out.println(i);
		if (i == num.length)
			return "0";

		List<Integer> arrList = new ArrayList<Integer>();
		for (int index = 0; index < num.length; index++)
			arrList.add(num[index]);

		StringBuilder result = new StringBuilder();

		Collections.sort(arrList, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				String a = x.toString();
				String b = y.toString();
				String ab = a + b;
				String ba = b + a;
				return ba.compareTo(ab);
			}
		});

		for (i = 0; i < arrList.size(); i++)
			result.append(arrList.get(i));

		return result.toString();
	}

	public static void main(String[] args) {
		M_0179_LargestNumber obj = new M_0179_LargestNumber();
		int[] arr1 = new int[] { 0, 0, 0 };
//		int[] arr2 = new int[] { 54, 546, 548, 60 };
//		int[] arr3 = new int[] { 1, 34, 3, 98, 9, 76, 45, 4 };
//		System.out.println("Biggest num is:" + obj.max(arr3));
//		System.out.println("Biggest num is:" + obj.max(arr2));
		System.out.println("Biggest num is:" + obj.largestNumber(arr1));
	}
}
