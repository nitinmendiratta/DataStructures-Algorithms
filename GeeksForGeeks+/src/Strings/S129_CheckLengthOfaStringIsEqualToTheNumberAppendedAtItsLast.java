package Strings;
/*
 * http://www.geeksforgeeks.org/check-length-string-equal-number-appended-last/
 */
public class S129_CheckLengthOfaStringIsEqualToTheNumberAppendedAtItsLast {

	// Function to find if given number is equal to length or not
	public static boolean isequal(String str){
	    int n = str.length();
	 
	    // Traverse String from end and find the number stored at the end.
	    // x is used to store power of 10.
	    int num = 0, x = 1, i = n-1;
	    for (i=n-1; i>=0; i--){
	        if ('0' <= str.charAt(i) &&  str.charAt(i)  <= '9'){
	            num = (str.charAt(i) - '0')*x + num;
	            x = x * 10;
	        }
	        else break;
	    }
	 
	    // Check if number is equal to String length except
	    // that number's digits
	    return num == i+1;
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks13";
	    System.out.println(isequal(str));
	}
}
