package Medium;
import java.util.*;
import java.util.Map.Entry;
/*
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class M_0040_CombinationSumII {

	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Map<Integer, Integer> countMap = new TreeMap<>();

		for(int i = 0; i < candidates.length; i++) {
			countMap.put(candidates[i], countMap.getOrDefault(candidates[i], 0)+1);
		}
		int uniqueInput[] = new int[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;
		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			uniqueInput[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		List<List<Integer>> resultList = new ArrayList<>();
		permuteUtil(uniqueInput, count, new ArrayList<>(), resultList, target, 0);
		return resultList;
	}

	public void permuteUtil(int uniqueInput[], int count[], List<Integer> tempList, List<List<Integer>> resultList, int target, int start) {
		if(target == 0) {
			resultList.add(new ArrayList<Integer>(tempList));
			return;
		}else if(target < 0) return;

		for(int i = start; i < uniqueInput.length && uniqueInput[i] <= target; i++) {
			if(count[i] == 0) continue;

			tempList.add(uniqueInput[i]);
			count[i]--;
			permuteUtil(uniqueInput, count, tempList, resultList, target - uniqueInput[i], i);
			count[i]++;
			tempList.remove(tempList.size() - 1);
		}
	}
	
	// Approach 2
	public List<List<Integer>> combinationSum2Approach2(int[] candidates, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(candidates);
	    backtrack(list, new ArrayList<>(), candidates, target, 0);
	    return list;
	    
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{
	        for(int i = start; i < candidates.length && candidates[i] <= remain; i++){
	            if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
	            tempList.add(candidates[i]);
	            backtrack(list, tempList, candidates, remain - candidates[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	} 
	
	public static void main(String[] args) {
		M_0040_CombinationSumII obj = new M_0040_CombinationSumII();
		List<List<Integer>> res = obj.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
		for(List<Integer> temp : res) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
	}
}
