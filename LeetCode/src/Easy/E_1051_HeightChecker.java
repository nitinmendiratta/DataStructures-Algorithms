package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/height-checker/
 */
public class E_1051_HeightChecker {

	// using counting sort
	// https://www.youtube.com/watch?v=7zuGmKfUt7s
	// https://www.geeksforgeeks.org/counting-sort/
	public int heightChecker(int[] heights) {
		int[] count = new int[101];

		//count the frequency of each height 
		for (int i = 0; i < heights.length; i++) {
			count[heights[i]]++;
		}

		// Change count[i] so that count[i] now contains actual 
		// position of this character in output array 
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		int result = 0;

		for (int i = heights.length-1; i >= 0; i--) {
			count[heights[i]]--; // this is the correct location for heights[i] based on counting sort
			if (heights[count[heights[i]]] != heights[i])
				result++;
		}
		return result;
	}
	public int heightCheckerMyApproach(int[] heights) {
		int[] copy = heights.clone();
		Arrays.sort(copy);
		int count = 0;

		for(int i = 0; i < copy.length; i++){
			if(heights[i] != copy[i])count++;
		}
		return count;
	}
	public static void main(String[] args) {
		E_1051_HeightChecker obj = new E_1051_HeightChecker();
		System.out.println(obj.heightChecker(new int[] {1,1,4,2,1,3}));
	}
}
