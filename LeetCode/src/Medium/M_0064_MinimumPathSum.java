package Medium;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class M_0064_MinimumPathSum {

	// O(1) space, O(m*n) time complexity solution
	public int minPathSum(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;

		// Initialize first col with curr value + prev cell val
		for(int row = 1; row < rows; row++) {
			grid[row][0] += grid[row-1][0];
		}
		// Initialize first row with curr value + prev cell val
		for(int col = 1; col < cols; col++) {
			grid[0][col] += grid[0][col-1];
		}

		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}

		return grid[rows-1][cols-1];
	}

	// O(n) space, O(m*n) time complexity solution
	public int minPathSumApproach2(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;
		int[] minSum = new int[cols];
		minSum[0] = grid[0][0];

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(i == 0 && j > 0) minSum[j] = minSum[j - 1] + grid[i][j];
				else if(j == 0 && i > 0) minSum[j] = minSum[j] + grid[i][j];
				else if(i > 0 && j > 0) minSum[j] = Math.min(minSum[j], minSum[j - 1]) + grid[i][j];
			}
			// Iteration 1: dp array will be [1,4,5] after above loop for given same input	
			// Iteration 2: dp array will be [2,7,6] after above loop for given same input	
			// Iteration 3: dp array will be [6,8,7] after above loop for given same input	
		}
		return minSum[cols - 1];
	}

	// O(m*n) space, O(m*n) time complexity solution
	public int minPathSumApproach3(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;

		int[][] dp = new int[rows][cols];
		dp[0][0] = grid[0][0];

		// Initialize first col with 1
		for(int row = 1; row < rows; row++) {
			dp[row][0] = grid[row][0] + dp[row-1][0];
		}
		// Initialize first row with 1
		for(int col = 1; col < cols; col++) {
			dp[0][col] = grid[0][col] + dp[0][col-1];
		}

		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}

		return dp[rows-1][cols-1];
	}

	public static void main(String[] args) {
		M_0064_MinimumPathSum obj = new M_0064_MinimumPathSum();
		int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(obj.minPathSum(grid));
	}
}
