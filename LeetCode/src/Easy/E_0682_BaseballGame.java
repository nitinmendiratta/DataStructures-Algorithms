package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/baseball-game/
 */
public class E_0682_BaseballGame {

	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack();

		for(String op : ops) {
			if (op.equals("+")) {
				int top = stack.pop();
				int newtop = top + stack.peek();
				stack.push(top);
				stack.push(newtop);
			} else if (op.equals("C")) {
				stack.pop();
			} else if (op.equals("D")) {
				stack.push(2 * stack.peek());
			} else {
				stack.push(Integer.valueOf(op));
			}
		}

		int ans = 0;
		for(int score : stack) ans += score;
		return ans;
	}
	public static void main(String[] args) {
		E_0682_BaseballGame obj = new E_0682_BaseballGame();
		String[] ops = new String[] {"5","2","C","D","+"};
		System.out.println(obj.calPoints(ops));
	}
}
