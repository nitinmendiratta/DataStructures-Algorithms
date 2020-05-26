package Strings;
/*
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings/
 */
public class S016_CheckWhetheraStringIsAnInterleavingOfTwoOtherStrings {

	public boolean isInterleaved(String A, String B, String C){
		// Find lengths of the two strings
		int M = A.length(), N = B.length();
		//Let us create a 2D table to store solutions of subproblems. C[i][j] will be true if C[0..i+j-1] is an interleaving of A[0..i-1] and B[0..j-1].
		boolean IL[][] = new boolean[M+1][N+1];

		// C can be an interleaving of A and B only of sum of lengths of A & B is equal to length of C.
		if ((M+N) != C.length())	return false;

		// Process all characters of A and B
		for (int i = 0; i <= M; ++i){
			for (int j = 0; j <= N; ++j){
				// two empty strings have an empty string as interleaving
				System.out.println(i+","+j);
				if (i == 0 && j == 0)	
					IL[i][j] = true;
				// A is empty
				else if (i == 0 && B.charAt(j-1) == C.charAt(j-1))
					IL[i][j] = IL[i][j-1];
				// B is empty
				else if (j == 0 && A.charAt(i-1) == C.charAt(i-1))
					IL[i][j] = IL[i-1][j];

				// Current character of C matches with current character of A, but doesn't match with current character of B
				else if(i >= 1 && j >= 1 && A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1) != C.charAt(i+j-1))
					IL[i][j] = IL[i-1][j];

				// Current character of C matches with current character of B, but doesn't match with current character of A
				else if (i >= 1 && j >= 1 && A.charAt(i-1) != C.charAt(i+j-1) && B.charAt(j-1) == C.charAt(i+j-1)){
					IL[i][j] = IL[i][j-1];
				}
				// Current character of C matches with that of both A and B
				else if (i >= 1 && j >= 1 && A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1) == C.charAt(i+j-1))
					IL[i][j] = (IL[i-1][j] || IL[i][j-1]) ;
					
			}
			//if(i == 1)System.exit(0);
		}
		return IL[M][N];
	}
	
	public static void main(String[] args) {
		S016_CheckWhetheraStringIsAnInterleavingOfTwoOtherStrings obj = new S016_CheckWhetheraStringIsAnInterleavingOfTwoOtherStrings();
		String s1 = "XXY";
		String s2 = "XXZ";
		String s3 = "XXZXXXY";
		System.out.println("Interleaved: "+obj.isInterleaved("XXY", "XXZ", "XXXXZY"));
	}
}
