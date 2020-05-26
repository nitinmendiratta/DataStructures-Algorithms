package Strings;
/*
 * http://www.geeksforgeeks.org/lower-case-upper-case-interesting-fact/
 */
public class S077_LowerCaseToUpperCase {

	// Converts a String to uppercase
	public String toUpperApproach1(String in){
		char[] strArr = in.toCharArray();
	    for (int i = 0; i < in.length(); i++)
	          if ('a' <= in.charAt(i) && in.charAt(i) <= 'z')
	        	  strArr[i] = (char) (in.charAt(i) - 'a' + 'A');
	    return new String(strArr);
	}
	
	// Converts a String to uppercase
	/*Explanation: 
	The ASCII table is constructed in such way that the binary representation of lowercase letters is almost identical of 
	binary representation of uppercase letters. The only difference is the sixth bit, setted only for lowercase letters. 
	What that elegant function does is unset the bit of index 5 of in[i], consequently, making that character lowercase.
	*/
	public String toUpperApproach2(String in){
		char[] strArr = in.toCharArray();
	    for (int i = 0; i < in.length(); i++)
	          if ('a' <= in.charAt(i) && in.charAt(i) <= 'z')
	        	  strArr[i] = (char)(in.charAt(i) & ~(1 << 5));
	    return new String(strArr);
	}
	
	public static void main(String[] args) {
		S077_LowerCaseToUpperCase obj = new S077_LowerCaseToUpperCase();
		String str = "geeksforgeeks";
		System.out.println(obj.toUpperApproach1(str));
		System.out.println(obj.toUpperApproach2(str));
	}
}
