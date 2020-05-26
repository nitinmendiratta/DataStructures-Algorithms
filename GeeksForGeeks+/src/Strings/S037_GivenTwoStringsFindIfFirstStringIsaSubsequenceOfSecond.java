package Strings;
/*
 * http://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
 */
public class S037_GivenTwoStringsFindIfFirstStringIsaSubsequenceOfSecond {

	// Returns true if str1[] is a subsequence of str2[]. m is length of str1 and n is length of str2
	public boolean isSubSequence(String str1, String str2){
		int m = str1.length(), n = str2.length(), j = 0; // For index of str1 (or subsequence

	// Traverse str2 and str1, and compare current character of str2 with first unmatched char of str1, if matched then move ahead in str1
		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i)) j++;

		// If all characters of str1 were found in str2
		return (j == m);
	}
	
	public static void main(String[] args) {
		S037_GivenTwoStringsFindIfFirstStringIsaSubsequenceOfSecond obj = new S037_GivenTwoStringsFindIfFirstStringIsaSubsequenceOfSecond();
		System.out.println(obj.isSubSequence("AXY","ADXCPY"));
		System.out.println(obj.isSubSequence("AXY","YADXCP"));
		System.out.println(obj.isSubSequence("gksrek","geeksforgeeks"));
	}
}
