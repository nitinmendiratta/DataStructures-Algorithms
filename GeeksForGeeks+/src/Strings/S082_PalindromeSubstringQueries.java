package Strings;
/*
 * http://www.geeksforgeeks.org/palindrome-substring-queries/
 * TODO: PARTIALLY WORKING
 */
class Query1{
    int L, R;
    Query1(int a, int b){
    	L = a;
    	R = b;
    }
};
public class S082_PalindromeSubstringQueries {

	int p = 101;
	int MOD = 1000000007;
	 
	// Structure to represent a query. A query consists
	// of (L,R) and we have to answer whether the substring
	// from index-L to R is a palindrome or not
	
	 
	// A function to check if a String str is palindrome
	// in the ranfe L to R
	boolean isPalindrome(String inStr, int L, int R){
		char[] str = inStr.toCharArray();
	    // Keep comparing characters while they are same
	    while (R > L)
	        if (str[L++] != str[R--])
	            return(false);
	    return(true);
	}
	 
	// A Function to find pow (base, exponent) % MOD
	// in log (exponent) time
	public int modPow(int base, int exponent){
	    if (exponent == 0)
	        return 1;
	    if (exponent == 1)
	        return base;
	 
	    int temp = modPow(base, exponent/2);
	 
	    if (exponent %2 ==0)
	        return (temp%MOD * temp%MOD) % MOD;
	    else
	        return ((( temp%MOD * temp%MOD)%MOD) * base%MOD) % MOD;
	}
	 
	// A Function to calculate Modulo Multiplicative Inverse of 'n'
	public int findMMI(int n){
	    return modPow(n, MOD-2);
	}
	 
	// A Function to calculate the prefix hash
	public void computePrefixHash(String inStr, int n, int prefix[], int power[]){
		char[] str = inStr.toCharArray();
	    prefix[0] = 0;
	    prefix[1] = str[0];
	 
	    for (int i=2; i<=n; i++)
	        prefix[i] = (prefix[i-1]%MOD +
	                    (str[i-1]%MOD * power[i-1]%MOD)%MOD)%MOD;
	 
	    return;
	}
	 
	 
	// A Function to calculate the suffix hash
	// Suffix hash is nothing but the prefix hash of
	// the reversed String
	public void computeSuffixHash(String inStr, int n,int suffix[], int power[]){
		char[] str = inStr.toCharArray();
	    suffix[0] = 0;
	    suffix[1] = str[n-1];
	 
	    for (int i=n-2, j=2; i>=0 && j<=n; i--,j++)
	        suffix[j] = (suffix[j-1]%MOD +
	                     (str[i]%MOD * power[j-1]%MOD)%MOD)%MOD;
	    return;
	}
	 
	// A Function to answer the Queries
	public void queryResults(String str, Query1 q[], int m, int n, int prefix[], int suffix[], int power[]){
	    for (int i=0; i<=m-1; i++){
	        int L = q[i].L;
	        int R = q[i].R;
	 
	        // Hash Value of Substring [L,R]
	        int hash_LR =
	            ((prefix[R+1]-prefix[L]+MOD)%MOD *
	             findMMI(power[L])%MOD)%MOD;
	 
	        // Reverse Hash Value of Substring [L,R]
	        int reverse_hash_LR =
	            ((suffix[n-L]-suffix[n-R-1]+MOD)%MOD *
	             findMMI(power[n-R-1])%MOD)%MOD;
	 
	        // If both are equal then the substring is a palindrome
	        if (hash_LR == reverse_hash_LR ){
	            if (isPalindrome(str, L, R) == true)
	                System.out.println("The Substring is a palindrome: "+L+","+R);
	            else
	            	System.out.println("The Substring is not a palindrome: "+L+","+R);
	        }
	 
	        else
	        	System.out.println("The Substring is not a palindrome: "+L+","+R);
	    }
	 
	    return;
	}
	 
	// A Dynamic Programming Based Approach to compute the
	// powers of 101
	void computePowers(int power[], int n){
	    // 101^0 = 1
	    power[0] = 1;
	 
	    for(int i=1; i<=n; i++)
	        power[i] = (power[i-1]%MOD * p%MOD)%MOD;
	 
	    return;
	}
	
	public static void main(String[] args) {
		S082_PalindromeSubstringQueries obj = new S082_PalindromeSubstringQueries();
		String str = "abaaabaaaba";
	    int n = str.length();
	 
	    // A Table to store the powers of 101
	    int[] power = new int[n+1];
	 
	    obj.computePowers(power, n);
	 
	    // Arrays to hold prefix and suffix hash values
	    int[] prefix = new int[n+1];
	    int[] suffix = new int[n+1];
	 
	    // Compute Prefix Hash and Suffix Hash Arrays
	    obj.computePrefixHash(str, n, prefix, power);
	    obj.computeSuffixHash(str, n, suffix, power);
	 
	    Query1 q[] = { new Query1(0, 10), new Query1(5,8), new Query1(2,5), new Query1(5,9)};
	    int m = q.length;
	 
	    obj.queryResults(str, q, m, n, prefix, suffix, power);
	}
}
