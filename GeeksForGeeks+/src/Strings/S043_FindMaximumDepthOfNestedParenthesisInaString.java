package Strings;
/*
 * http://www.geeksforgeeks.org/find-maximum-depth-nested-parenthesis-string/
 * Time Complexity : O(n)
 * Auxiliary Space : O(1)
 * 
 */
public class S043_FindMaximumDepthOfNestedParenthesisInaString {

	// function takes a string and returns the maximum depth nested parenthesis
	public int maxDepth(String S){
		
	    int current_max = 0; // current count
	    int max = 0;    // overall maximum count
	    int n = S.length();
	 
	    // Traverse the input string
	    for (int i = 0; i< n; i++){
	        if (S.charAt(i) == '('){
	            current_max++;
	 
	            // update max if required
	            if (current_max> max)
	                max = current_max;
	        }
	        else if (S.charAt(i) == ')'){
	            if (current_max>0)
	                current_max--;
	            else
	                return -1;
	        }
	    }
	 
	    // finally check for unbalanced string
	    if (current_max != 0)
	        return -1;
	 
	    return max;
	}
	
	public static void main(String[] args) {
		S043_FindMaximumDepthOfNestedParenthesisInaString obj = new S043_FindMaximumDepthOfNestedParenthesisInaString();
		String s = "( ((X)) (((Y))) )";
	    System.out.println(obj.maxDepth(s));
	}
}
