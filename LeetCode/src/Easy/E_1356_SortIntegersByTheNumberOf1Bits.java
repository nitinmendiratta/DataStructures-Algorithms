package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class E_1356_SortIntegersByTheNumberOf1Bits {

	public class CustomComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			return Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b);
		}
	}
	public int[] sortByBits(int[] arr) {
		Integer[] arrCopy = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
        	arrCopy[i] = arr[i];
        
        // comparator can be applied on Integer object and not int so creating array copy
		Arrays.sort(arrCopy, new CustomComparator());
		
		for (int i = 0; i < arr.length; ++i)
            arr[i] = arrCopy[i];
		return arr;
	}
	public static void main(String[] args) {
		E_1356_SortIntegersByTheNumberOf1Bits obj = new E_1356_SortIntegersByTheNumberOf1Bits();
		System.out.println(Arrays.toString(obj.sortByBits(new int[] {0,1,2,3,4,5,6,7,8})));
	}
}
