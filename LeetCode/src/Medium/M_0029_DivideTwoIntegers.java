package Medium;
/*
 * https://leetcode.com/problems/divide-two-integers/
 */
public class M_0029_DivideTwoIntegers {

	
	public int divide(int dividend, int divisor) {
		// a == 1 << 31
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend), 
        b = Math.abs(divisor), 
        res = 0,
        x = 0;
        
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
	public static void main(String[] args) {
		M_0029_DivideTwoIntegers obj = new M_0029_DivideTwoIntegers();
		System.out.println(obj.divide(10, 3));

	}

}
