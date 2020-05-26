package Easy;
/*
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class E_0521_LongestUncommonSubsequence1 {

	/*
	 * If both the strings are identical, for example: “ac” and “ac”, it is obvious
	 * that no subsequence will be uncommon. Hence, return 0. 
	 * 
	 * If length(a) = length(b) and a != b, for example: “abcdef” and “defghi”, out of these two
	 * strings one string will never be a subsequence of other string. Hence, return length(a) or length(b). 
	 * 
	 * If length(a) != length(b), for example: “abcdabcd” and
	 * “abcabc”, in this case we can consider bigger string as a required
	 * subsequence because bigger string can not be a subsequence of smaller string.
	 * Hence, return max(length(a), length(b)).
	 */
	public int findLUSlength(String a, String b) {
		// Case 1: If strings are equal 
		if (a.equals(b)==true)  
			return -1; 

		// for case 2 and case 3 
		return Math.max(a.length(), b.length()); 
	}
	public static void main(String[] args) {
		E_0521_LongestUncommonSubsequence1 obj = new E_0521_LongestUncommonSubsequence1();
		System.out.println(obj.findLUSlength("aba", "cdc"));
	}
}
