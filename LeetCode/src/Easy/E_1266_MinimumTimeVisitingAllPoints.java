package Easy;
/*
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class E_1266_MinimumTimeVisitingAllPoints {

	public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] cur = points[i], prev = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;        
    }
	public static void main(String[] args) {
		E_1266_MinimumTimeVisitingAllPoints obj = new E_1266_MinimumTimeVisitingAllPoints();
		int[][] points = new int[][] {
			{1,1},{3,4},{-1,0}
		};
		System.out.println(obj.minTimeToVisitAllPoints(points));
	}
}
