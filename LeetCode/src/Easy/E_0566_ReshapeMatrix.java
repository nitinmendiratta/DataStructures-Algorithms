package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class E_0566_ReshapeMatrix {

	/*
	 * Time complexity : O(m*n). We traverse the entire matrix of size m*n
	 * once only. Here, m and n refers to the number of rows and columns in the
	 * given matrix.
	 * 
	 * Space complexity : O(m*n). The resultant matrix of size m*n is used.
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int ir = nums.length, ic = nums[0].length, m = 0, n = 0;
		if(r*c != ir*ic) {
			return nums;
		}
		int[][] output = new int[r][c];
		for(int i = 0; i < ir; i++) {
			for(int j = 0; j < ic; j++) {
				output[m][n] = nums[i][j];
				n++;
				if(n == c){
					m++;
					n = 0;
				}
			}
		}
		return output;
	}
	public static void main(String[] args) {
		E_0566_ReshapeMatrix obj = new E_0566_ReshapeMatrix();
		int[][] input = {{1,2}, {3,4}};
		int[][] output = obj.matrixReshape(input, 4, 1);
		for(int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
