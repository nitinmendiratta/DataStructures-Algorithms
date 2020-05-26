package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/minimum-absolute-difference/
 */
public class E_1200_MinimumAbsoluteDifference {

	
	// one pass
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        //sort elements
        Arrays.sort(arr);
        //init our min difference value
        int min = Integer.MAX_VALUE;
        //start looping over array to find real min element. Each time we found smaller difference
        //we reset resulting list and start building it from scratch. If we found pair with the same
        //difference as min - add it to the resulting list
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
	
	// 2 pass
	public List<List<Integer>> minimumAbsDifferenceMyApproach(int[] arr) {
		List<List<Integer>> res = new ArrayList();

		Arrays.sort(arr);;
		int minDiff = Integer.MAX_VALUE;
		for(int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i-1];
			minDiff = Math.min(diff, minDiff);
		}

		for(int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i-1];
			if(diff == minDiff) {
				res.add(Arrays.asList(arr[i-1], arr[i]));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_1200_MinimumAbsoluteDifference obj = new E_1200_MinimumAbsoluteDifference();
		System.out.println(obj.minimumAbsDifference(new int[] {4,2,1,3}));
		System.out.println(obj.minimumAbsDifference(new int[] {1,3,6,10,15}));
		System.out.println(obj.minimumAbsDifference(new int[] {3,8,-10,23,19,-4,-14,27}));
	}
}
