package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M_0022_GenerateParentheses {

	// O(4^n/n*sqrt(n))
	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<String>();
		if(n < 2) return res;
		StringBuilder sb = new StringBuilder();
		sb.append("(");

		generateParenthesisHelper(res, sb, 1, 0, n);
		return res;
	}

	public void generateParenthesisHelper(List<String> res, StringBuilder sb, int openBracketCount, int closeBracketCount, int n) {

		if(sb.length() == n*2) {
			res.add(sb.toString());
			return;
		}

		if(openBracketCount != n) {
			sb.append("(");
			generateParenthesisHelper(res, sb, openBracketCount+1, closeBracketCount, n);
			sb.deleteCharAt(sb.length() - 1); // no need of this if you use a string and concatenate "("
		}
		if(closeBracketCount < openBracketCount) {
			sb.append(")");
			generateParenthesisHelper(res, sb, openBracketCount, closeBracketCount+1, n);
			sb.deleteCharAt(sb.length() - 1);
		}

	}
	public static void main(String[] args) {
		M_0022_GenerateParentheses obj = new M_0022_GenerateParentheses();
		List<String> res = obj.generateParenthesis(3);
		System.out.println(Arrays.toString(res.toArray()));
	}
}
