package Easy;
/*
 * https://leetcode.com/problems/range-addition-ii/
 */
public class E_0598_RangeAddition2 {

	/*
	 * Time complexity : O(x). Single traversal of all operations is done. x refers to the number of operations.
	 * Space complexity : O(1). No extra space is used.
	 */
	public int maxCount(int m, int n, int[][] ops) {
		for (int[] op: ops) {
			m = Math.min(m, op[0]);
			n = Math.min(n, op[1]);
		}
		return m * n;
	}
	public static void main(String[] args) {
		E_0598_RangeAddition2 obj = new E_0598_RangeAddition2();
		int[][] operations = {{2,2}, {3,3}};
		System.out.println(obj.maxCount(3, 3, operations));
	}
}
