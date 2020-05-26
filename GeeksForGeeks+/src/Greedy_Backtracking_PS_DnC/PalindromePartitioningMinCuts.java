package Greedy_Backtracking_PS_DnC;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * http://www.lifeincode.net/programming/leetcode-palindrome-partitioning-i-and-iijava/
 */
public class PalindromePartitioningMinCuts {

	public int minCut(String s) {
		int n = s.length();
		//check if the substring(i, j) of the original string is palindrome or not
		boolean[][] isPalindrome = new boolean[n][n];
		for (int i = 0; i < n; i++)	isPalindrome[i][i] = true; //make all string of length 1 as true
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if ((j - i) < 2 || isPalindrome[i + 1][j - 1])// j-i < 2 means only 1 char in between i,j
						isPalindrome[i][j] = true;
				}
			}
		}
		// minCut[i] saves the number of minimum cut of substring(i, n)
		int[] minCut = new int[n + 1];
		// initialise to maximum cuts possible. Ex: C[0..3] = 2, C[1..3] = 1, C[2..3] = 0, C[3..3] = -1
		for (int i = n; i >= 0; i--) minCut[i] = n - 1 - i; 
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (isPalindrome[i][j]) {
					minCut[i] = Math.min(minCut[i], 1 + minCut[j + 1]);
				}
			}
		}
		return minCut[0];
	}

	public static void main(String[] args) {
		PalindromePartitioningMinCuts obj = new PalindromePartitioningMinCuts();
		System.out.println("Min Cuts needed: "+obj.minCut("abc"));
	}
}
