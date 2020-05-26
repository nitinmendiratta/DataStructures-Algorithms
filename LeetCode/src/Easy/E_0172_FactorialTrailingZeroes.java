package Easy;
/*
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 */
public class E_0172_FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
	public static void main(String[] args) {
		E_0172_FactorialTrailingZeroes obj = new E_0172_FactorialTrailingZeroes();
		System.out.println("Trailing zereos:"+obj.trailingZeroes(1808548329));
	}

}
