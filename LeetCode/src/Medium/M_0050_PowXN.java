package Medium;
/*
 * https://leetcode.com/problems/powx-n/
 */
public class M_0050_PowXN {

	// recursive
	public double myPow(double x, int n) {
		if(n == 0) return 1;
		if(n < 0) {
			x = 1/x;
		}
		return pow(x, n);
	}

	public double pow(double x, int n) {
		if(n == 0) return 1;
		return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
	}

	// iterative
	public double myPowIterative(double x, int n) {
		int m = n < 0 ? -n - 1 : n; // overflow protection
		
		double pow = 1.0, xCopy = x;

		while(m > 0) {
			if((m&1) != 0) { // check for odd n
				pow *= xCopy;
			}
			xCopy *= xCopy;
			m = m>>>1; // n = n/2
		}

		// divide by x because in starting if number is < 0 we subtract 1
		return n < 0 ? 1.0/pow/x : pow;
	}
	public static void main(String[] args) {
		M_0050_PowXN obj = new M_0050_PowXN();
		System.out.println(obj.myPow(2.00000, -2147483648));
		System.out.println(obj.myPowIterative(2.00000, -2147483648));
	}
}
