package Strings;
import java.util.Vector;
/*
 * http://www.geeksforgeeks.org/minimum-characters-added-front-make-String-palindrome/
 */
public class S119_MinCharactersToBeAddedAtFrontToMakeStringPalindrome {

	// returns vector lps for given String str
	public static Vector<Integer> computeLPSArray(String str){
		System.out.println(str);
	    int M = str.length();
	    Vector<Integer> lps = new Vector<Integer>();
	 
	    int len = 0;
	    lps.add(0, 0); // lps[0] is always 0
	 
	    // the loop calculates lps[i] for i = 1 to M-1
	    int i = 1;
	    while (i < M){
	        if (str.charAt(i) == str.charAt(len)){
	            len++;
	            lps.add(i,len);
	            i++;
	        }
	        else{ // (str[i] != str[len])        
	            // This is tricky. Consider the example.
	            // AAACAAAA and i = 7. The idea is similar
	            // to search step.
	            if (len != 0){
	                len = lps.get(len-1);
	                // Also, note that we do not increment i here
	            }
	            else{ // if (len == 0)
	                lps.add(i, 0);
	                i++;
	            }
	        }
	    }
	    return lps;
	}
	 
	// Method returns minimum character to be added at front to make String palindrome
	public static int getMinCharToAddedToMakeStringPalin(String str){
	    String revStr = new StringBuilder(str).reverse().toString();
	    
	 
	    // Get concatenation of String, special character and reverse String
	    String concat = str + "$" + revStr;
	 
	    //  Get LPS array of this concatenated String
	    Vector<Integer> lps = computeLPSArray(concat);
	 
	    // By subtracting last entry of lps vector from
	    // String length, we will get our result
	    return (str.length() - lps.get(lps.size()-1));
	}
	 
	public static void main(String[] args) {
		 String str = "AACECAAAA";
		 System.out.println(getMinCharToAddedToMakeStringPalin(str));
	}
}
