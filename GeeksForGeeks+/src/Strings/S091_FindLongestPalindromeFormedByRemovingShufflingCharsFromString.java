package Strings;
/*
 * http://www.geeksforgeeks.org/find-longest-palindrome-formed-by-removing-or-shuffling-chars-from-String/
 * 
 * Time complexity of above solution is O(n) where n is length of the String. 
 * Since, number of characters in the alphabet is constant, they do not contribute to asymptotic analysis.
 * Auxiliary space used by the program is M where M is number of ASCII characters.
 */
public class S091_FindLongestPalindromeFormedByRemovingShufflingCharsFromString {

	// Function to find the longest palindrome by removing
	// or shuffling characters from the given String
	String findLongestPalindrome(String str){
	    // to stores freq of characters in a String
	    int count[] = new int[256];
	 
	    // find freq of characters in the input String
	    for (int i = 0; i < str.length(); i++)
	        count[str.charAt(i)]++;
	 
	    // Any palindromic String consists of three parts beg + mid + end
	    String beg = "", mid = "", end = "";
	 
	    // solution assumes only lowercase characters are
	    // present in String. We can easily extend this
	    // to consider any set of characters
	    for (char ch = 'a'; ch <= 'z'; ch++){
	        // if the current character freq is odd
	        if ((count[ch] & 1) == 1){
	            // mid will contain only 1 character. It
	            // will be overridden with next character
	            // with odd freq
	            mid += ch;
	 
	            // decrement the character freq to make
	            // it even and consider current character
	            // again
	            count[ch--]--;
	        }
	 
	        // if the current character freq is even
	        else{
	            // If count is n(an even number), push
	            // n/2 characters to beg String and rest
	            // n/2 characters will form part of end
	            // String
	            for (int i = 0; i < count[ch]/2 ; i++)
	                beg += ch;
	        }
	    }
	 
	    // end will be reverse of beg
	    end = new StringBuilder(beg).reverse().toString();
	 
	    // return palindrome String
	    return beg + mid + end;
	}
	public static void main(String[] args) {
		S091_FindLongestPalindromeFormedByRemovingShufflingCharsFromString obj = new S091_FindLongestPalindromeFormedByRemovingShufflingCharsFromString();
		String str = "abbaccd";
		 
	    System.out.println(obj.findLongestPalindrome(str));
	 
	}
}
