package Strings;
/*
 * http://www.geeksforgeeks.org/count-words-whose-th-letter-either-1-th-th-i1-th-letter-given-word/
 * Time complexity : O(length of string).
 */
public class S140_CountOfWordsWhoseithLetterIsEither {

	// Return the count of words.
	public static int countWords(String str){
	    int count = 1;
	    int len = str.length();
	    // If word contain single letter, return 1.
	    if (len == 1)
	        return count;
	 
	    // Checking for first letter.
	    if (str.charAt(0) == str.charAt(1))
	        count *= 1;
	    else
	        count *= 2;
	 
	    // Traversing the string and multiplying for combinations.
	    for (int j=1; j<len-1; j++){
	        // If all three letters are same.
	        if (str.charAt(j) == str.charAt(j-1) && str.charAt(j) == str.charAt(j+1))
	            count *= 1;
	 
	        // If two letter are distinct.
	        else if (str.charAt(j) == str.charAt(j-1) || str.charAt(j) == str.charAt(j+1) || str.charAt(j-1) == str.charAt(j+1))
	            count *= 2;
	 
	        // If all three letter are distinct.
	        else
	            count *= 3;
	    }
	 
	    // Checking for last letter.
	    if (str.charAt(len-1) == str.charAt(len -2))
	        count *= 1;
	    else
	        count *= 2;
	 
	    return count;
	}
	public static void main(String[] args) {
		System.out.println(countWords("abc"));
	}

}
