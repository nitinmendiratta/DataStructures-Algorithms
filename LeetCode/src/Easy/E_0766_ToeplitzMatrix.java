package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class E_0766_ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int r = 1; r < matrix.length; ++r)
			for (int c = 1; c < matrix[0].length; ++c)
				if (matrix[r-1][c-1] != matrix[r][c])
					return false;
		return true;
	}
	public static void main(String[] args) {
		E_0766_ToeplitzMatrix obj = new E_0766_ToeplitzMatrix();
		int[][] image = new int[][] {
			{1,2,3,4},
			{5,1,2,3},
			{9,5,1,2}
		};
		System.out.println(obj.isToeplitzMatrix(image));
	}
}
