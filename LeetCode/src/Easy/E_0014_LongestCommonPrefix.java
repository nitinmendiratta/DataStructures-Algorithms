package Easy;
import java.util.*;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Time complexity : O(S), where S is the sum of all characters in all strings. 
 * In the worst case there will be nn equal strings with length mm and the algorithm performs = m⋅n character comparisons. 
 * In the best case there are at most n⋅minLen comparisons where minLen is the length of the shortest string in the array.
 * Space complexity : O(1). We only used constant extra space. 
 */

public class E_0014_LongestCommonPrefix {

	// Best Approach: Binary Search
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int minLen = Integer.MAX_VALUE;
		for (String str : strs)
			minLen = Math.min(minLen, str.length());
		int low = 1;
		int high = minLen;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (isCommonPrefix(strs, middle))
				low = middle + 1;
			else
				high = middle - 1;
		}
		return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len){
		String str1 = strs[0].substring(0,len);
		for (int i = 1; i < strs.length; i++)
			if (!strs[i].startsWith(str1))
				return false;
		return true;
	}

	// Approach 1: Vertical scanning
	public String longestCommonPrefixApproach2(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i = 0; i < strs[0].length() ; i++){
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j ++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);             
			}
		}
		return strs[0];
	}

	// Approach 2: DnC
	public String longestCommonPrefixApproach3(String[] strs) {
		if (strs == null || strs.length == 0) return "";    
		return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
		if (l == r) {
			return strs[l];
		}
		else {
			int mid = (l + r)/2;
			String lcpLeft =   longestCommonPrefix(strs, l , mid);
			String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	public String commonPrefix(String left,String right) {
		int min = Math.min(left.length(), right.length());       
		for (int i = 0; i < min; i++) {
			if ( left.charAt(i) != right.charAt(i) )
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}


	public static void main(String[] args) {
		E_0014_LongestCommonPrefix obj = new E_0014_LongestCommonPrefix();
		String[] input = {"flower", "flow", "flight"};
		System.out.println(obj.longestCommonPrefixApproach3(input));
		System.out.println(obj.longestCommonPrefixApproach2(input));
		System.out.println(obj.longestCommonPrefix(input));
	}
}
