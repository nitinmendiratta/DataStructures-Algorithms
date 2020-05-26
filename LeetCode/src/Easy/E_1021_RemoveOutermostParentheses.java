package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/remove-outermost-parentheses/
 */
public class E_1021_RemoveOutermostParentheses {

	
	/* optimized, no stack
	 * 	opened count the number of opened parenthesis.
		Add every char to the result,
		until the first left parenthesis, and the last right parenthesis.
		
		Time Complexity:
		O(N) Time, O(N) space
	 */
	public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
	
	// using extra memory
	public String removeOuterParenthesesMyApproach(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        Stack<Character> stck = new Stack<Character>();
        
        for(int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	sb.append(c);
        	
        	if(!stck.isEmpty() && stck.peek() == '(' && c == ')') {
        		stck.pop();
        	}else {
        		stck.push(c);
        	}
        	if(stck.isEmpty()) {
        		// we found primitive pair
        		sb.deleteCharAt(start);
        		sb.deleteCharAt(sb.length()-1);
        		start = sb.length();
        	}
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		E_1021_RemoveOutermostParentheses obj = new E_1021_RemoveOutermostParentheses();
		System.out.println(obj.removeOuterParentheses("(()())(())")); // "()()()"
		System.out.println(obj.removeOuterParentheses("(()())(())(()(()))")); // "()()()()(())"
		System.out.println(obj.removeOuterParentheses("()()"));
	}
}
