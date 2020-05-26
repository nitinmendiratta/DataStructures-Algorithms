package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/combination-sum/
 */
public class M_0039_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		combinationSumHelper(candidates, target, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public void combinationSumHelper(int[] candidates, int target, List<List<Integer>> res, List<Integer> tempList, int start) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(tempList));
			return;
		}else if(target < 0) return;

		for(int i = start; i < candidates.length && candidates[i] <= target; i++) {
			tempList.add(candidates[i]);
			combinationSumHelper(candidates, target - candidates[i], res, tempList, i); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size()-1);
		}

	}

	// Approach 2: DP
	public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
		Arrays.sort(candidates); // sort candidates to try them in asc order
		List<List<List<Integer>>> dp = new ArrayList<>();
		
		for (int i = 1; i <= target; i++) { // run through all targets from 1 to t
			List<List<Integer>> newList = new ArrayList(); // combs for curr i
			
			// run through all candidates <= i
			for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
				// special case when curr target is equal to curr candidate
				
				if (i == candidates[j]) {
					newList.add(Arrays.asList(candidates[j]));
				}
				// if current candidate is less than the target use prev results
				else {
					for (List<Integer> l : dp.get(i-candidates[j]-1)) {
						if (candidates[j] <= l.get(0)) {
							List<Integer> cl = new ArrayList<Integer>();
							cl.add(candidates[j]); cl.addAll(l);
							newList.add(cl);
						}
					}
				}
			}
			dp.add(newList);
		}
		return dp.get(target - 1);
	}
	public static void main(String[] args) {
		M_0039_CombinationSum obj = new M_0039_CombinationSum();
		List<List<Integer>> res = obj.combinationSum(new int[] {2,3,6,7}, 7);
		for(List<Integer> temp : res) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
	}
}
