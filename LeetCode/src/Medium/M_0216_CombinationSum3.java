package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class M_0216_CombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n < k) return res;
		combinationSumHelper(n, k, res, new ArrayList<Integer>(), 1);
		return res;
	}

	public void combinationSumHelper(int target, int resLength, List<List<Integer>> res, List<Integer> tempList, int start) {
		if(target == 0 && tempList.size() == resLength) {
			res.add(new ArrayList<Integer>(tempList));
			return;
		}else if(target < 0 || tempList.size() > resLength) return;

		for(int i = start; i <= 9; i++) {
			tempList.add(i);
			combinationSumHelper(target - i, resLength, res, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}

	public static void main(String[] args) {
		M_0216_CombinationSum3 obj = new M_0216_CombinationSum3();
		List<List<Integer>> res = obj.combinationSum3(3, 7);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
		
		res = obj.combinationSum3(3, 9);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
