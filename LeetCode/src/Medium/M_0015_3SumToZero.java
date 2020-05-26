package Medium;
import java.util.*;
//https://leetcode.com/problems/3sum/
// http://buttercola.blogspot.com/2014/07/leetcode-3sum.html
// various approaches check buttercola

public class M_0015_3SumToZero {

	/*  O(n^2) but does not require additional storage
	 *	The idea is to sort an input array and then run through all indices of a possible first element of a triplet. 
	 *	For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
	 *	Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (length < 3) return result;

		// Sort the array
		Arrays.sort(nums);

		for (int i = 0; i < length - 2; i++) {
			if (nums[i] > 0) break;

			// avoid duplicates check nums[i] != nums[i - 1]
			if (i == 0 || nums[i] != nums[i - 1]) {
				int target = 0 - nums[i];
				int start = i + 1;
				int end = length - 1;

				while (start < end) {
					if (nums[start] + nums[end] == target) {
						result.add(Arrays.asList(nums[i], nums[start], nums[end]));

						// avoid duplicated results
						while (start < end && nums[start] == nums[start+1]) start++;
						while (start < end && nums[end] == nums[end-1]) end--;
						start++;
						end--;
					} 
					else if (nums[start] + nums[end] > target) end--;
					else start++;
				}
			}
		}
		return result;
	}

	// using set to avoid duplicates
	// time and space O(n^2)
	public  List<List<Integer>> threeSumApproach2(int[] nums) {
		Set<List<Integer>> res  = new HashSet<>();
		int length = nums.length;
		if (length < 3) return new ArrayList<>(res);

		// Sort the array
		Arrays.sort(nums);

		for(int i = 0; i < nums.length-2; i++){
			int start = i+1;
			int  end = nums.length-1;
			while(start < end){
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == 0) {
					// Set uses equals method to check the equality of object, which is overridden in AbstractList class to compare every element in the List 
					// so, equals returns true only if every element in the list are equal.
					// so adding it to set avoid duplicates
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
				}
				else if ( sum > 0) end--;
				else if (sum < 0) start++;
			}

		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		M_0015_3SumToZero obj = new M_0015_3SumToZero();
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> result = obj.threeSum(nums);
		for(int i=0; i<result.size(); i++) {
			List<Integer> res = result.get(i);
			System.out.println(res);
		}
	}
}
