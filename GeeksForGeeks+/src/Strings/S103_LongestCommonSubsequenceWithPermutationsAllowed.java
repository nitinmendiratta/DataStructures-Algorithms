package Strings;
/*
 * http://www.geeksforgeeks.org/longest-common-subsequence-with-permutations-allowed/
 * Time Complexity : O(m + n) where m and n are lengths of input strings.
 * Auxiliary Space : O(1)
 */
public class S103_LongestCommonSubsequenceWithPermutationsAllowed {

	// Function to calculate longest String
	// str1     --> first String
	// str2     --> second String
	// count1[]  --> hash array to calculate frequency of characters in str1
	// count[2]  --> hash array to calculate frequency of characters in str2
	// result   --> resultant longest String whose permutations are sub-sequence of given two strings
	public static String longestString(String str1, String str2){
	    int count1[] = new int[26];
	    int count2[] = new int[26];
	 
	    // calculate frequency  of characters
	    for (int i=0; i<str1.length(); i++)
	        count1[str1.charAt(i)-'a']++;
	    for (int i=0; i<str2.length(); i++)
	        count2[str2.charAt(i)-'a']++;
	 
	    // Now traverse hash array
	    String result = "";
	    for (int i=0; i<26; i++)
	 
	        // append character ('a'+i) in resultant
	        // String 'result' by min(count1[i],count2i])
	        // times
	        for (int j=1; j <= Math.min(count1[i],count2[i]); j++)
	            result += (char)('a' + i);
	 
	    return result;
	}
	public static void main(String[] args) {
		String str1 = "geeks", str2 = "cake";
	    System.out.println(longestString(str1, str2));
	}
}
