package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class E_0697_DegreeArray {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;
        
        for (int i = 0; i < nums.length; ++i) {
        	
        	// add each element once to store first index of elt
            first.putIfAbsent(nums[i], i);
            // count map stores each elt's value as key and occurrence count as value
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            
            // check if current elts count is greater then max degree is, so update degree and calculate subarray length
            if (count.get(nums[i]) > degree) {
            	
                degree = count.get(nums[i]);
                // i here is the curr index of element and first.get(nums[i]) will give the first index of this elt
                res = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree)
            	
            	// in case we have another candidate get the min subarray length
                res = Math.min(res, i - first.get(nums[i]) + 1);
        }
        return res;
	}
	public static void main(String[] args) {
		E_0697_DegreeArray obj = new E_0697_DegreeArray();
		System.out.println(obj.findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
	}
}
