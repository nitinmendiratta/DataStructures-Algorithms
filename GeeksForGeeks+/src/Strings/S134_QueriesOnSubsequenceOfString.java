package Strings;
/*
 * http://www.geeksforgeeks.org/queries-subsequence-string/
 */
public class S134_QueriesOnSubsequenceOfString {

	// Precompute the position of each character from each position of String S
	public static int[][] precompute(String str){
		int CHAR_SIZE = 26;
		int len = str.length();
		int mat[][] = new int[len][CHAR_SIZE];
		
		// because last char has access only to itself and no further chars
	    for (int i = 0; i < CHAR_SIZE; ++i)
	        mat[len-1][i] = len;
	    
	    mat[len-1][str.charAt(len-1)-'a'] = len-1;
	    // Computing position of each character from each position of String S
	    for (int i = len-2; i >= 0; --i){
	    	// previos char has access to all chars the next char has
	        for (int j = 0; j < CHAR_SIZE; ++j)
	            mat[i][j] = mat[i+1][j];
	 
	        mat[i][str.charAt(i)-'a'] = i;
	    }
		return mat;
	}
//	public static void printMatrix(int mat[][]){
//		for (int i = 0; i < mat.length; i++){
//	        for (int j = 0; j < 26; j++)
//	           System.out.print(mat[i][j]+", ");
//	        System.out.println();
//		}
//	}
	// Print "Yes" if T is subsequence of S, else "No"
	public static boolean query(String str, String query){
	    
	    int len = str.length();
	    int mat[][] = precompute(str);
	    //printMatrix(mat);
	    // Traversing the string T
	    int pos = 0;
	    for (int i = 0; i < query.length(); ++i){
	        // If next position is greater than length of S set flag to false.
	        if (mat[pos][query.charAt(i) - 'a'] >= len)
	            return false;
	 
	        // Setting position of next character
	        else
	            pos = mat[pos][query.charAt(i) - 'a'] + 1;
	    }
	    return true;
	}
	 
	public static void main(String[] args) {
	    System.out.println(query("geeks", "gs"));
	    System.out.println(query("geeksforgeeks", "gro"));
	    System.out.println(query("geeksforgeeks", "gfg"));
	    System.out.println(query("geeksforgeeks", "orf"));
	}
}
