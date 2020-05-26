package Easy;
/*
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class E_0680_ValidPalindrome2 {

	public boolean validPalindrome(String s) {
		int l = 0;
		int r = s.length()-1;
		while (l<=r){
			if (s.charAt(l) == s.charAt(r)){
				l++;
				r--;
			}
			else{
				return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
			}
		}
		return true;
	}

	private boolean isPalindrome(String str, int s, int t){
		while (s <= t){
			if (str.charAt(s) == str.charAt(t)){
				s++;
				t--;
			}
			else
				return false;
		}

		return true;
	}
	public static void main(String[] args) {
		E_0680_ValidPalindrome2 obj = new E_0680_ValidPalindrome2();
		System.out.println(obj.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
	}
}
