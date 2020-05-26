package Easy;
/*
 * https://leetcode.com/problems/valid-boomerang/
 */
public class E_1037_ValidBoomerang {

	/*	if slopes of lines with any two point will be same, then they are co-linear. so check slope is diff
		i.e.
		y2−y1/x2−x1 = y3−y1/x3−x1
	*/
	public boolean isBoomerang(int[][] p) {
		return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
	}
	public static void main(String[] args) {
		E_1037_ValidBoomerang obj = new E_1037_ValidBoomerang();
		System.out.println(obj.isBoomerang(new int[][] {
			{1,1},
			{2,3},
			{3,2}
		}));
	}
}
