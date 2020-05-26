package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
public class E_1389_CreateTargetArray {

	public int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < index.length; i++) {
			list.add(index[i], nums[i]);
		}
		int[] ans = new int[nums.length];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		E_1389_CreateTargetArray obj = new E_1389_CreateTargetArray();
		System.out.println(
				Arrays.toString(obj.createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 })));
	}
}
