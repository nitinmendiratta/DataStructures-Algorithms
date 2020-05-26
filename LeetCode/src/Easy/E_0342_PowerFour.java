package Easy;
/*
 * https://leetcode.com/problems/power-of-four/
 */
public class E_0342_PowerFour {

	// Example: x=16 , y=4^2
	// So we can know that , x = 4^y
	// logx = y*log4
	// logx/log4 = y
	// Then we using y%1==0, that means y is Integer.
	public boolean isPowerOfFour(int num) {
		return (Math.log(num)/Math.log(4))%1 == 0;
	}
	public static void main(String[] args) {
		E_0342_PowerFour obj = new E_0342_PowerFour();
		System.out.println(obj.isPowerOfFour(-2147483648));
	}
}
