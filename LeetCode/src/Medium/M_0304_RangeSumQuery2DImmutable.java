package Medium;
/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class M_0304_RangeSumQuery2DImmutable {

	private int[][] dp;

	/* https://www.youtube.com/watch?v=PwDqpOMwg6U
	 * Time complexity construction O(n*m) Time complexity of query O(1) Space
	 * complexity is O(n*m)
	 */
	public M_0304_RangeSumQuery2DImmutable(int[][] matrix) {
		int row = 0;
		int col = 0;
		if (matrix.length != 0) {
			row = matrix.length;
			col = matrix[0].length;
		}
		dp = new int[row + 1][col + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1++;
		col1++;
		row2++;
		col2++;
		return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
	}

	/*
	 * Approach2 Time complexity : O(m) time per query, O(mn) time pre-computation.
	 * The pre-computation in the constructor takes O(mn) time. The sumRegion query
	 * takes O(m) time.
	 * 
	 * Space complexity : O(mn). The algorithm uses O(mn) space to store the
	 * cumulative sum of all rows
	 */
	public void M_0304_RangeSumQuery2DImmutableApproach2(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		dp = new int[matrix.length][matrix[0].length + 1];

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				dp[r][c + 1] = dp[r][c] + matrix[r][c];
			}
		}
	}

	public int sumRegionApproach2(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int row = row1; row <= row2; row++) {
			sum += dp[row][col2 + 1] - dp[row][col1];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		M_0304_RangeSumQuery2DImmutable obj = new M_0304_RangeSumQuery2DImmutable(matrix);
		System.out.println(obj.sumRegion(2, 1, 4, 3)); // 8
		System.out.println(obj.sumRegion(1, 1, 2, 2)); // 11
		System.out.println(obj.sumRegion(1, 2, 2, 4)); // 12
	}
}
