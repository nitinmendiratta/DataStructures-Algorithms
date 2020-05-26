package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/ugly-number-ii/
 * http://www.geeksforgeeks.org/ugly-numbers/
 */
public class M_0264_UglyNumber2 {

	public int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;

		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(factor2, factor3), factor5);
			ugly[i] = min;
			if (factor2 == min)
				factor2 = 2 * ugly[++index2];
			if (factor3 == min)
				factor3 = 3 * ugly[++index3];
			if (factor5 == min)
				factor5 = 5 * ugly[++index5];
		}
		return ugly[n - 1];
	}

	// Using priority queue
	public int nthUglyNumberApproach2(int n) {
		if (n == 1)
			return 1;
		PriorityQueue<Long> q = new PriorityQueue();
		q.add(1l);

		for (long i = 1; i < n; i++) {
			long tmp = q.poll();
			while (!q.isEmpty() && q.peek() == tmp)
				tmp = q.poll();

			q.add(tmp * 2);
			q.add(tmp * 3);
			q.add(tmp * 5);
		}
		return q.poll().intValue();
	}

	// Using Treeset
	public int nthUglyNumberApproach3(int n) {
		TreeSet<Long> ans = new TreeSet<>();
		ans.add(1L);
		for (int i = 0; i < n - 1; ++i) {
			long first = ans.pollFirst();
			ans.add(first * 2);
			ans.add(first * 3);
			ans.add(first * 5);
		}
		return ans.first().intValue();
	}

	public static void main(String[] args) {
		M_0264_UglyNumber2 obj = new M_0264_UglyNumber2();
		System.out.println(obj.nthUglyNumber(10));
	}

}
