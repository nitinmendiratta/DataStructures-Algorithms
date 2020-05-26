package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class E_1030_MatrixCellsDistanceOrder {


	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] origin = new int[R * C][2];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// convert R*C to flat array
				origin[i * C + j] = new int[] {i, j};
			}
		}

		Arrays.sort(origin, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				// Manhattan distance, |r1 - r2| + |c1 - c2|
				int d1 = Math.abs(a[0] - r0) + Math.abs(a[1] - c0);
				int d2 = Math.abs(b[0] - r0) + Math.abs(b[1] - c0);
				return d1 - d2;
			}
		});
		return origin;
	}

	public int[][] allCellsDistOrderApproach2(int R, int C, int r0, int c0) {

		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean[][] visited = new boolean[R][C];
		int[][] result = new int[R * C][2];
		int i = 0;
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[]{r0, c0});

		while (!queue.isEmpty()) {

			int[] cell = queue.poll();
			int r = cell[0];
			int c = cell[1];

			if (visited[r][c]) {
				continue;
			}

			result[i++] = cell;
			visited[r][c] = true;

			// add all 4 cells around current processing cell
			for (int[] dir : dirs) {
				int rr = cell[0] + dir[0];
				int cc = cell[1] + dir[1];
				if (rr < 0 || rr >= R || cc < 0 || cc >= C) continue;
				queue.offer(new int[]{rr, cc});
			}
		}
		return result;
	}
	public static void main(String[] args) {
		E_1030_MatrixCellsDistanceOrder obj = new E_1030_MatrixCellsDistanceOrder();
		int[][] res = obj.allCellsDistOrderApproach2(2,3,1,2);
		for(int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
