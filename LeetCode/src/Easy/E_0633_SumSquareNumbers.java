package Easy;
/*
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class E_0633_SumSquareNumbers {

	/*
	 * Time complexity : O(sqrt{c}log c). Binary search taking O(logc) in the worst
	 * case is done for sqrt{c} values of aa.
	 * 
	 * Space complexity : O(logc). Binary Search will take O(logc) space.
	 */
	public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
	public static void main(String[] args) {
		E_0633_SumSquareNumbers obj = new E_0633_SumSquareNumbers();
		System.out.println(obj.judgeSquareSum(5));
	}
}
