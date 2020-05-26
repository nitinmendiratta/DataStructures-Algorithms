package Greedy_Backtracking_PS_DnC;
/*
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 */

public class LongestPalindromicSubstring2 {

	// This function prints the longest palindrome substring of str[]. It also returns the length of the longest palindrome
	public int[] longestPalSubstr2(String str){
		int maxLength = 1, start = 0, len = str.length(), low = 0, high = 0;
		int result[] = new int[2];
		// One by one consider every character as center point of even and length palindromes
		for (int i = 1; i < len; ++i){
			// Find the longest even length palindrome with center points as i-1 and i.  
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
				if (high - low + 1 > maxLength){
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			// Find the longest odd length palindrome with center point as i
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
				if (high - low + 1 > maxLength){
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		result[0] = start;
		result[1] = start + maxLength - 1;
		return result; // return length of LPS
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring2 obj = new LongestPalindromicSubstring2();
		String s = "forgeeksskeegfor";
		int[] result = obj.longestPalSubstr2(s);
		System.out.println(s.substring(result[0],result[1]+1)); 
	}
}