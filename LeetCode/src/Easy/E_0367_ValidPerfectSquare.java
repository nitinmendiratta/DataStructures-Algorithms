package Easy;
/*
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class E_0367_ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		int low = 1, high = num;
		while (low <= high) {
			long mid = (low + high) >>> 1;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				low = (int) mid + 1;
			} else {
				high = (int) mid - 1;
			}
		}
		return false;
	}
	public boolean isPerfectSquareApproach2(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
	public boolean isPerfectSquareNewtonMethod(int num) {
		long x = num;
		while (x * x > num) {
			x = (x + num / x) >> 1;
		}
		return x * x == num;
	}
	public static void main(String[] args) {
		E_0367_ValidPerfectSquare obj = new E_0367_ValidPerfectSquare();
		int x = 4;//2147395599; 
		System.out.println(obj.isPerfectSquare(8));
	}
}
