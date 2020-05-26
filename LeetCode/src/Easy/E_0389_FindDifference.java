package Easy;
/*
 * https://leetcode.com/problems/find-the-difference/
 */
public class E_0389_FindDifference {

	public char findTheDifference(String s, String t) {
		int n = t.length();
		char c = t.charAt(n - 1);
		for (int i = 0; i < n - 1; ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		return c;
	}
	public static void main(String[] args) {
		E_0389_FindDifference obj = new E_0389_FindDifference();
		int[] input = new int[]{3,0,1};
		System.out.println(obj.findTheDifference("ABCD", "ABCDE"));
	}
}
