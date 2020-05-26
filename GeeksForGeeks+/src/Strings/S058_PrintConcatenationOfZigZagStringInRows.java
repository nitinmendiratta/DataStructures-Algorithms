package Strings;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 * Time Complexity: O(len) where len is length of input string.
 * Auxiliary Space: O(len)
 */
public class S058_PrintConcatenationOfZigZagStringInRows {

	// Prints concatenation of all rows of str's Zig-Zag fasion
	public void printZigZagConcat(String str, int n){
	    // Corner Case (Only one row)
	    if (n == 1){
	        System.out.println(str);      
	        return;
	    }   
	 
	    // Find length of string
	    int len = str.length();
	 
	    // Create an array of strings for all n rows
	    String strArr[] = new String[n];
	    Arrays.fill(strArr, "");
	    // Initialize index for array of strings arr[]
	    int row = 0;
	    boolean down = false; // True if we are moving down in rows, else false
	 
	    // Travers through given string
	    for (int i = 0; i < len; ++i){
	        // append current character to current row
	    	strArr[row] = strArr[row]+ str.charAt(i);
	 
	        // If last row is reached, change direction to 'up'
	        if (row == n-1)
	          down = false;
	 
	        // If 1st row is reached, change direction to 'down'
	        else if (row == 0)
	          down = true;
	 
	        // If direction is down, increment, else decrement
	        if(down)
	        	row++;
	        else
	        	row--;
	    }
	 
	    // Print concatenation of all rows
	    for (int i = 0; i < n; ++i)
	        System.out.print(strArr[i]);
	}
	public static void main(String[] args) {
		S058_PrintConcatenationOfZigZagStringInRows obj = new S058_PrintConcatenationOfZigZagStringInRows();
		String str = "GEEKSFORGEEKS";
	    int n = 3;
	    obj.printZigZagConcat(str, n);
	}

}
