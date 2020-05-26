package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class M_0368_LargestDivisibleSubset {

	/*
	 * 1. Sort the arr
	 * 2. Keep track of largest Divisible subset seq indexes in a seperate (parent) arr
	 * 3. Record length of largest Divisible subset sequence and the index of max element in that sequence
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		Arrays.sort(nums);
		int parent[] = new int[nums.length]; // Tracking the predecessors/parents of elements of each subsequence.
		int cache[] = new int[nums.length]; // Tracking length of each increasing subsequence.
		int maxLength = 0, maxIdx = -1; // Length of longest subsequence and idx

		/* Initialize LIS values for all indexes */
		Arrays.fill(cache, 1);
		Arrays.fill(parent, -1);
		
	    for (int i = 0; i < nums.length; i++){
	        for (int j = 0; j < i; j++){
	            if (nums[i] % nums[j] == 0 && cache[i] < cache[j] + 1){
	            	cache[i] = cache[j] + 1;
	            	parent[i] = j; // track index of largest sequence 	
	            }
	        }
	        if (cache[i] > maxLength){
	        	maxLength = cache[i];
	        	maxIdx = i;
	        }
	    }

	    while (maxIdx != -1){
	        res.add(nums[maxIdx]);
	        maxIdx = parent[maxIdx];
	    }
	    return res;
	}

	public static void main(String[] args) {
		M_0368_LargestDivisibleSubset obj = new M_0368_LargestDivisibleSubset();
		System.out.println(obj.largestDivisibleSubset(new int[] { 1, 2, 3 }));
		System.out.println(obj.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
		System.out.println(obj.largestDivisibleSubset(new int[] {1}));
		System.out.println(obj.largestDivisibleSubset(new int[] {546, 669}));
	}

}
