package Easy;
import java.math.BigInteger;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/prime-arrangements/
 */
public class E_1175_PrimeArrangements {


	public int numPrimeArrangements(int n) {
		int[] non = new int[n+1];
		int[] cnt = {0, 1};
		long res = 1;
		for (int i=2; i<=n; i++) {
			if (non[i] == 0)
				for (int m=i*i; m<=n; m+=i)
					non[m] = 1;
			res = res * ++cnt[non[i]] % 1_000_000_007;
		}
		return (int) res;
	}


	// Approach2
	static int MOD = 1000000007;

	public static int numPrimeArrangementsApproach2(int n) {
		int noOfPrime = countPrimes(n);
		BigInteger x = factorial(noOfPrime);
		BigInteger y = factorial(n - noOfPrime);
		return x.multiply(y).mod(BigInteger.valueOf(MOD)).intValue();
	}

	public static BigInteger factorial(int n) {
		BigInteger fac = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}
		return fac.mod(BigInteger.valueOf(MOD));
	}

	//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
	public static int countPrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);

		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		int cnt = 0;
		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				cnt++;

		return cnt;
	}
	public static void main(String[] args) {
		E_1175_PrimeArrangements obj = new E_1175_PrimeArrangements();
		System.out.println(obj.numPrimeArrangements(5));
	}
}
