package Medium;
/*
 * https://leetcode.com/problems/unique-paths/
 */
public class M_0062_UniquePaths {

	// https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
	// https://leetcode.com/problems/unique-paths/discuss/23230/Java-DP-with-O(n)-space
	public int uniquePaths(int cols, int rows) {
        int[] dp = new int[cols];
                
        for(int i = 0;i < cols; i++)
            dp[i] = 1;            
        
        // the 1 d array stores the previous col and updates in every col
        // for eg a 3*3 matrix arr[1,1,1] -> [1,2,3] -> [1,3,6] and finally return 6
        for(int i = 1;i < rows; i++){
            for(int j = 1; j < cols; j++)
                dp[j] = dp[j-1] + dp[j];
        } 
        return dp[cols-1];
    }
	
	public int uniquePathsDP(int cols, int rows) {
		int[][] dp = new int[rows][cols];

		// initialise first col with 1
		for(int row = 0; row < rows; row++)
			dp[row][0] = 1;

		// initialise first row with 1
		for(int col = 0; col < cols; col++)
			dp[0][col] = 1;

		for(int i = 1; i < rows; i++)
			for(int j = 1; j < cols; j++)
				// Since the robot can only move right and down, when it arrives at a point, it either arrives from left or above.
				dp[i][j] = dp[i-1][j] + dp[i][j-1];

		return dp[rows-1][cols-1];
	}

	// MyApproach:Top-down Recursive DP
	public int uniquePathsDPRecursive(int m, int n) {
		int[][] dp = new int[m][n];
		dp[m-1][n-1] = 1;
		return uniquePathsHelper(m, n, 0, 0, dp);
	}

	public int uniquePathsHelper(int m, int n, int currX, int currY, int[][] dp) {
		if(currX == m || currY == n) return 0;

		if(dp[currX][currY] != 0) {
			return dp[currX][currY];
		}
		int pathX = uniquePathsHelper(m , n, currX+1, currY, dp);
		int pathY = uniquePathsHelper(m , n, currX, currY+1, dp);
		dp[currX][currY] = pathX + pathY;

		return dp[currX][currY];	
	}
	public static void main(String[] args) {
		M_0062_UniquePaths obj = new M_0062_UniquePaths();
		System.out.println(obj.uniquePaths(3, 2));
	}
}
