package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class M_0150_EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stck = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];

			// we have an operator
			if ((str.charAt(0) > '9' || str.charAt(0) < '0') && str.length() == 1){
				int b = stck.pop();
				int a = stck.pop();
				if (str.equals("+"))
					stck.push(a + b);
				if (str.equals("-"))
					stck.push(a - b);
				if (str.equals("/"))
					stck.push(a/b);
				if (str.equals("*"))
					stck.push(a*b);
			} else {
				stck.push(Integer.parseInt(str));
			}
		}
		return stck.pop();
	}

	public static void main(String[] args) {
		M_0150_EvaluateReversePolishNotation obj = new M_0150_EvaluateReversePolishNotation();
		System.out.println(obj.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(obj.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(obj.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}
}
