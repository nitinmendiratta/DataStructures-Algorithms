package Easy;
/*
 * https://leetcode.com/problems/fibonacci-number/
 */
public class E_0509_FibonacciNumber {

	public int fib(int N) {
		if (N <= 1) {
			return N;
		}
		return memoize(N);
	}

	public int memoize(int N) {
		int[] cache = new int[N + 1];
		cache[1] = 1;

		for (int i = 2; i <= N; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[N];
	}
	public static void main(String[] args) {
		E_0509_FibonacciNumber obj = new E_0509_FibonacciNumber();
		System.out.println(obj.fib(4));
	}
}
