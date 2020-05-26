package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/subsets/
 */
public class M_0078_Subsets {

	/*	Difficult approach couldn't understand
	 * Time complexity:O(N×2^N) to generate all subsets and then copy them into output list.
	 * Space complexity: O(2^N) to keep all the subsets, since each of n elements could be present or absent.
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		int n = nums.length;

		for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
			// generate bitmask, from 0..00 to 1..11
			String bitmask = Integer.toBinaryString(i).substring(1);

			// append subset corresponding to that bitmask
			List<Integer> curr = new ArrayList();
			for (int j = 0; j < n; ++j) {
				if (bitmask.charAt(j) == '1') curr.add(nums[j]);
			}
			output.add(curr);
		}
		return output;
	}
	// My approach Backtracking: Recursive
	//	Time complexity:O(N×2^N)
	//	Space complexity: O(2^N)
	public List<List<Integer>> subsetsApproach2(int[] nums) {
		List<List<Integer>> res = new ArrayList();

		res.add(new ArrayList<Integer>());
		subsetsHelper(nums, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> tempList, int start) {

		if(tempList.size() > 0) {
			res.add(new ArrayList<Integer>(tempList));
		}

		for(int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			subsetsHelper(nums, res, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}

	/* Iterative: BFS
	 * Using [1, 2, 3] as an example, the iterative process is like:

		Initially, one empty subset [[]]
		Adding 1 to []: [[], [1]];
		Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
		Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
	 */
	public List<List<Integer>> subsetsApproach3(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int n : nums){
			int size = result.size();
			for(int i=0; i<size; i++){
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(n);
				result.add(subset);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		M_0078_Subsets obj = new M_0078_Subsets();
		List<List<Integer>> res = obj.subsets(new int[] {1,2,3});
		System.out.println(res);
	}
}
