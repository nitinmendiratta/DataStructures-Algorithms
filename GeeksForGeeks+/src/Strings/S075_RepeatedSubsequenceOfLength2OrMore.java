package Strings;
/*
 * http://www.geeksforgeeks.org/repeated-subsequence-length-2/
 * GOOGLE INTERVIEW 10 INSTEAD OF 2
 * O(n) time and space approach
 */
public class S075_RepeatedSubsequenceOfLength2OrMore {

	int MAX_CHAR = 256;
	// A function to check if a string str is palindrome
	public boolean isPalindrome(char str[], int l, int h){
	    // l and h are leftmost and rightmost corners of str
	    // Keep comparing characters while they are same
	    while (h > l)
	        if (str[l++] != str[h--])
	            return false;
	 
	    return true;
	}
	 
	public boolean check(String in){
	    // Find length of input string
		char[] str = in.toCharArray();
	    int n = str.length;		
	 
	    // Create an array to store all characters and their frequencies in str[]
	    int freq[] = new int[MAX_CHAR];
	 
	    // Traverse the input string and store frequencies
	    // of all characters in freq[] array.
	    for (int i = 0; i < n; i++){
	        freq[str[i]]++;
	 
	        // If the character count is more than 3 we found a repetition eg: AAA
	        if (freq[str[i]] >= 3)
	            return true;
	    }
	 
	    // In-place remove non-repeating characters from the string
	    int k = 0;
	    for (int i = 0; i < n; i++)
	        if (freq[str[i]] > 1)
	            str[k++] = str[i];
	    
	    // in case there is no repetition
	    if(k != n){
	    	str[k] = '\0';
	    }
	    System.out.println(new String(str));
	    // check if the resultant string is palindrome
	    if (isPalindrome(str, 0, k-1)){
	        // special case - if length is odd return true if the middle characer is same as previous one
	    	//eg for 
//	        if ((k & 1) == 1){
//	        	System.out.println("special case");
//	            return str[k/2] == str[k/2 - 1];
//	        }
	 
	        // return false if string is a palindrome
	        return false;
	    }
	 
	    // return true if string is not a palindrome
	    return true;
	}
	public static void main(String[] args) {
		S075_RepeatedSubsequenceOfLength2OrMore obj = new S075_RepeatedSubsequenceOfLength2OrMore();
		String str = "ABBA";
		 
	    if (obj.check(str))
	        System.out.println("Repeated Subsequence Exists");
	    else
	        System.out.println("Repeated Subsequence Doesn't Exists");
	 
	}
}
