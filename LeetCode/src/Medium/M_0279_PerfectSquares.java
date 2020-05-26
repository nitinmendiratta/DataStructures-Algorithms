package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/perfect-squares/
 */
public class M_0279_PerfectSquares {

	// https://www.youtube.com/watch?v=l6fy78KP78g
	public int numSquares(int n) {
		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			dp[i] = i; // max ways to form a number 4 = 1^2 + 1^2 + 1^2 + 1^2
		}

		for (int i = 2; i <= n; i++) {

			for (int j = 1; j * j <= i; j++) {
				int next = j * j;
				int remain = i - next;

				dp[i] = Math.min(dp[i], dp[remain] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		M_0279_PerfectSquares obj = new M_0279_PerfectSquares();
		System.out.println(obj.numSquares(13));
	}
}
