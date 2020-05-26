package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class M_0373_FindKPairsWithSmallestSums {
	/*
	 * 1. Build a minHeap of elements from the first row. 
	 * 
	 * 2. Do the following operations k-1 times : 
	 * Every time when you poll out the root(Top Element in
	 * Heap), you need to know the row number and column number of that element(so
	 * we can create a tuple class here), replace that root with the next element
	 * from the same column.
	 */
	class Tuple implements Comparable<Tuple> {
		int x, y, val;

		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Tuple that) {
			return this.val - that.val;
		}
	}

	/*
	 * idea is to insert all pairs in queue keeping 0th element of first arr fixed and forming pair
	 * with every element in 2nd array and then looping over queue and forming pairs by moving index on first array
	 * and fixing yth element polled from queue
	 */
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		int m = nums1.length, n = nums2.length;
		List<List<Integer>> res = new ArrayList();

		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
			return res;

		// insert initial tuples
		for (int j = 0; j <= n - 1; j++)
			pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));

		/*
		 * m * n is a maximum number of tuples that can be generated from two arrays. If
		 * k is greater than this number, the loop will go beyond arrays. 
		 * Math.min(k, m*n) picks up the loop limitation accordingly.
		 */
		for (int i = 0; i < Math.min(k, m * n); i++) {
			// get the top tuple from queue with min sum
			Tuple t = pq.poll();
			res.add(Arrays.asList(nums1[t.x], nums2[t.y]));
			
			// if we exhaust first array list
			if (t.x == m - 1)
				continue;
			
			pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
		}

		return res;
	}

	public static void main(String[] args) {
		M_0373_FindKPairsWithSmallestSums obj = new M_0373_FindKPairsWithSmallestSums();
		List<List<Integer>> result = obj.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
		for (List a : result) {
			System.out.println(a);
		}
	}

}
