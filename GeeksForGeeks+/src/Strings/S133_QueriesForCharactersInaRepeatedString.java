package Strings;
/*
 * http://www.geeksforgeeks.org/queries-for-characters-in-a-repeated-string/
 */
public class S133_QueriesForCharactersInaRepeatedString {

	// Print whether index i and j have same element or not.
	public static boolean query(String s, int i, int j){
	    int n = s.length();
	 
	    // Finding relative position of index i,j.
	    i %= n;
	    j %= n;
	 
	    // Checking is element are same at index i, j.
	    if(s.charAt(i) == s.charAt(j))
	    	 return true;
	    return false;
	}
	public static void main(String[] args) {
		System.out.println(query("geeksforgeeks", 0, 8));
		System.out.println(query("geeksforgeeks", 8, 13));
		System.out.println(query("geeksforgeeks", 6, 15));
	}
}
