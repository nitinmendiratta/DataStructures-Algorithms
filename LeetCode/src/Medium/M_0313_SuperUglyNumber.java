package Medium;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/super-ugly-number/
 */
public class M_0313_SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
	    int[] index  = new int[primes.length]; // array to store index
	    int[] ugly = new int[n];
	    ugly[0] = 1; // first is 1
	 
	    for (int i = 1; i < n; i++) {
	        int min = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++) {
	            min = Math.min(min, primes[j] * ugly[index[j]]);
	        }
	 
	        ugly[i] = min;
	 
	        for (int j = 0; j < index .length; j++) {
	        	// incr the index of the min element
	            if (ugly[index[j]] * primes[j] == min) {
	            	index[j]++;
	            }
	        }
	    }
	 
	    return ugly[n - 1];
	}
	
	// my approach: too much time
	public int nthSuperUglyNumberApproach2(int n, int[] primes) {
		if (n == 1)
			return 1;
		PriorityQueue<Long> q = new PriorityQueue();
		q.add(1l);

		for (long i = 1; i < n; i++) {
			long tmp = q.poll();

			// handle duplicates
			while (!q.isEmpty() && q.peek() == tmp)
				tmp = q.poll();

			for(int j = 0; j < primes.length; j++) {
				q.add(tmp * primes[j]);
			}
		}
		return q.poll().intValue();
	}

	public static void main(String[] args) {
		M_0313_SuperUglyNumber obj = new M_0313_SuperUglyNumber();
		System.out.println(obj.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));

	}

}
