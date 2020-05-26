package Strings;
import DynamicProgramming.DP28_LongestPalindromicSubstring;
/*
 * http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
 */
public class S033_CheckIfStringIsRotationOfaPalindrome {

	public boolean isRotation(String s){
		int n = s.length();
		String temp = s+s;
		System.out.println(longestPalSubstrApproach2(temp)); 
		//if((result[1] - result[0]+1) > n) return true;
		return false;
	}
	
	public String longestPalSubstrApproach2(String str){
		int len = str.length();
		if(len == 0){
			return str;
		}
		int maxLength = 1;  // The result (length of LPS)

		int start = 0, low, high;

		// One by one consider every character as center point of even and length palindromes
		for (int i = 1; i < len; ++i){
			// Find the longest even length palindrome with center points
			// as i-1 and i.  
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

			// Find the longest odd length palindrome with center 
			// point as i
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
		return str.substring(start, start + maxLength);
	}
	public static void main(String[] args) {
		S033_CheckIfStringIsRotationOfaPalindrome obj = new S033_CheckIfStringIsRotationOfaPalindrome();
		System.out.println("Palindrome: "+obj.isRotation("abcd"));
		System.out.println("Palindrome: "+obj.isRotation("aaaad"));
		System.out.println("Palindrome: "+obj.isRotation("aab"));
		System.out.println("Palindrome: "+obj.isRotation("abcde"));
		
	}
}
