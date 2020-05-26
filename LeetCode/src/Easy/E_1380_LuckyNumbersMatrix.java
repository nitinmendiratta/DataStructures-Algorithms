package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
public class E_1380_LuckyNumbersMatrix {

	/*
	 * Time: O(m * n), space: O(max(m, n)), where m = matrix.length, n =
	 * matrix[0].length.
	 */
	public List<Integer> luckyNumbers(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		int[] minRow = new int[rows];
		int[] maxCol = new int[cols];
		List<Integer> res = new ArrayList();

		Arrays.fill(minRow, Integer.MAX_VALUE);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				minRow[i] = Math.min(matrix[i][j], minRow[i]);
				maxCol[j] = Math.max(matrix[i][j], maxCol[j]);
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (minRow[i] == maxCol[j]) {
					res.add(matrix[i][j]);
				}
			}
		}
		return res;
	}

	// Set Intersection
	public List<Integer> luckyNumbersApproach2(int[][] matrix) {
		Set<Integer> minSet = new HashSet<>(), maxSet = new HashSet<>();
		
		for (int[] row : matrix) {
			int mi = row[0];
			for (int cell : row)
				mi = Math.min(mi, cell);
			minSet.add(mi);
		}
		
		for (int j = 0; j < matrix[0].length; ++j) {
			int mx = matrix[0][j];
			for (int i = 0; i < matrix.length; ++i)
				mx = Math.max(matrix[i][j], mx);
			if (minSet.contains(mx))
				maxSet.add(mx);
		}
		return new ArrayList<>(maxSet);
	}

	public static void main(String[] args) {
		E_1380_LuckyNumbersMatrix obj = new E_1380_LuckyNumbersMatrix();
		int[][] matrix = new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		System.out.println(obj.luckyNumbers(matrix));
	}
}
