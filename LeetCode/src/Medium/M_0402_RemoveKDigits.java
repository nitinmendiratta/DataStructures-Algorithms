package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/remove-k-digits/
 */
public class M_0402_RemoveKDigits {

	// using stack
	public String removeKdigits(String num, int k) {
		int len = num.length();
		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			char curr = num.charAt(i);
			// whenever meet a digit which is less than the previous digit,
			// discard the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > curr) {
				stack.pop();
				k--;
			}
			stack.push(curr);
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
	
	
	// without stack 
	public String removeKdigitsApproach2(String num, int k) {
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < num.length(); i++) {
			char cur = num.charAt(i);

			// whenever meet a digit which is less than the previous digit,
			// discard the previous one
			while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > cur) {
				res.deleteCharAt(res.length() - 1);
				k--;
			}

			// ignore all the 0 at the head
			if (res.length() == 0 && cur == '0')
				continue;
			res.append(cur);
		}

		// corner case like "1111"
		while (k > 0 && res.length() > 0) {
			k--;
			res.deleteCharAt(res.length() - 1);
		}

		return res.length() == 0 ? "0" : res.toString();
	}

	public static void main(String[] args) {
		M_0402_RemoveKDigits obj = new M_0402_RemoveKDigits();
		System.out.println(obj.removeKdigits("1432219", 3));
		System.out.println(obj.removeKdigits("10200", 1));
		System.out.println(obj.removeKdigits("10", 2));
		System.out.println(obj.removeKdigits("157314", 2));
	}
}
