package Medium;

/*
 * https://leetcode.com/problems/integer-break/
 */
public class M_0343_IntegerBreak {
	
	// Tough to understand 
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}
	/*
	 * Every number can be broken down to 2 parts. For eg: 7 can be broken down to
	 * (1, 6), (2, 5), (3, 4). And similarly every broken part can be further broken
	 * down.
	 * 
	 * Suppose we incrementally build a dp[] array & keep storing max product for
	 * each i in dp[i].
	 * 
	 * Any number x can be > or < dp[x]. 
	 * For eg: 
	 * 3 > dp[3] = 2 * 1 = 2 
	 * 5 < dp[5] = 3 * 2 = 6
	 * 
	 * For any index i, split it into (j, i - j). 
	 * Use max of Left = (i, dp[i]) & Right = (i - j, dp[i - j]) for each j to obtain product : Left * Right.
	 * 
	 * Store the max result obtained for this i, in dp[i].
	 */
	// Tough to understand
	public int integerBreakApproach2(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;

		for (int i = 4; i <= n; i++) {
			int max = 1;
			for (int j = 1; j <= i / 2; j++) {
				int currMax = 1;
				int left = Math.max(j, dp[j]);
				int right = Math.max(i - j, dp[i - j]);
				currMax = left * right;
				max = Math.max(currMax, max);
			}
			dp[i] = max;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		M_0343_IntegerBreak obj = new M_0343_IntegerBreak();
		System.out.println(obj.integerBreak(3));
	}

}
