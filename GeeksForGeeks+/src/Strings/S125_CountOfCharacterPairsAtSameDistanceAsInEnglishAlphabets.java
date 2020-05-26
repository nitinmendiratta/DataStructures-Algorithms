package Strings;
/*
 * http://www.geeksforgeeks.org/count-characters-string-distance-english-alphabets/
 * Time complexity is O(n)
 */
public class S125_CountOfCharacterPairsAtSameDistanceAsInEnglishAlphabets {

	// Function to count pairs with distance equal to English alphabet distance
	public static int countPairs(String str){
	    int result = 0;
	    int n = str.length();
	 
	    for (int i=0; i<n ; i++)
	 
	        // This loop runs at most 26 times
	        for (int j=1; (i+j)<n && j<=26; j++)
	            if ((Math.abs(str.charAt(i+j) - str.charAt(i)) == j))
	                result++;
	 
	    return result;
	}
	
	public static void main(String[] args) {
	    System.out.println(countPairs("geeksforgeeks"));
	}
}
