package Strings;
/*
 * http://www.geeksforgeeks.org/count-characters-position-english-alphabets/
 */
public class S115_CountCharactersAtSamePosAsInEnglishAlphabets {

	public static int findCount(String str){
	    int result = 0;
	 
	    // Travers input String
	    for (int i = 0 ; i < str.length(); i++)
	 
	        // Check that index of characters of String is
	        // same as of English alphabets by using ASCII
	        // values and the fact that all lower case
	        // alphabatic characters come together in same
	        // order in ASCII table.  And same is true for upper case.
	        if (i == (str.charAt(i) - 'a') || i == (str.charAt(i) - 'A'))
	            result++;
	 
	 
	    return result;
	}

	public static void main(String[] args) {
		String str = "AbgdeF";
	    System.out.println(findCount(str));
	}
}
