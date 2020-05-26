package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
 * TODO: NOT WORKING
 */
public class S067_GenerateAllBinaryStringsFromGivenPattern {

	public void approach1(String str, int index){
		if (index == str.length()){
	        System.out.println(str);
	        return;
	    }
	 
	    if (str.charAt(index) == '?'){
	        // replace '?' by '0' and recurse
	        //str[index] = '0';
	        approach1(str, index + 1);
	 
	        // replace '?' by '1' and recurse
	        //str[index] = '1';
	        approach1(str, index + 1);
	 
	        // No need to backtrack as string is passed
	        // by value to the function
	    }
	    else
	    	approach1(str, index + 1);
	}
	// Iterative function to generate all binary strings
	// formed by replacing each wildcard character by 0 or 1
	public void approach2(String str){
	    Queue<char[]> q = new LinkedList<char[]>();
	    q.add(str.toCharArray());
	 
	    while (!q.isEmpty()){
	    	char[] top = q.peek();

	        // find position of first occurrence of wildcard
	        int index = new String(top).indexOf('?');
	 
	        // If no matches were found, find returns string::npos
	        if(index != -1){
	            // replace '?' by '0' and push string into queue
	        	top[index] = '0';
	            q.add(top);
	 
	            // replace '?' by '1' and push string into queue
	            top[index] = '1';
	            q.add(top);
	        }
	 
	        else
	            // If no wildcard characters are left, print the string.
	            System.out.println(new String(top));
	 
	        q.poll();
	    }
	    //return top.toString();
	}
	 
	public static void main(String[] args) {
		S067_GenerateAllBinaryStringsFromGivenPattern obj = new S067_GenerateAllBinaryStringsFromGivenPattern();
		String str = "1??0?101"; 
	    obj.approach1(str, 0);
	}
}
