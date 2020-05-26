package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/rotate-image/
 */
public class M_0048_RotateImage {

	/*
	 * clockwise rotate
	 * first swap the symmetry (i.e. transpose the matrix), then reverse each row
	 * 1 2 3     1 4 7     7 4 1
	 * 4 5 6  => 2 5 8  => 8 5 2
	 * 7 8 9     3 6 9     9 6 3
	 * 
	 * anti-clockwise rotate
	 * first swap the symmetry (i.e. transpose the matrix), then reverse each col
	 */
	public void rotate(int[][] image) {
		transposeImage(image);

		// reverse each row of the image
		for(int row = 0; row < image.length; row++) {
			int i = 0;
			int j = image[row].length - 1;
			while(i < j) {
				int tmp = image[row][i];
				image[row][i] = image[row][j];
				image[row][j] = tmp;
				i++;
				j--;
			}
		}
	}

	// Turns rows into cols and vice versa
	private void transposeImage(int[][] image) {
		for(int i = 0; i < image.length; i++) {
			for(int j = i + 1; j < image[i].length; j++) {
				int tmp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = tmp;
			}
		}
	}
	
	// Approach2: CTCI
	public static void rotateApproach2(int[][] matrix) {
		int n = matrix.length;
		
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	public static void main(String[] args) {
		M_0048_RotateImage obj = new M_0048_RotateImage();
		int[][] grid = new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		//int[][] grid = new int[][] {{3,2},{1,0}};
		obj.rotate(grid);
		for(int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}
}
