package Medium;
/*
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class M_0063_UniquePaths2 {

	// O(n)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
		int[] dp = new int[cols];

		dp[0] = 1;
		// the 1 d array stores the previous col and updates in every col
		// for eg a 3*3 matrix arr[1,1,1] -> [1,2,3] -> [1,3,6] and finally return 6
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++)

				if(obstacleGrid[i][j] == 1) dp[j] = 0;
				else if(j > 0) dp[j] = dp[j-1] + dp[j];
		} 
		return dp[cols-1];
	}

	// O(m*n) dp without extra space
	public int uniquePathsWithObstaclesApproach2(int[][] obstacleGrid) {

		int R = obstacleGrid.length;
		int C = obstacleGrid[0].length;

		// If the starting cell has an obstacle, then simply return as there would be
		// no paths to the destination.
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		// Number of ways of reaching the starting cell = 1.
		obstacleGrid[0][0] = 1;

		// Filling the values for the first column
		for (int i = 1; i < R; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
		}

		// Filling the values for the first row
		for (int i = 1; i < C; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
		}

		// Starting from cell(1,1) fill up the values
		// No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
		// i.e. From above and left.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}

		// Return value stored in rightmost bottommost cell. That is the destination.
		return obstacleGrid[R - 1][C - 1];
	}
	
	
	// my approach: dp with extra space
	public int uniquePathsWithObstaclesDPApproach3(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
		int[][] dp = new int[rows][cols];

		// initialise first row with 1
		for(int row = 0; row < rows; row++) {
			if(obstacleGrid[0][row] == 1) break;
			dp[row][0] = 1;
		}
		// initialise first col with 1
		for(int col = 0; col < cols; col++) {
			if(obstacleGrid[0][col] == 1) break;
			dp[0][col] = 1;
		}
		for(int i = 1; i < rows; i++)
			for(int j = 1; j < cols; j++)
				if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
		// Since the robot can only move right and down, when it arrives at a point, it either arrives from left or above.
				else dp[i][j] = dp[i-1][j] + dp[i][j-1];

		return dp[rows-1][cols-1];
	}

	public static void main(String[] args) {
		M_0063_UniquePaths2 obj = new M_0063_UniquePaths2();
		int[][] obstacleGrid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}
}
