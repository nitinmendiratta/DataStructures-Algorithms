package Easy;
/*
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class E_1232_CheckStraightLine {

	// find slope from point 1 and point 2
	// compare the slopes of all other points wrt to the original slope
	//
	// Slope of points (x1, y1) and (x2, y2) is:
	// (y2 - y1) / (x2 - x1)
	//
	// Slope of points (x1, y1) and (x3, y3) is:
	// (y3 - y1) / (x3 - x1)
	//
	// for all three points to be on the same line, the slopes should be equal, in other words:
	// (x3 - x1)*(y2 - y1) = (y3 - y1)*(x2 - x1)
	//
	// to avoid running into divide by zero error, use multiplication to find slope
	public boolean checkStraightLine(int[][] arr) {
		if(arr == null || arr.length < 3 || arr[0].length == 0) return false;

		int[] p = arr[0];
		int[] q = arr[1];

		for(int i = 2; i < arr.length; i++) {
			int[] curr = arr[i];

			if((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0])) return false;
		}

		return true;
	}
	public static void main(String[] args) {
		E_1232_CheckStraightLine obj = new E_1232_CheckStraightLine();
		int[][] coordinates = new int[][] {
			{0,0},{2,0},{1,1},{2,1},{2,2}
		};
		System.out.println(obj.checkStraightLine(coordinates));
	}
}
