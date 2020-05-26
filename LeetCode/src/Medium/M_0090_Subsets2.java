package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/subsets-ii/
 */
public class M_0090_Subsets2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		list.add(new ArrayList<>());
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length], 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used, int start){
		if(tempList.size() > 0){
			list.add(new ArrayList<>(tempList));
		}

		for(int i = start; i < nums.length; i++){
			// used[i - 1] check is to handle if prev same elmt was already considered then it will be false
			if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
			used[i] = true; 	      
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, used, i+1);
			used[i] = false; 
			tempList.remove(tempList.size() - 1);
		}
	}

	// iterative
	public List<List<Integer>> subsetsWithDupApproach2(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<Integer>());

		int size = 0, startIndex;
		
		for(int i = 0; i < num.length; i++) {
			startIndex = (i > 0 && num[i] == num[i - 1]) ? size : 0;
			size = ret.size();
			
			for(int j = startIndex; j < size; j++) {
				List<Integer> temp = new ArrayList<>(ret.get(j));
				temp.add(num[i]);
				ret.add(temp);
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		M_0090_Subsets2 obj = new M_0090_Subsets2();
		List<List<Integer>> res = obj.subsetsWithDup(new int[] {1,2,2});
		System.out.println(res);
	}
}
