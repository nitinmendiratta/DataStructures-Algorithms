package Easy;
/*
 * https://leetcode.com/problems/palindrome-number/
 * Time complexity : O(log(n)). We divided the input by 10 for every iteration
 * Space complexity : O(1).
 */
public class E_0009_PalindromeNumber {
	
	public boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }

	public boolean isPalindromeApproac2(int x) {
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}        
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	public static void main(String[] args) {
		E_0009_PalindromeNumber obj = new E_0009_PalindromeNumber();
		System.out.println(obj.isPalindrome(121));
		System.out.println(obj.isPalindrome(1211));
	}
}
