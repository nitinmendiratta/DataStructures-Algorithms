package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/permutations/
 */
public class M_0046_Permutations {

	// O(n!)
	// backtracking optimized as list.contains can take o(n) time for large lists so using a boolean array
	public List<List<Integer>> permute(int[] nums) {

		if (nums == null || nums.length == 0)
			return new ArrayList<>();

		List<List<Integer>> finalResult = new ArrayList<>();
		permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
		return finalResult;
	}

	private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

		if (currResult.size() == nums.length) {
			finalResult.add(new ArrayList<>(currResult));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			currResult.add(nums[i]);
			used[i] = true;
			permuteRecur(nums, finalResult, currResult, used);
			used[i] = false;
			currResult.remove(currResult.size() - 1);
		}
	}
	
	// O(n*n!)
	// backtracking
	public List<List<Integer>> permuteBacktrack(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = 0; i < nums.length; i++){ 
				if(tempList.contains(nums[i])) continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	// Iterative
	public List<List<Integer>> permuteIterative(int[] num) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int n : num) {
			int size = res.size();
			for (; size > 0; size--) {
				// take existing list and insert curr element from num one by one at each index
				List<Integer> r = res.pollFirst();
				for (int i = 0; i <= r.size(); i++) {
					List<Integer> t = new ArrayList<Integer>(r);
					t.add(i, n);
					res.add(t);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		M_0046_Permutations obj = new M_0046_Permutations();
		List<List<Integer>> res = obj.permute(new int[] {1,2,3});

		for(List<Integer> temp : res) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
	}
}
