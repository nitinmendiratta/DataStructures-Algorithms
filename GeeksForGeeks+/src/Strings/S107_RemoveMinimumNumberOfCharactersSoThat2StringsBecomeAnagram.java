package Strings;
/*
 * http://www.geeksforgeeks.org/remove-minimum-number-characters-two-strings-become-anagram/
 * Time Complexity : O(n)
 * Auxiliary space : O(ALPHABET-SIZE)
 */
public class S107_RemoveMinimumNumberOfCharactersSoThat2StringsBecomeAnagram {

	// function to calculate minimum numbers of characters to be removed to make two strings anagram
	public static int remAnagram(String str1, String str2){
		int CHARS = 26;
	    // make hash array for both String and calculate
	    // frequency of each character
	    int count1[] = new int[CHARS];
	    int count2[] = new int[CHARS];
	 
	    // count frequency of each charcter in first String
	    for (int i=0; i<str1.length(); i++)
	        count1[str1.charAt(i)-'a']++;
	 
	    // count frequency of each charcter in second String
	    for (int i=0; i<str2.length(); i++)
	        count2[str2.charAt(i)-'a']++;
	 
	    // traverse count arrays to find number of charcters to be removed
	    int result = 0;
	    for (int i=0; i<26; i++)
	        result += Math.abs(count1[i] - count2[i]);
	    return result;
	}
	
	public static void main(String[] args) {
		String str1 = "bcadeh", str2 = "hea";
	    System.out.println(remAnagram(str1, str2));
	}
}
