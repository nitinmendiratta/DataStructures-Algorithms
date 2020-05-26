package Strings;
/*
 * http://www.geeksforgeeks.org/longest-common-substring/
 * if match (i,j) = (i-1,j-1) + 1
 * else (i,j) = 0
 */
public class LongestCommonSubstring {

	public int lcs(String a, String b){
		int m = a.length(), n = b.length(), maxlen = 0;
		
		int[][] lcs = new int[m+1][n+1];
		
		for(int i = 0; i <= m;i++){
			for(int j = 0;j <= n;j++){
				
				if(i == 0 || j == 0){
					lcs[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
					maxlen = Math.max(maxlen,lcs[i][j]);
				}
				else	lcs[i][j] = 0;
			}
		}
		return maxlen;
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring obj = new LongestCommonSubstring();
		System.out.println("Max lcs len:"+obj.lcs("GeeksforGeeks","GeeksQuiz"));
	}
}
