package Helper;

// A more optimised approach: based on Quick Union Ranking
public class UnionFindRank {
	int[] parents;
	int[] ranks;
	public int setCount = 0;

	public UnionFindRank(char[][] board) {
		int rows = board.length, cols = board[0].length;
		int n = rows * cols + 1;
		setCount = rows * cols;
		parents = new int[n];
		ranks = new int[n];
		for (int i = 0; i < n; i++)
			parents[i] = i;
	}

	public int find(int x) {
		if (x != parents[x])
			x = find(parents[x]);
		return parents[x];
	}

	public void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			if (ranks[px] > ranks[py]) {
				parents[py] = px;
				ranks[px]++;
			} else {
				parents[px] = py;
				ranks[py]++;
			}
			setCount--;
		}
	}
}

// Basic Union Find
class UnionFind {

	int[] parents;

	public UnionFind(char[][] board) {

		int rows = board.length, cols = board[0].length;
		parents = new int[rows * cols + 1];

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (board[x][y] == 'O') {
					int id = x * cols + y;
					parents[id] = id;
				}
			}
		}
		parents[rows * cols] = rows * cols;
	}

	public int find(int x) {

		if (x != parents[x])
			x = find(parents[x]);
		return parents[x];
	}

	public void union(int x, int y) {

		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parents[rootX] = rootY;
		}
	}
}
