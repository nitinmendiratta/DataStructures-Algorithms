package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class M_0227_BasicCalculator2 {

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.trim();

		long prevNum = 0;
		int sum = 0;
		char prevOp = '+';

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ')
				continue;
			if (Character.isDigit(c)) {
				int val = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				if (prevOp == '+') {
					sum += prevNum;
					prevNum = val;
				} else if (prevOp == '-') {
					sum += prevNum;
					prevNum = -val;
				} else if (prevOp == '*') {
					prevNum = prevNum * val;
				} else if (prevOp == '/') {
					prevNum = prevNum / val;
				}
			} else {
				prevOp = c;
			}
		}

		sum += prevNum;
		return sum;
	}

	// With stack
	// https://www.youtube.com/watch?v=kSaU_pI4SC8
	public int calculateApproach2(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	public static void main(String[] args) {
		M_0227_BasicCalculator2 obj = new M_0227_BasicCalculator2();
		System.out.println(obj.calculate("3+2*2"));
		System.out.println(obj.calculate("3/2"));
		System.out.println(obj.calculate("3+5/2"));
		System.out.println(obj.calculate("10*5/2"));
	}
}
