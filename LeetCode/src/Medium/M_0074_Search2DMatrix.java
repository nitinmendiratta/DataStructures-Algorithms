package Medium;
/*
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class M_0074_Search2DMatrix {

	/*
	 * Convert 1D to 2D
	 * i: 1d array index, x = row index of 2d matrix, y = col index of 2d matrix
	 * x = i/numOfCols
	 * y = i%numOfCols
	 * 
	 * Convert 2D to 1D
	 * i: 1d array index, x = row index of 2d matrix, y = col index of 2d matrix
	 * i = (x*length_of_row) + y;
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		
		int rows = matrix.length, cols = matrix[0].length;
		int start = 0, end = rows*cols-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			int i = mid/cols, j = mid%cols;

			if(matrix[i][j] == target) {
				return true;
			}else if(matrix[i][j] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		M_0074_Search2DMatrix obj = new M_0074_Search2DMatrix();
		int[][] matrix = new int[][] {
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}};
			System.out.println(obj.searchMatrix(matrix, 12));
	}
}
