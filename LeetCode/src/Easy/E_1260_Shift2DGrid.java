package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/shift-2d-grid/
 */
public class E_1260_Shift2DGrid {

	//https://www.youtube.com/watch?v=9hBcARSiU0s
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int r = grid.length, 
				c = grid[0].length; 
		int total = r*c;
		// convert 2d matrix to 1d array ie any index i,j of a 2d matrix is i*c + j in 1d array
		int start = total - k%total;

		LinkedList<List<Integer>> ans = new LinkedList<>();

		for (int i = start; i < total+start; ++i) {

			int moveIdx = i % total, // index that will be moved in 1D world
					// converting 1D array index back to 2D matrix
					moveRow = moveIdx / c, // ex: 1d index 8 is 2nd index which is 3rd row in 2d ie 8/3 = 2
					moveCol = moveIdx % c; // same for col 8%3 = 2

			// now we check whenever we are starting a new row that is a new list for result
			if ((i - start) % c == 0) {
				ans.add(new ArrayList<>());
			}
			// peeklast gets the last list in the result in which we add each row element
			ans.peekLast().add(grid[moveRow][moveCol]);
		}
		return ans;
	}
	public static void main(String[] args) {
		E_1260_Shift2DGrid obj = new E_1260_Shift2DGrid();
		int[][] grid = new int[][] {
			{1,2,3},{4,5,6},{7,8,9}
		};
		List<List<Integer>> res = obj.shiftGrid(grid, 1);
		for (List<Integer> l1 : res) {
			System.out.println(l1);
		} 
		System.out.println();
	}
}
