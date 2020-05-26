package Easy;
/*
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class E_0883_ProjectionArea3DShapes {

	public int projectionArea(int[][] grid) {
		int r = grid.length, c = grid[0].length, area = 0;
				
		for(int i = 0; i < r; i++) {
			int maxRow = 0, maxCol = 0;
			for(int j = 0; j < c; j++) {
				if(grid[i][j] > 0) area++;
				maxRow = Math.max(maxRow, grid[i][j]); // highest value in reach row
				maxCol = Math.max(maxCol, grid[j][i]); // highest value in reach column
			}
			area += maxRow + maxCol;
		}
		return area;
	}
	public static void main(String[] args) {
		E_0883_ProjectionArea3DShapes obj = new E_0883_ProjectionArea3DShapes();
		int[][] grid = new int[][] {
			{1,1,1},{1,0,1}, {1,1,1}
		};
		System.out.println(obj.projectionArea(grid));
	}
}
