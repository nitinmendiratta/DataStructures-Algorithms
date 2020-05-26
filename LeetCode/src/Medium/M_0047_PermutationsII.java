package Medium;
import java.util.*;
import java.util.Map.Entry;
/*
 * https://leetcode.com/problems/permutations-ii/
 */
public class M_0047_PermutationsII {

	// https://www.youtube.com/watch?time_continue=5&v=nYFd7VHKyWQ&feature=emb_logo
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/StringPermutation.java
	public List<List<Integer>> permuteUnique(int nums[]) {
		Map<Integer, Integer> countMap = new TreeMap<>();

		for(int i = 0; i < nums.length; i++) {
			countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
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

		permuteUtil(uniqueInput, count, new ArrayList<>(), resultList, nums);
		return resultList;
	}

	public void permuteUtil(int uniqueInput[], int count[], List<Integer> tempList, List<List<Integer>> resultList, int nums[]) {
		if(tempList.size() == nums.length){
			resultList.add(new ArrayList<>(tempList));
			return;
		}

		for(int i = 0; i < uniqueInput.length; i++) {
			if(count[i] == 0) continue;

			tempList.add(uniqueInput[i]);
			count[i]--;
			permuteUtil(uniqueInput, count, tempList, resultList, nums);
			count[i]++;
			tempList.remove(tempList.size() - 1);
		}
	}

	// Approach2
	public List<List<Integer>> permuteUniqueApproach2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
			return;
		}

		for(int i = 0; i < nums.length; i++){
			if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
			used[i] = true; 	      
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, used);
			used[i] = false; 
			tempList.remove(tempList.size() - 1);
		}
	}

	// Iterative Approach
	public List<List<Integer>> permuteUniqueIterative(int[] nums) {
		LinkedList<List<Integer>> resultList = new LinkedList<List<Integer>>();
		resultList.add(new ArrayList<Integer>());
		
		for (int i = 0; i < nums.length; i++) {
			
			int n = resultList.size();
			for (int j = 0; j < n; j++) {
				
				List<Integer> list = resultList.poll();
				for (int k = 0; k <= list.size(); k++) {
					
					if (k > 0 && list.get(k - 1) == nums[i]) break;
					
					ArrayList<Integer> temp = new ArrayList<>(list);
					temp.add(k, nums[i]);
					resultList.offer(temp);
				}
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		M_0047_PermutationsII obj = new M_0047_PermutationsII();
		List<List<Integer>> res = obj.permuteUnique(new int[] {1,1,4});

		for(List<Integer> temp : res) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
	}
}
