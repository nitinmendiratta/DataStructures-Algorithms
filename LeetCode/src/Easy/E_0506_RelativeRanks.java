package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/relative-ranks/
 */
public class E_0506_RelativeRanks {

	public String[] findRelativeRanks(int[] nums) {
		// clone array so we dont loose original order
		int[] numsOrdered = nums.clone();
		
		// sort cloned array
		Arrays.sort(numsOrdered);
		int length = nums.length;
		String[] ranking = new String[length];
		
		for(int i = 0; i < length; i++){
			
			// find each elt of original array is sorted array and get its rank
			int rank = Arrays.binarySearch(numsOrdered, nums[i]);
			
			if(rank == length-1){
				ranking[i] = "Gold Medal";
			}
			else if(rank == length-2){
				ranking[i] = "Silver Medal";
			}
			else if(rank == length-3){
				ranking[i] = "Bronze Medal";
			}
			else{
				ranking[i] = String.valueOf(length - rank);
			}
		}
		return ranking;
	}
	public String[] findRelativeRanksApproach2(int[] nums) {
		Integer[] index = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}

		//sorting index array in descending order based on the scores in num array.
		Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
		// index array is [3, 2, 1, 4, 0] index array will contain max score athlete at index 0

		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[index[i]] = "Gold Medal";
			}
			else if (i == 1) {
				result[index[i]] = "Silver Medal";
			}
			else if (i == 2) {
				result[index[i]] = "Bronze Medal";
			}
			else {
				result[index[i]] = (i + 1) + "";
			}
		}

		return result;
	}
	public static void main(String[] args) {
		E_0506_RelativeRanks obj = new E_0506_RelativeRanks();
		int[] input = {1,3,4,5,2};
		System.out.println(Arrays.toString(obj.findRelativeRanks(input)));
	}
}
