package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/contains-duplicate/
 */
public class E_0217_ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int x: nums) {
			if (set.contains(x)) return true;
			set.add(x);
		}
		return false;
	}
	
	public boolean containsDuplicateApproach2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n: nums) {
            if(n > max) {
                max = n;
            }
            if(n < min) {
                min = n;
            }
        }
        boolean[] exist = new boolean[max - min + 1];
        for(int n: nums) {
            if(exist[n - min]) return true;
            exist[n - min] = true;
        }
        return false;
    }
	public static void main(String[] args) {
		E_0217_ContainsDuplicate obj = new E_0217_ContainsDuplicate();
		int[] arr = new int[]{2,2,1};
		System.out.println(obj.containsDuplicate(arr));
		System.out.println(obj.containsDuplicateApproach2(arr));
	}
}
