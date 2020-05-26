package Easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/transpose-matrix/
 */
public class E_0867_TransposeMatrix {

	public int[][] transpose(int[][] A) {
		int[][] res = new int[A[0].length][A.length];

		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				res[j][i] = A[i][j];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_0867_TransposeMatrix obj = new E_0867_TransposeMatrix();

		int[][] matrix = new int[][]{
			{1,2,3},{4,5,6},{7,8,9}
		};
		int[][] output = obj.transpose(matrix);
		for(int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}

}
