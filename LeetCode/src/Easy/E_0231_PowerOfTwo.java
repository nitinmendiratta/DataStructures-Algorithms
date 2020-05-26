package Easy;
/*
 * https://leetcode.com/problems/power-of-two/
 */
public class E_0231_PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
        if ((n&(n-1)) != 0) return false;
        return true;
    }
	
	public static void main(String[] args) {
		E_0231_PowerOfTwo obj = new E_0231_PowerOfTwo();
		System.out.println(obj.isPowerOfTwo(16));
	}
}
