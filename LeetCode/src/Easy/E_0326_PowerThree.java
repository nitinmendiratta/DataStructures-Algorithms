package Easy;
/*
 * https://leetcode.com/problems/power-of-three/
 */
public class E_0326_PowerThree {
	public boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	public static void main(String[] args) {
		E_0326_PowerThree obj = new E_0326_PowerThree();
		System.out.println(obj.isPowerOfThree(9));
	}
}
