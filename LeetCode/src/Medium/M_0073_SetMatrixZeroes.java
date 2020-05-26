package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class M_0073_SetMatrixZeroes {

	// Time Complexity : O(M�N)
	// Space Complexity : O(1)
	public void setZeroes(int[][] matrix) {
		Boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {
			// Since first cell for both first row and first column is the same i.e. matrix[0][0]
			// We can use an additional variable for either the first row/column.
			// For this solution we are using an additional variable for the first column
			// and using matrix[0][0] for the first row.
			if (matrix[i][0] == 0) {
				isCol = true;
			}
			for (int j = 1; j < C; j++) {
				// If an element is zero, we set the first element of the corresponding row and column to 0
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// Iterate over the array once again and using the first row and first column, update the elements.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// See if the first row needs to be set to zero as well
		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}
		// See if the first column needs to be set to zero as well
		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	// Time Complexity: O(M�N) where M and N are the number of rows and columns respectively.
	// Space Complexity: O(M+N).
	public void setZeroesApproach2(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();

		// Essentially, we mark the rows and columns that are to be made zero
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		// Iterate over the array once again and using the rows and cols sets, update the elements.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		M_0073_SetMatrixZeroes obj = new M_0073_SetMatrixZeroes();
		int[][] grid = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		//int[][] grid = new int[][] {{3,2},{1,0}};
		obj.setZeroes(grid);
		for(int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}
}
