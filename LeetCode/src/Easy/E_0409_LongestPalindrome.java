package Easy;
import java.util.HashMap;
/*
 * https://leetcode.com/problems/longest-palindrome/
 */
public class E_0409_LongestPalindrome {

	public int longestPalindrome(String s) {
		if (s == null) return 0;

		int[] count = new int[128];
		for (char c : s.toCharArray()) {
			count[c]++;
		}

		int res = 0;
		for (int num : count) {
			res += (num/2) * 2;
		}

		return res == s.length() ? res : res + 1;
	}

	public int longestPalindromeApproach2(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int maxLength = 0, i = 0;
		while(i < s.length()){
			if(hm.containsKey(s.charAt(i))){
				hm.remove(s.charAt(i));
				maxLength = maxLength+2;
			}else{
				hm.put(s.charAt(i), 1);
			}
			i++;
		}
		if(hm.containsValue(1)){
			maxLength++;
		}
		return maxLength;
	}
	public static void main(String[] args) {
		E_0409_LongestPalindrome obj = new E_0409_LongestPalindrome();
		System.out.println(obj.longestPalindrome("abccccdd"));
	}
}
