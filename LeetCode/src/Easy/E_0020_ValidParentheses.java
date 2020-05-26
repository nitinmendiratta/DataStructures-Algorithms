package Easy;
import java.util.*;
/*
 * https://oj.leetcode.com/problems/valid-parentheses/
 */
public class E_0020_ValidParentheses {

	public boolean isValid(String s) {
		if(s == null) return true;
		int n = s.length(),i = 0;
		if(n == 1) return false;
		Stack<Character> stk = new Stack<Character>();
		
		while(i < n){
			char a = s.charAt(i);
			if(isOpeningParanthesis(a)) stk.push(a);
			else if(isClosingParanthesis(a) && !stk.isEmpty()){
				if(isPair(stk.peek(),a)) stk.pop();
				else return false;
			}
			else return false;
			i++;
		}
		if(stk.isEmpty()) return true;
		return false;
	}

	public boolean isPair(char a, char b){
		if(a == '(' && b == ')') return true;
		if(a == '{' && b == '}') return true;
		if(a == '[' && b == ']') return true;
		return false;
	}

	public boolean isOpeningParanthesis(char a){
		if(a == '(' || a == '{' || a == '[') return true;
		return false;
	}

	public boolean isClosingParanthesis(char a){
		if(a == ')' || a == '}' || a == ']') return true;
		return false;
	}

	public static void main(String[] args) {
		E_0020_ValidParentheses obj = new E_0020_ValidParentheses();
		System.out.println("Valid: "+(obj.isValid("[]")));
	}
}
