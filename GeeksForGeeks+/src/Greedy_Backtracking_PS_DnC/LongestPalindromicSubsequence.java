package Greedy_Backtracking_PS_DnC;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

	public static int lcs(String a){
	
		StringBuilder sb = new StringBuilder(a);
		String b = sb.reverse().toString();
		int m = a.length();
		int n = b.length();
		
		int[][] lps = new int[m+1][n+1];
		
		for(int i = 0; i <= m;i++){
			for(int j = 0;j <= n;j++){
				
				if(i == 0 || j == 0){
					lps[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)){
					lps[i][j] = lps[i-1][j-1] + 1;
				}
				else{
					lps[i][j] = Math.max(lps[i-1][j],lps[i][j-1]);
				}
			}
		}
		print(lps);
		return lps[m][m];
	}

	private static void print(int[][] matrix){
		System.out.println("Output Matrix");
		System.out.println("----------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("----------------------");
		}
	}
	public static void main(String[] args) {
		System.out.println("Max lps len:"+lcs("bbabcbcab"));
	}

}
