package Strings;
/*
 * http://www.geeksforgeeks.org/minimum-number-of-palindromic-subsequences-to-be-removed-to-empty-a-binary-string/
 */
public class S061_MinNumberOfPalindromicSubsequencesRemovedToEmptyBinaryString {

	// A function to check if a string str is palindrome
	boolean isPalindrome(String str){
	    // Start from leftmost and rightmost corners of str
	    int l = 0;
	    int h = str.length() - 1;
	 
	    // Keep comparing characters while they are same
	    while (h > l)
	        if (str.charAt(l++) != str.charAt(h--))
	            return false;
	 
	    return true;
	}
	 
	// Returns count of minimum palindromic subseuqnces to
	// be removed to make string empty
	public int minRemovals(String str){
	   // If string is empty
	   if (str.isEmpty())
	      return 0;
	 
	   // If given string is palindrome, we need only one removal.
	   if (isPalindrome(str))
	      return 1;
	 
	   // If string is not palindromewe need two removals. 
	   // Note that every binary string has all 1’s as a subsequence and all 0’s as another subsequence. 
	   // We can remove any of the two subsequences to get a unary string. A unary string is always palindrome.
	   return 2;
	}
	public static void main(String[] args) {
		S061_MinNumberOfPalindromicSubsequencesRemovedToEmptyBinaryString obj = new S061_MinNumberOfPalindromicSubsequencesRemovedToEmptyBinaryString();
		System.out.println(obj.minRemovals("010010"));
		System.out.println(obj.minRemovals("0100101"));
	}
}
