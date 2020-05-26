package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/surrounded-regions/
 */
public class M_0130_SurroundedRegions {

	/*
	 * Approach1 Logical Thinking We aim to set all O's which doesn't locate at
	 * borders or connect to O at borders to X. We mark all O's at borders and apply
	 * DFS at each O at boarders to mark all O's connected to it. The un-marked O's
	 * ought to be set X.
	 * 
	 * Trick We search for invalid candidates (and exclude them) rather than search
	 * for valid candidates.
	 */
	boolean[][] visited;

	public void solve(char[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int rows = board.length, cols = board[0].length;
		visited = new boolean[rows][cols];

		// check first and last column
		for (int i = 0; i < rows; i++) {

			if (board[i][0] == 'O' && !visited[i][0]) {
				detectConnected(i, 0, board);
			}

			if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) {
				detectConnected(i, cols - 1, board);
			}
		}

		// check first and last row
		for (int j = 0; j < cols; j++) {

			if (board[0][j] == 'O' && !visited[0][j]) {
				detectConnected(0, j, board);
			}

			if (board[rows - 1][j] == 'O' && !visited[rows - 1][j]) {
				detectConnected(rows - 1, j, board);
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					board[i][j] = 'X';
				}
			}
		}
	}

	// function to set all nodes to visited true, if they are connected to 'O' on
	// the border
	private void detectConnected(int x, int y, char[][] board) {

		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != 'O') {
			return;
		}

		visited[x][y] = true;

		detectConnected(x + 1, y, board);
		detectConnected(x, y + 1, board);
		detectConnected(x - 1, y, board);
		detectConnected(x, y - 1, board);
	}

	/**********************
	 * Approach2: Union-Find
	 ********************/
	/*
	 * Approach2: https://leetcode.com/problems/surrounded-regions/discuss/167165/Java-Union-Find-with-Explanations
	 * We aim to find all 'O's such that it is on the
	 * border or it is connected to an 'O' on the border. If we regard 'O' mentioned
	 * above as a node (or an element), the problem becomes to find the connected
	 * components (or disjoint sets) connected to borders. So-called borders should
	 * also be represented as an element, so elements connected to it can be merged
	 * with it into a set. That's the usage of dummyBorder.
	 * 
	 * 		for O in board
				if O is on border
					union(dummyBorder, O)
				else
					for neighbour of O
						if (neighbour is 'O') 
							union(neighbour, O)
			                
			for each cell
				if cell is 'O' && (find(cel) != find(dummyBorder))
					flip
	 */
	private static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void solveApproach2(char[][] board) {

		if (board == null || board.length == 0) {
			return;
		}

		Helper.UnionFindRank disjointSets = new Helper.UnionFindRank(board);
		int rows = board.length, cols = board[0].length;
		int dummyBorder = rows * cols;

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (board[x][y] == 'O') {
					int borderO = x * cols + y;
					if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
						disjointSets.union(dummyBorder, borderO);
						continue;
					}
					for (int[] dir : directions) {
						int nx = x + dir[0];
						int ny = y + dir[1];
						if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && board[nx][ny] == 'O') {
							int neighbor = nx * cols + ny;
							disjointSets.union(borderO, neighbor);
						}
					}
				}
			}
		}

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (board[x][y] == 'O' && disjointSets.find(x * cols + y) != disjointSets.find(dummyBorder)) {
					board[x][y] = 'X';
				}
			}
		}

	}

	// based on Quick Union
	

	public static void main(String[] args) {
		M_0130_SurroundedRegions obj = new M_0130_SurroundedRegions();
		char[][] matrix = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		obj.solve(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		System.out.println();
		
		obj.solveApproach2(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
