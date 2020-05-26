package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/number-of-islands/
 */
public class M_0200_NumberOfIslands {

	// DFS
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfsFill(grid, i, j);
					count++;
				}
			}
		return count;
	}

	private void dfsFill(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '0';
			dfsFill(grid, i + 1, j);
			dfsFill(grid, i - 1, j);
			dfsFill(grid, i, j + 1);
			dfsFill(grid, i, j - 1);
		}
	}

	// BFS
	public int numIslandsApproach2(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfsFill(grid, i, j);
					count++;
				}
			}
		return count;
	}

	private void bfsFill(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		int n = grid.length;
		int m = grid[0].length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int code = x * m + y;
		queue.offer(code);
		while (!queue.isEmpty()) {
			code = queue.poll();
			int i = code / m;
			int j = code % m;
			if (i > 0 && grid[i - 1][j] == '1') // search upward and mark adjacent '1's as '0'.
			{
				queue.offer((i - 1) * m + j);
				grid[i - 1][j] = '0';
			}
			if (i < n - 1 && grid[i + 1][j] == '1') // down
			{
				queue.offer((i + 1) * m + j);
				grid[i + 1][j] = '0';
			}
			if (j > 0 && grid[i][j - 1] == '1') // left
			{
				queue.offer(i * m + j - 1);
				grid[i][j - 1] = '0';
			}
			if (j < m - 1 && grid[i][j + 1] == '1') // right
			{
				queue.offer(i * m + j + 1);
				grid[i][j + 1] = '0';
			}
		}
	}

	// Union Find
	public int numIslandsApproach3(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		Helper.UnionFindRank disjointSets = new Helper.UnionFindRank(grid);
		int rows = grid.length, cols = grid[0].length, zeros = 0;
		int[][] directions = { { 0, 1 }, { 1, 0 } }; // only check forward and downward directions

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '0') {
					zeros++;
					continue;
				}
				for (int[] d : directions) {
					int x = i + d[0];
					int y = j + d[1];
					if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
						int id1 = i * cols + j;
						int id2 = x * cols + y;
						disjointSets.union(id1, id2);
					}

				}
			}
		}
		return disjointSets.setCount - zeros;
	}

	public static void main(String[] args) {
		M_0200_NumberOfIslands obj = new M_0200_NumberOfIslands();
		char[][] matrix1 = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };

		char[][] matrix2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

		//System.out.println(obj.numIslands(matrix1));
		//System.out.println(obj.numIslandsApproach2(matrix1));
		System.out.println(obj.numIslandsApproach3(matrix1));
		System.out.println();
		//System.out.println(obj.numIslands(matrix2));
		//System.out.println(obj.numIslandsApproach2(matrix2));
		System.out.println(obj.numIslandsApproach3(matrix2));
	}

}
