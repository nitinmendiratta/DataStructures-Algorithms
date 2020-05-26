package DynamicProgramming;

/*
 * http://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 *
 * if match then upper diagonal elem +1
 * if not max(left,upper)
 */

public class DP4_LongestCommonSubsequence {

	public static int lcs(String a, String b){
		int m = a.length();
		int n = b.length();
		int maxlen = 0;
		int[][] table = new int[m+1][n+1];

		for(int i = 0; i <= m;i++){
			for(int j = 0;j <= n;j++){

				if(i == 0 || j == 0){
					table[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
				}
				else{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		maxlen = table[m][n];

		// Following code is used to print LCS
		int index = table[m][n];
		// Create a character array to store the lcs string
		char lcs[] = new char[index+1];
		// Start from the right-most-bottom-most corner and one by one store characters in lcs[]
		int i = m, j = n;

		while (i > 0 && j > 0){
			// If current character in X[] and Y are same, then current character is part of LCS
			if (a.charAt(i-1) == b.charAt(j-1)){
				lcs[index-1] = a.charAt(i-1); // Put current character in result
				i--; j--; index--;     // reduce values of i, j and index
			}
			// If not same, then find the larger of two and go in the direction of larger value
			else if (table[i-1][j] > table[i][j-1])
				i--;
			else
				j--;
		}

		// Print the lcs
		System.out.println("LCS is: "+new String(lcs));
		return maxlen;
	}

	public static void main(String[] args) {
		System.out.println("Max lcs len:"+lcs("ABCDGH","AEDFHR"));
		System.out.println("Max lcs len:"+lcs("AGGTAB","GXTXAYB"));
	}

}
