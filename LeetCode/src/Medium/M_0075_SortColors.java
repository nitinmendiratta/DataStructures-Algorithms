package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/sort-colors/
 */
public class M_0075_SortColors {

	public void sortColors(int[] nums) {
		int len = nums.length;
		if(len == 0 || len == 1) return;
		
		int i = 0, start = 0, end = len-1;

		while(start < end && i <= end) {

			if(nums[i] == 0) {
				nums[i] = nums[start];
				nums[start] = 0;
				start++;
				i++;
			}else if(nums[i] == 2) {
				nums[i] = nums[end];
				nums[end] = 2;
				end--;
			}else {
				i++;
			}

		}
	}
	public static void main(String[] args) {
		M_0075_SortColors obj = new M_0075_SortColors();
		int[] arr = new int[] {2,0,2,1,1,0};
		obj.sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
}
