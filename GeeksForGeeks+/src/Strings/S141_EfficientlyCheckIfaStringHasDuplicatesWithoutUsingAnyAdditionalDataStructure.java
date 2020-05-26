package Strings;
/*
 * http://www.geeksforgeeks.org/efficiently-check-string-duplicates-without-using-additional-data-structure/
 * Time Complexity: O(n)
 * Auxiliary Space : O(1)
 */
public class S141_EfficientlyCheckIfaStringHasDuplicatesWithoutUsingAnyAdditionalDataStructure {

	// Returns true if all characters of str are
	// unique.
	// Assumptions : (1) str contains only characters
	//	                   from 'a' to 'z'
	//	             (2) integers are stored using 32
	//	                   bits
	public static boolean areChractersUnique(String str){
	    // An integer to store presence/absence of 26 characters using its 32 bits.
	    int checker = 0;
	 
	    for (int i = 0; i < str.length(); ++i){
	        int val = (str.charAt(i)-'a');
	 
	        // If bit corresponding to current character is already set
	        if ((checker & (1 << val)) > 0)
	            return false;
	 
	        // set bit in checker
	        checker |=  (1 << val);
	    }
	 
	    return true;
	}
	
	public static void main(String[] args) {
		System.out.println(areChractersUnique("aaabbccdaa"));
	}
}
