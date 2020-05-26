package Strings;
/*
 * http://www.geeksforgeeks.org/pangram-checking/
 */
public class S068_PangramChecking {

	// Returns true if the string is pangram else false
	public boolean checkPangram (String str){
	    // Create a hash table to mark the characters
	    // present in the string
	    boolean[] mark = new boolean[26];
	 
	    // For indexing in mark[]
	    int index = 0;
	 
	    // Traverse all characters
	    for (int i=0; i<str.length(); i++){
	        // If uppercase character, subtract 'A'
	        // to find index.
	        if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
	            index = str.charAt(i) - 'A';
	 
	        // If lowercase character, subtract 'a'
	        // to find index.
	        else if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
	            index = str.charAt(i) - 'a';
	 
	        // Mark current character
	        mark[index] = true;
	    }
	 
	    // Return false if any character is unmarked
	    for (int i=0; i<=25; i++)
	        if (mark[i] == false)
	            return (false);
	 
	    // If all characters were present
	    return (true);
	}
	public static void main(String[] args) {
		S068_PangramChecking obj = new S068_PangramChecking();
		String str1 = "The quick brown fox jumps over the lazy dog";
		String str2 = "The quick brown fox jumps over the dog";

	   System.out.println(obj.checkPangram(str1));
	   System.out.println(obj.checkPangram(str2));
	}
}
