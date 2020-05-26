package Strings;
/*
 * http://www.geeksforgeeks.org/longest-common-extension-lce-set-1-introduction-and-naive-method/
 * Time Complexity: The time complexity is O(Q.N), where
 * Q = Number of LCE Queries
 * N = Length of the input string
 * Auxiliary Space: O(1), in-place algorithm.
 */

import Strings.Query1;

public class S086_LongestCommonExtensionSet1 {

	
	 
	// A utility function to find longest common
	// extension from index - L and index - R
	public int LCE(String str, int n, int L, int R){
	    int length = 0;
	    
	    while (R+length < n && str.charAt(L+length) == str.charAt(R+length)){
	    	//System.out.println(str.charAt(L+length)+" , "+str.charAt(R+length));
	    	length++;
	    }

	    return(length);
	}
	 
	// A function to answer queries of longest common extension
	public void LCEQueries(String str, int n, Query1 q[], int m){
	    for (int i=0; i<m; i++){
	        int L = q[i].L;
	        int R = q[i].R;
	 
	        System.out.println("LCE: "+L+", "+R+": "+LCE(str, n, L, R));
	    }
	    return;
	}
	 
	public static void main(String[] args) {
		S086_LongestCommonExtensionSet1 obj = new S086_LongestCommonExtensionSet1();
		String str = "abbababba";
	    int n = str.length();
	 
	    // LCA Queries to answer
	    Query1 q[] = { new Query1(1,2), new Query1(1, 6), new Query1(0,5)};
	    int m = q.length;
	 
	    obj.LCEQueries(str, n, q, m);
	}
}
