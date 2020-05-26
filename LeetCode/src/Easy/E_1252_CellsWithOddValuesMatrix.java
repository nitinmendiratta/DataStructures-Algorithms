package Easy;
/*
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class E_1252_CellsWithOddValuesMatrix {

	//Count the rows and columns that appear odd times;
	//Traverse all cells to get the answer.
	
	public int oddCells(int n, int m, int[][] indices) {
		boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
		for (int[] idx : indices) {
			oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
			oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
		}
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				// true^true = odd ie even+even = even
				cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
			}
		}
		return cnt;
	}

	// my approach
	public int oddCellsMyApproach(int n, int m, int[][] indices) {
		int[][] matrix = new int[n][m];
		int res = 0;

		for (int i = 0; i < indices.length; i++) {
			int r = indices[i][0], c = indices[i][1];
			int idx = 0;
			// increment row
			while(idx < m) {
				matrix[r][idx]++;
				if(matrix[r][idx]%2 != 0) res++;
				else res--;
				idx++;
			}
			idx = 0;
			// increment column
			while(idx < n) {
				matrix[idx][c]++;
				if(matrix[idx][c]%2 != 0) res++;
				else res--;
				idx++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_1252_CellsWithOddValuesMatrix obj = new E_1252_CellsWithOddValuesMatrix();
		int[][] indices = new int[][] {
			{0,1},{1,1}
		};
		System.out.println(obj.oddCells(2, 3, indices));
	}
}
