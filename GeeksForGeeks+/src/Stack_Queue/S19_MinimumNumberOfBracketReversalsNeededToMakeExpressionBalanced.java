package Stack_Queue;
// http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
import java.util.*;
public class S19_MinimumNumberOfBracketReversalsNeededToMakeExpressionBalanced {

	// Returns count of minimum reversals for making
	// expr balanced. Returns -1 if expr cannot be
	// balanced.
	public int countMinReversals(String input){
	    int len = input.length();
	    char[] expr = input.toCharArray();
	    // length of expression must be even to make
	    // it balanced by using reversals.
	    if(len%2 != 0)
	       return -1;
	 
	    // After this loop, stack contains unbalanced
	    // part of expression, i.e., expression of the
	    // form "}}..}{{..{"
	    Stack<Character> s = new Stack<Character>();;
	    for (int i=0; i<len; i++){
	        if (expr[i] == '}' && !s.empty()){
	            if (s.peek()=='{')
	                s.pop();
	            else
	                s.push(expr[i]);
	        }
	        else
	            s.push(expr[i]);
	    }
	 
	    // Length of the reduced expression
	    // red_len = (m+n)
	    int red_len = s.size();
	 
	    // count opening brackets at the end of
	    // stack
	    int n = 0;
	    while (!s.empty() && s.peek() == '{'){
	        s.pop();
	        n++;
	    }
	 
	    // return ceil(m/2) + ceil(n/2) which is
	    // actually equal to (m+n)/2 + n%2 when
	    // m+n is even.
	    return (red_len/2 + n%2);
	}
	 
	// Driver program to test above function
	public static void main(String[] args) {
		S19_MinimumNumberOfBracketReversalsNeededToMakeExpressionBalanced obj = new S19_MinimumNumberOfBracketReversalsNeededToMakeExpressionBalanced();
		String expr = "}{{}}{{{";
	    System.out.println(obj.countMinReversals(expr));
	}

}
