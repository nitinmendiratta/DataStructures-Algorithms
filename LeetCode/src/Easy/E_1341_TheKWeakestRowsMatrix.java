package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class E_1341_TheKWeakestRowsMatrix {

	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
		int[] ans = new int[k];

		for (int i = 0; i < mat.length; i++) {
			pq.offer(new int[] {
					getScore(mat[i]), i
			});
			if (pq.size() > k)
				pq.poll();
		}

		while (k > 0)
			ans[--k] = pq.poll()[1];

		return ans;
	}

	private int getScore(int[] row) {
		int lo = 0;
		int hi = row.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (row[mid] == 1)
				lo = mid + 1;
			else
				hi = mid;
		}

		return lo;
	}

	public static void main(String[] args) {
		E_1341_TheKWeakestRowsMatrix obj = new E_1341_TheKWeakestRowsMatrix();
		int[][] matrix = new int[][] {
			{1,1,0,0,0},
			{1,1,1,1,0},
			{1,0,0,0,0},
			{1,1,0,0,0},
			{1,1,1,1,1}
		};
		System.out.println(Arrays.toString(obj.kWeakestRows(matrix, 3)));
	}
}
