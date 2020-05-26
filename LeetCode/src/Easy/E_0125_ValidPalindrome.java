package Easy;
/*
 * https://oj.leetcode.com/problems/valid-palindrome/
 */
public class E_0125_ValidPalindrome {

	public boolean isPalindrome(String s) {
		if(s == null || s == "" || s == " ") return true;
        
        int n = s.length();
        
        for(int i = 0,j = n-1;i <= n/2 && j >= n/2; i++,j--){
        	
        	while(i <= n/2 && !Character.isLetterOrDigit(s.charAt(i)))i++;
        	while(j >= n/2 && !Character.isLetterOrDigit(s.charAt(j)))j--;
        	
        	if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		E_0125_ValidPalindrome obj = new E_0125_ValidPalindrome();
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(obj.isPalindrome(" "));
	}
}
