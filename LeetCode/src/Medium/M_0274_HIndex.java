package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/h-index/
 */
public class M_0274_HIndex {

	/*
	 * 2) The O(n) solution:
		A researcher have 5 pulications:
		A, B, C, D, E with
		5, 8,10, 4, 3 citation respectively.
		
		After first loop:
		
		  for (int c: citations)
		        if (c > len) 
		            count[len]++;
		        else 
		            count[c]++;
		we have the count array:
		
		value: 0, 0, 0, 1, 1, 3
		index: 0, 1, 2, 3, 4, 5
		In second loop:
		
		  for (int i = len; i >= 0; i--) {
		        total += count[i];
		        if (total >= i)
		            return i;
		    }
		Step 1: index is 5, total = 3.
		Step 2: index is 4, total = 4, return 4.
	 */
	public int hIndex(int[] citations) {
	    int len = citations.length;
	    int[] count = new int[len + 1];
	    
	    for (int c: citations)
	        if (c > len) 
	            count[len]++;
	        else 
	            count[c]++;
	    
	    
	    int total = 0;
	    for (int i = len; i >= 0; i--) {
	        total += count[i];
	        if (total >= i)
	            return i;
	    }
	    
	    return 0;
	}
	
	public int hIndexApproach2(int[] citations) {

		Arrays.sort(citations);
		int len = citations.length;
		for (int i = 0; i < len; i++) {
			int rCitations = len - i; //  h of N papers have at least h citations each
			if (citations[i] >= rCitations)
				return len - i;

		}
		return 0;
	}

	public static void main(String[] args) {
		M_0274_HIndex obj = new M_0274_HIndex();
		System.out.println(obj.hIndex(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(obj.hIndex(new int[] { 10, 8, 5, 4, 3 }));
		System.out.println(obj.hIndex(new int[] { 25, 8, 5, 3, 3 }));
		System.out.println(obj.hIndex(new int[] { 5, 6, 7, 8 }));
	}
}
