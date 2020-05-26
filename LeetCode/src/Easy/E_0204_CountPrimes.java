package Easy;
/*
 * https://leetcode.com/problems/count-primes/
 */
public class E_0204_CountPrimes {
	//Sieve of Eratosthenes algorithm
	public int countPrimes(int n) {
		boolean[] isPrime =  new boolean[n];
		for(int i = 2; i < n; i++){
			isPrime[i] = true;
		}


		for (int i = 2; i*i < n ; i++){
			if (isPrime[i]){
				for (int j = i; j*i < n; j++){
					isPrime[i*j] = false;
				}
			}
		}

		int count = 0;
		for(int i = 2; i < n; i++){
			if (isPrime[i]) {
				count++;
			}
		}

		return count;   
	}
	public static void main(String[] args) {
		E_0204_CountPrimes obj = new E_0204_CountPrimes();
		System.out.println(obj.countPrimes(10));

	}
}
