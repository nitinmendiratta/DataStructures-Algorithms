package Strings;
/*
 * http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
 * Time Complexity: Time complexity of this problem depends on the implementation of strstr function.
 * If implementation of strstr is done using KMP matcher then complexity of the above program is (-)(n1 + n2) 
 * where n1 and n2 are lengths of strings. KMP matcher takes (-)(n) time to find a substrng in a string of 
 * length n where length of substring is assumed to be smaller than the string.
 */
public class S005_CheckIfStringsAreRotationsOfEachOther {

	/* Function checks if passed strings (str1 and str2) are rotations of each other */
	static boolean areRotations(String str1, String str2){
		// There lengths must be same and str2 must be 
		// a substring of str1 concatenated with str1.  
		return (str1.length() == str2.length()) &&
				((str1 + str1).indexOf(str2) != -1);
	}

	// Driver method
	public static void main (String[] args){
		String str1 = "AACD";
		String str2 = "ACBD";

		if (areRotations(str1, str2))
			System.out.println("Strings are rotations of each other");
		else
			System.out.printf("Strings are not rotations of each other");
	}
}
