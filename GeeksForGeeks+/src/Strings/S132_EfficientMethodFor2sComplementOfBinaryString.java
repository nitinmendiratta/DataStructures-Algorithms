package Strings;
/*
 * http://www.geeksforgeeks.org/efficient-method-2s-complement-binary-String/
 */
public class S132_EfficientMethodFor2sComplementOfBinaryString {

	// Function to find two's complement
	public static String findTwoscomplement(String inStr){
		
	    int n = inStr.length();
	 
	    // Traverse the String to get first '1' from
	    // the last of String
	    int i;
	    for (i = n-1 ; i >= 0 ; i--)
	        if (inStr.charAt(i) == '1')
	            break;
	 
	    // If there exists no '1' concat 1 at the starting of String
	    if (i == 0)
	        return '1' + inStr;
	    
	    char str[] = inStr.toCharArray();
	 
	    // Continue traversal after the position of first '1'
	    for (int k = i-1 ; k >= 0; k--){
	        //Just flip the values
	        if (str[k] == '1')
	            str[k] = '0';
	        else
	            str[k] = '1';
	    }
	 
	    // return the modified String
	    return new String(str);
	}
	
	public static void main(String[] args) {
		String str = "00000101";
	    System.out.println(findTwoscomplement(str));
	}
}
