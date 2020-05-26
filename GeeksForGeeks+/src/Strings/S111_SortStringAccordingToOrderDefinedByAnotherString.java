package Strings;
/*
 * http://www.geeksforgeeks.org/sort-String-according-order-defined-another-String/
 */
public class S111_SortStringAccordingToOrderDefinedByAnotherString {

	// Sort str according to the order defined by pattern.
	public static String sortByPattern(String inStr, String pat){
		char[] str = inStr.toCharArray();
	    // Create a count array stor count of characters in str.
	    int count[] = new int[26];
	 
	    // Count number of occurrences of each character
	    // in str.
	    for (int i = 0 ; i < str.length; i++)
	        count[str[i] - 'a']++;
	 
	    // Traverse the pattern and print every characters
	    // same number of times as it appears in str. This 
	    // loop takes O(m + n) time where m is length of 
	    // pattern and n is length of str.
	    int index = 0;
	    for (int i = 0; i < pat.length(); i++)
	        for (int j = 0; j < count[pat.charAt(i) - 'a']; j++)
	            str[index++] = pat.charAt(i);
	    return new String(str);
	}
	public static void main(String[] args) {
		String pat = "wcyuogmlrdfphitxjakqvzbnes";
	    String str = "jcdokai";
	    System.out.println(sortByPattern(str, pat));
	}
}
