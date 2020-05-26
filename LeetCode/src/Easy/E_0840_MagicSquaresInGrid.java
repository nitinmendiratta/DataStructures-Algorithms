package Easy;
/*
 * https://leetcode.com/problems/magic-squares-in-grid/
 */
public class E_0840_MagicSquaresInGrid {

	/*Assume a magic square:
		a1,a2,a3
		a4,a5,a6
		a7,a8,a9

		a2 + a5 + a8 = 15
		a4 + a5 + a6 = 15
		a1 + a5 + a9 = 15
		a3 + a5 + a7 = 15

		Accumulate all, then we have:
		sum(ai) + 3 * a5 = 60
		3 * a5 = 15
		a5 = 5

		The center of magic square must be 5.

		Another observation for other 8 numbers:
		The even must be in the corner, and the odd must be on the edge.
		And it must be in a order like "43816729" （clockwise or anticlockwise)
	 */
	public int numMagicSquaresInside(int[][] grid) {
		int res = 0;
		for(int i = 1; i < grid.length -1; i++){
			for(int j = 1; j < grid[0].length-1; j++) {
				if(grid[i][j] == 5){
					res += isMagic(i, j, grid) ? 1 : 0;
				}
			}
		}
		return res;
	}

	public boolean isMagic(int i, int j, int[][] grid) {
		String s = "" + grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] + grid[i+1][j] + grid[i+1][j-1] + grid[i][j-1];
		return "4381672943816729".contains(s) || "9276183492761834".contains(s);
	}

	// Approach 2
	public int numMagicSquaresInsideApproach2(int[][] grid) {
		int m = grid.length, n = grid[0].length, result = 0;
		for (int i = 0; i < m - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				if (isMagic(grid, i, j)) {
					result++;
				}
			}
		}
		return result;
	}
	private boolean isMagic(int[][] grid, int row, int col) {
		int[] record = new int[10];
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				// check for numbers are in between 1 and 9
				if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0) {
					return false;
				}
				record[grid[i][j]] = 1;
			}
		}
		// diagonal sum
		int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
		int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
		if (sum1 != sum2) {
			return false;
		}
		// row/column sum
		for (int i = 0; i < 3; i++) {
			if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
				return false;
			}
			if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		E_0840_MagicSquaresInGrid obj = new E_0840_MagicSquaresInGrid();
		int[][] matrix = new int[][] {
			{4,3,8,4},
			{9,5,1,9},
			{2,7,6,2}
		};
		System.out.println(obj.numMagicSquaresInside(matrix));
	}
}
