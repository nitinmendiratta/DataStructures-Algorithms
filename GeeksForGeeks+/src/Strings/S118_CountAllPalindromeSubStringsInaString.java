package Strings;
/*
 * http://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 * Time complexity O(n2)
 * Auxiliary Space O(n2)
 */
public class S118_CountAllPalindromeSubStringsInaString {

	// Return total number of palindrome substring of length greater then equal to 2
	public static int CountPS(String string){
		int n = string.length();
	    // creat empty 2-D matrix that counts all palindrome
	    // substring. dp[i][j] stores counts of palindromic
	    // substrings in st[i..j]
	    int dp[][] = new int[n][n];
	 
	    // P[i][j] = true if substring str[i..j] is palindrome,
	    // else false
	    boolean P[][] = new boolean[n][n];

	    // palindrome of single lenght
	    for (int i= 0; i< n; i++)
	        P[i][i] = true;
	 
	    // palindrome of length 2
	    for (int i=0; i<n-1; i++){
	        if (string.charAt(i) == string.charAt(i+1)){
	            P[i][i+1] = true;
	            dp[i][i+1] = 1 ;
	        }
	    }
	 
	    // Palindromes of length more then 2. This loop is similar
	    // to Matrix Chain Multiplication. We start with a gap of
	    // length 2 and fill DP table in a way that gap between
	    // starting and ending indexes increases one by one by
	    // outer loop.
	    for (int gap=2 ; gap<n; gap++){
	        // Pick starting point for current gap
	        for (int i=0; i<n-gap; i++){
	            // Set ending point
	            int j = gap + i;
	 
	            // If current string is palindrome
	            if (string.charAt(i) == string.charAt(j) && P[i+1][j-1] )
	                P[i][j] = true;
	 
	            // Add current palindrome substring ( + 1)
	            // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
	            // remove common palinrome substrings (- dp[i+1][j-1])
	            if (P[i][j] == true)
	                dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
	            else
	                dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
	        }
	    }
	 
	    // return total palindromic substrings
	    return dp[0][n-1];
	}
	public static void main(String[] args) {
		System.out.println(CountPS("abaab"));
		System.out.println(CountPS("abaaa"));
		System.out.println(CountPS("geek"));
	}
}
