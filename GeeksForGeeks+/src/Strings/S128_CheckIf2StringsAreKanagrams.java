package Strings;
import java.util.HashMap;
/*
 * http://www.geeksforgeeks.org/check-two-Strings-k-anagrams-not/
 */
public class S128_CheckIf2StringsAreKanagrams {

	int MAX_CHAR = 26;
	// Function to check if str1 and str2 are k-anagram or not
	public static boolean areKAnagrams(String str1, String str2, int k){
	    // If both Strings are not of equal length then return false
	    int n = str1.length();
	    if (str2.length() != n)
	        return false;
	 
	    HashMap<Character,Integer> hash_str = new HashMap<Character,Integer>();
	    
	    // Store the occurrence of all characters in a hash_array
	    for (int i = 0; i < n ; i++)
	    	//int oldValue = ;
	        if(hash_str.get(str1.charAt(i)) != null){
	        	int oldValue = hash_str.get(str1.charAt(i));
	        	hash_str.put(str1.charAt(i), ++oldValue);
	        }else{
	        	hash_str.put(str1.charAt(i), 1);
	        }
	 
	    // Store the occurrence of all characters in a hash_array
	    int count = 0;
	    for (int i = 0; i < n ; i++){
	        if (hash_str.get(str2.charAt(i)) != null && hash_str.get(str2.charAt(i)) > 0){
	        	int oldValue = hash_str.get(str2.charAt(i));
	        	hash_str.put(str2.charAt(i), --oldValue);
	        }else
	            count++;
	 
	        if (count > k)
	            return false;
	    }
	 
	    // Return true if count is less than or equal to k
	    return true;
	}
	
	public static void main(String[] args) {
		String str1 = "geeks";
	    String str2 = "eggkf";
	    int k = 1;
	    System.out.println(areKAnagrams(str1, str2, k));
	}
}
