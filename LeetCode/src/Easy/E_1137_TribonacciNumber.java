package Easy;
/*
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class E_1137_TribonacciNumber {

	public int tribonacci(int n) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		return memoize(n);
	}

	public int memoize(int N) {
		int[] cache = new int[N + 1];
		cache[1] = 1;
		cache[2] = 1;

		for (int i = 3; i <= N; i++) {
			cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
		}
		return cache[N];
	}
	public static void main(String[] args) {
		E_1137_TribonacciNumber obj = new E_1137_TribonacciNumber();
		System.out.println(obj.tribonacci(4));
	}
}
