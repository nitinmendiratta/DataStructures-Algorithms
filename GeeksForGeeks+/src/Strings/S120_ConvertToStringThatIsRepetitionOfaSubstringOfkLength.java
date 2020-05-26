package Strings;
import java.util.*;
import java.util.Map.Entry;

/*
 * http://www.geeksforgeeks.org/convert-String-repetition-substring-k-length/
 */
public class S120_ConvertToStringThatIsRepetitionOfaSubstringOfkLength {

	// Returns true if str can be coverted to a String
	// with k repeated substrings after replacing k characters.
	public static boolean checkString(String str, int k){
	    // Length of String must be a multiple of k
	    int n = str.length();
	    if (n%k != 0)
	        return false;
	 
	    // Map to store strings of length k and their counts
	    HashMap<String, Integer> mp = new HashMap<String, Integer>();
	    for (int i=0; i<n; i+=k){

	    	if(mp.get(str.substring(i, i+k)) != null){
	    		int oldValue = mp.get(str.substring(i, i+k));
	    		mp.put(str.substring(i, i+k), ++oldValue);
	    	}else{
	    		mp.put(str.substring(i, i+k), 1);
	    	}
	    }
	        
	 
	    // If String is already a repition of k substrings, return true.
	    if (mp.size() == 1)
	        return true;
	 
	    // If number of distinct substrings is not 2, then
	    // not possible to replace a String.
	    if (mp.size() != 2)
	        return false;
	 
	    // One of the two distinct must appear exactly once.
	    // Either the first entry appears once, or it appears
	    // n/k-1 times to make other substring appear once.
	    Entry<String, Integer> entry = mp.entrySet().iterator().next();
	    String key= entry.getKey();
	    int value = entry.getValue();
	    //System.out.println(key+","+value);
	    if ((value == (n/k - 1)) || value == 1)
	       return true;
	 
	    return false;
	}
	
	public static void main(String[] args) {
		System.out.println(checkString("bdac", 2));
		System.out.println(checkString("abcbedabcabc", 3));
		System.out.println(checkString("bcacc", 3));
		System.out.println(checkString("bcacbcac", 2));
		System.out.println(checkString("bcdbcdabcedcbcd", 3));
	}
}
