package Easy;
/*
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
public class E_1332_RemovePalindromicSubsequences {

	/*
	 * 	If it's empty sting, return 0;
		If it's palindrome, return 1;
		Otherwise, we need at least 2 operation.
		
		
		Explanation
		We can delete all characters 'a' in the 1st operation,
		and then all characters 'b' in the 2nd operation.
		So return 2 in this case
		Time O(N)
		Space O(N), also O(1) space checking palindrome is suuggested.
	 */
	public int removePalindromeSub(String s) {
		if (s.length() == 0) return 0;
		if (isPalindrome(s)) return 1;
		else return 2;
	}

	boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		E_1332_RemovePalindromicSubsequences obj = new E_1332_RemovePalindromicSubsequences();
		System.out.println(obj.removePalindromeSub("ababa"));
	}
}
