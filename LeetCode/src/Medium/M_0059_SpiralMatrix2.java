package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class M_0059_SpiralMatrix2 {

	public int[][] generateMatrix(int n) {
		int len = n*n;
		int[][] matrix = new int[n][n];

		
		int left = 0, right = n-1, bottom = n-1, top = 0, j = 1;

		while (j <= len) {

			for(int i = left; i <= right; i++, j++)	matrix[left][i] = j;

			for(int i = top+1; i <= bottom; i++, j++)	matrix[i][right] = j;
			
			if(top < bottom && left < right){
				for(int i = right-1; i > left; i--, j++)	matrix[bottom][i] = j;

				for(int i = bottom; i > top; i--, j++)	matrix[i][top] = j;
			}

			top++;
			bottom--;
			left++;
			right--;
		}
		return matrix;
	}
	public static void main(String[] args) {
		M_0059_SpiralMatrix2 obj = new M_0059_SpiralMatrix2();
		int[][] matrix = obj.generateMatrix(4);
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
