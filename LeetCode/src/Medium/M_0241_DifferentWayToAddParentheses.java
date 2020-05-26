package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class M_0241_DifferentWayToAddParentheses {

	// https://www.youtube.com/watch?v=TUopzVwpWDw
	public List<Integer> diffWaysToCompute(String input) {
		if (input.isEmpty())
			return null;

		return diffWaysToComputeHelper(input, 0, input.length() - 1);
	}

	public List<Integer> diffWaysToComputeHelper(String input, int L, int R) {
		List<Integer> res = new ArrayList();
		List<Integer> left, right;

		for (int i = L; i <= R; i++) {
			if (isOperator(input.charAt(i))) {
				left = diffWaysToComputeHelper(input, L, i - 1);
				right = diffWaysToComputeHelper(input, i + 1, R);
				for (int l : left) {
					for (int r : right) {
						res.add(cal(l, r, input.charAt(i)));
					}
				}
			}
		}

		// case when we dont have an operator at all in the input string
		if (res.size() == 0) {
			res.add(Integer.parseInt(input.substring(L, R + 1)));
		}
		return res;
	}

	private Integer cal(int l, int r, char operator) {
		if (operator == '+') {
			return l + r;
		} else if (operator == '-') {
			return l - r;
		} else {
			return l * r;
		}
	}

	private boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*';
	}

	public static void main(String[] args) {
		M_0241_DifferentWayToAddParentheses obj = new M_0241_DifferentWayToAddParentheses();
		System.out.println(obj.diffWaysToCompute("2-1-1"));
	}
}
