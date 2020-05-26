package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/assign-cookies/
 */
public class E_0455_AssignCookies {

	// Just assign the cookies starting from the child with less greediness to maximize the number of happy children .
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for(int j=0;i<g.length && j<s.length;j++) {
			if(g[i] <= s[j]) i++;
		}
		return i;
	}
	public static void main(String[] args) {
		E_0455_AssignCookies obj = new E_0455_AssignCookies();
		int[] g = new int[] {1,2,3};
		int[] s = new int[] {1,1};
		System.out.println(obj.findContentChildren(g, s));
	}
}
