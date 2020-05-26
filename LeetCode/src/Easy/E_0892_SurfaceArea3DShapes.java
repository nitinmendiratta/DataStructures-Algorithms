package Easy;
/*
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class E_0892_SurfaceArea3DShapes {

	/*
	 * 	For each tower, its surface area is 4 * v + 2
		However, 2 adjacent tower will hide the area of connected part.
		The hidden part is min(v1, v2) and we need just minus this area * 2

		Time Complexity:
		O(N^2)
	 */
	public int surfaceArea(int[][] grid) {
		int res = 0, n = grid.length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] > 0) res += grid[i][j] * 4 + 2;
				if (i > 0) res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
				if (j > 0) res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_0892_SurfaceArea3DShapes obj = new E_0892_SurfaceArea3DShapes();
		int[][] grid = new int[][] {
			{1,1,1},{1,0,1}, {1,1,1}
		};
		System.out.println(obj.surfaceArea(grid));
	}
}
