package Strings;
/*
 * http://www.geeksforgeeks.org/smallest-palindrome-replacement/
 */
public class S109_SmallestPalindromeAfterReplacement {

	// Utility method to check str is possible palindrome after ignoring .
	public static boolean isPossiblePalindrome(String str){
		
	    int n = str.length();
	    for (int i=0; i<n/2; i++){
	        /* If both left and right character are not dot and they are not equal also, then it
	           is not possible to make this String a palindrome   
           */
	        if (str.charAt(i) != '.' &&
	            str.charAt(n-i-1) != '.' && str.charAt(i) != str.charAt(n-i-1))
	            return false;
	    }
	    return true;
	}
	 
	// Returns lexicographically smallest palindrom String, if possible
	public static String smallestPalindrome(String inStr){
	    if (!isPossiblePalindrome(inStr))
	        return "Not Possible";
	    
	    char[] str = inStr.toCharArray();
	    int n = str.length;
	 
	    //  loop through character of String
	    for (int i = 0; i < n; i++){
	        if (str[i] == '.'){
	            // if one of character is dot, replace dot
	            // with other character
	            if (str[n - i - 1] != '.')
	                str[i] = str[n - i - 1];
	 
	            // if both character are dot, then replace
	            // them with smallest character 'a'
	            else
	                str[i] = str[n - i - 1] = 'a';
	        }
	    }
	 
	    //  return the result
	    return new String(str);
	}
	public static void main(String[] args) {
		String str = "ab..e.c.a";
	    System.out.println(smallestPalindrome(str));
	}
}
