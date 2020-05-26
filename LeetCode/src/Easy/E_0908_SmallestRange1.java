package Easy;
/*
 * https://leetcode.com/problems/smallest-range-i/
 */
public class E_0908_SmallestRange1 {

	public int smallestRangeI(int[] A, int K) {
		int min = A[0], max = A[0];
		for (int x: A) {
			min = Math.min(min, x);
			max = Math.max(max, x);
		}
		return Math.max(0, max - min - 2*K);
	}
	public static void main(String[] args) {
		E_0908_SmallestRange1 obj = new E_0908_SmallestRange1();
		System.out.println(obj.smallestRangeI(new int[] {1,3,6}, 3));
	}
}
