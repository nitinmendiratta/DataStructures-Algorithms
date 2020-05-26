package Stack_Queue;
// https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
import java.util.*;
public class S16_LengthOfLongestValidParenthesisSubstring {

	public int findMaxLen(String str){
	    int n = str.length();
	    char[] strArr = str.toCharArray();
	    
	    // Create a stack and push -1 as initial index to it.
	    Stack stk = new Stack();
	    stk.push(-1);
	 
	    // Initialize result
	    int result = 0;
	 
	    // Traverse all characters of given string
	    for (int i=0; i<n; i++){        // If opening bracket, push index of it
	        if (strArr[i] == '(')
	          stk.push(i);
	 
	        else // If closing bracket, i.e.,str[i] = ')'
	        {
	            // Pop the previous opening bracket's index
	            stk.pop();
	 
	            // Check if this length formed with base of
	            // current valid substring is more than max 
	            // so far
	            if (!stk.empty()){
	                result = Math.max(result, i - (int)stk.peek());
	            }
	 
	            // If stack is empty. push current index as 
	            // base for next valid substring (if any)
	            else{
	            	stk.push(i);
	            }
	        }
	    }
	 
	    return result;
	}
	 
	// Driver program
	public static void main(String[] args) {
		S16_LengthOfLongestValidParenthesisSubstring obj = new S16_LengthOfLongestValidParenthesisSubstring();
		String str = "((()()";
	    System.out.println(obj.findMaxLen(str));
	 
	    str = "()(()))))";
	    System.out.println(obj.findMaxLen(str));
	}
}
