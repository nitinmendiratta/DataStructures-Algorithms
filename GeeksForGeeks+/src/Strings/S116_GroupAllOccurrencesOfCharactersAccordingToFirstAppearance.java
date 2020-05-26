package Strings;
/*
 * http://www.geeksforgeeks.org/group-occurrences-characters-according-first-appearance/
 */
public class S116_GroupAllOccurrencesOfCharactersAccordingToFirstAppearance {

	static int MAX_CHAR = 26;
	// Function to print the String
	public static String printGrouped(String str){
	    int n = str.length();
	    StringBuilder sb = new StringBuilder();
	    // Initialize counts of all characters as 0
	    int  count[] = new int[MAX_CHAR];
	 
	    // Count occurrences of all characters in String
	    for (int i = 0 ; i < n ; i++)
	        count[str.charAt(i)-'a']++;
	 
	    // Starts traversing the String
	    for (int i = 0; i < n ; i++){
	        // Print the character till its count in hash array
	        while (count[str.charAt(i)-'a']-- != 0)
	            sb.append(str.charAt(i));
	 
	        // Make this character's count value as 0.
	        count[str.charAt(i)-'a'] = 0;
	    }
	    return sb.toString();
	}
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		 
	    System.out.println(printGrouped(str));
	}
}
