package Easy;
/*
 * https://leetcode.com/problems/reverse-integer/
 * very good question
 * Time Complexity: O(log(x)). There are roughly log_{10}(x) digits in x.
 * Space Complexity: O(1).
 */
public class E_0007_ReverseInteger {
	
	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; // will give 3 in 123
            x /= 10; // will give 12 in 123
            // max int value is 2147483647 so need to check if pop is not > 7 is rev is 214748364
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

	public static void main(String[] args) {
		E_0007_ReverseInteger obj = new E_0007_ReverseInteger();
		System.out.println("Reversed number is: "+obj.reverse(-2147483412));
		System.out.println("Reversed number is: "+obj.reverse(2147483647));
	}
}
