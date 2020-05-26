package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class M_0378_KthSmallestElementInSortedMatrix {

	/*
	 * The Binary Search could take O(log(max-min)) iterations where ‘max’ is the
	 * largest and ‘min’ is the smallest element in the matrix and in each iteration
	 * we take O(N) for counting, therefore, the overall time complexity of the
	 * algorithm will be O(N*log(max-min)).
	 * 
	 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int start = matrix[0][0], end = matrix[n - 1][n - 1];

		while (start < end) {
			int mid = start + (end - start) / 2;
			// first number is the smallest and the second number is the largest
			int[] smallLargePair = { matrix[0][0], matrix[n - 1][n - 1] };

			int count = countLessEqual(matrix, mid, smallLargePair);

			if (count == k)
				return smallLargePair[0];

			// the count is less than ‘K’, we can update start = n2 to search in the higher
			// part of the matrix
			if (count < k)
				start = smallLargePair[1]; // search higher
			else
				end = smallLargePair[0]; // search lower
		}

		return start;
	}

	private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
		int count = 0;
		int n = matrix.length, row = n - 1, col = 0;

		while (row >= 0 && col < n) {
			if (matrix[row][col] > mid) {
				// as matrix[row][col] is bigger than the mid, let's keep track of the
				// smallest number greater than the mid
				smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
				row--;
			} else {
				// as matrix[row][col] is less than or equal to the mid, let's keep track of the
				// biggest number less than or equal to the mid
				smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
				count += row + 1;
				col++;
			}
		}
		return count;
	}

	// Approach2: Easy to understand: Binary search same as first approach but less optimized
	// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
	public int kthSmallestApproach2(int[][] matrix, int k) {
		int rowLength = matrix.length - 1, colLength = matrix[0].length - 1;

		int lo = matrix[0][0], hi = matrix[rowLength][colLength] + 1;// [lo, hi)

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			int count = 0, j = colLength;

			// Count all the numbers smaller than or equal to middle in the matrix
			for (int i = 0; i < matrix.length; i++) {

				// start from last col in ith row and keep moving left until curr elemt is > mid
				// if not we exit as the row is sorted so all elements to the left of curr elt
				// will also be smaller
				while (j >= 0 && matrix[i][j] > mid)
					j--;

				// add num of elts < mid in this row to count
				count += (j + 1);
			}

			// the count is less than ‘K’, we can update start = mid+1 to search in the
			// higher part of the matrix
			if (count < k)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	// Approach3: Using heap
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

	// O(min(K,N)+K∗logN).
	public int kthSmallestApproach3(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

		for (int j = 0; j <= n - 1; j++)
			pq.offer(new Tuple(0, j, matrix[0][j]));

		for (int i = 0; i < k - 1; i++) {
			Tuple t = pq.poll();

			if (t.x == n - 1)
				continue;

			pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
		}
		return pq.poll().val;
	}

	public static void main(String[] args) {
		M_0378_KthSmallestElementInSortedMatrix obj = new M_0378_KthSmallestElementInSortedMatrix();

		int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(obj.kthSmallest(matrix, 8));
	}
}
