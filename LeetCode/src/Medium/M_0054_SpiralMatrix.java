package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/spiral-matrix/
 */
public class M_0054_SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0) return res;
		
		int n = matrix.length, m = matrix[0].length;
		int left = 0, right = m-1, bottom = n-1, top = 0;

		while (top <= bottom && left <= right) {

			for(int i = left; i <= right; i++)	res.add(matrix[left][i]);

			for(int i = top+1; i <= bottom; i++)	res.add(matrix[i][right]);

			if(top < bottom && left < right){
				for(int i = right-1; i > left; i--)	res.add(matrix[bottom][i]);

				for(int i = bottom; i > top; i--)	res.add(matrix[i][top]);
			}

			top++;
			bottom--;
			left++;
			right--;
		}
		return res;
	}
	public static void main(String[] args) {
		M_0054_SpiralMatrix obj = new M_0054_SpiralMatrix();
		int[][] grid = new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		//int[][] grid = new int[][] {{1, 2, 3},{4,5,6},{7,8,9}};
		//int[][] grid = new int[][] {{3,2},{1,0}};
		System.out.println(obj.spiralOrder(grid));
	}
}
