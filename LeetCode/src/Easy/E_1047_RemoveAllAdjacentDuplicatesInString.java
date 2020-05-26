package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class E_1047_RemoveAllAdjacentDuplicatesInString {

	public String removeDuplicates(String S) {
		char[] res = S.toCharArray();
		int len = S.length(), i = -1;

		for (int j = 0; j < len; j++) {

			if(i >= 0 && res[i] == res[j]) {
				// match and then again a match like abba
				i--;
			}
			else if(j < len-1 && res[j] == res[j+1]) {
				// match cur and next char
				j++;
			}else {
				// no match
				i++;
				res[i] = res[j];
			}
		}

		return new String(res, 0, i+1);
	}

	// using stack
	public String removeDuplicatesUsingStack(String S) {
		Stack<Character> stack = new Stack<>();
		for(char s : S.toCharArray()){
			if(!stack.isEmpty() && stack.peek() == s)
				stack.pop();
			else
				stack.push(s);
		}
		StringBuilder sb = new StringBuilder();
		for(char s : stack) sb.append(s);
		return sb.toString();
	}
	public static void main(String[] args) {
		E_1047_RemoveAllAdjacentDuplicatesInString obj = new E_1047_RemoveAllAdjacentDuplicatesInString();
		System.out.println(obj.removeDuplicates("daabbaccad"));
		System.out.println(obj.removeDuplicates("abbaca"));
		System.out.println(obj.removeDuplicates("abbbaca"));
	}
}
