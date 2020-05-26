package Greedy_Backtracking_PS_DnC;

/*
 * http://www.programcreek.com/2013/12/edit-distance-in-java/
 * http://www.geeksforgeeks.org/check-whether-strings-k-distance-apart-not/
 * https://www.youtube.com/watch?v=-umsVjd2EF0&index=16&list=PL962BEE1A26238CA3

 * if match copy upper diagonal elem
 * if not min(insert,delete,replace)
 */

public class EditDistance {

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} 
				else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}
	// Returns true if str1 and str2 are k edit distance apart, else false.
	public static boolean areKDistant(String str1, String str2, int k){
		int m = str1.length();
	    int n = str2.length();
	    if (Math.abs(m-n) > k)
	        return false;
	 
	    return (minDistance(str1, str2) <= k);
	}
	
	public static void main(String[] args) {
		System.out.println(areKDistant("geek", "gks", 3));
		System.out.println("Edit Distance:"+minDistance("nitin","nit"));
	}

}
