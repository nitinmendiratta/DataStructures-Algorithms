package Strings;
/*
 * http://www.geeksforgeeks.org/remove-character-String-make-palindrome/
 */
public class S112_RemoveCharacterFromStringToMakeItPalindrome {

	// Utility method to check if substring from low to high is palindrome or not.
	static boolean isPalindrome(String str, int low, int high){
	    
		while (low < high){
	       if (str.charAt(low) != str.charAt(high))
	          return false;
	       low++;
	       high--;
	    }
	    return true;
	}
	 
	// This method returns -1 if it is not possible to make String
	// a palindrome. It returns -2 if String is already a palindrome.
	// Otherwise it returns index of character whose removal can
	// make the whole String palindrome.
	public static int possiblePalinByRemovingOneChar(String str){
	    //  Initialize low and right by both the ends of the String
	    int low = 0, high = str.length() - 1;
	 
	    //  loop untill low and high cross each other
	    while (low < high){
	        // If both characters are equal then move both pointer
	        // towards end
	        if (str.charAt(low) == str.charAt(high)){
	            low++;
	            high--;
	        }
	        else{
	            /*  If removing str[low] makes the whole String palindrome.
	                We basically check if substring str[low+1..high] is
	                palindrome or not. */
	            if (isPalindrome(str, low + 1, high))
	                return low;
	 
	            /*  If removing str[high] makes the whole String palindrome
	                We basically check if substring str[low+1..high] is
	                palindrome or not. */
	            if (isPalindrome(str, low, high-1))
	                return high;
	 
	            return -1;
	        }
	    }
	 
	    //  We reach here when complete String will be palindrome
	    //  if complete String is palindrome then return mid character
	    return -2;
	}
	
	public static void main(String[] args) {
		String str = "abcbea";
	    int idx = possiblePalinByRemovingOneChar(str);
	    if (idx == -1)
	        System.out.println("Not Possible ");
	    else if (idx == -2)
	        System.out.println("Possible without removing any character");
	    else
	        System.out.println("Possible by removing character at index "+idx);
	}
}
