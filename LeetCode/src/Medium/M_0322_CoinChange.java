package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/coin-change/
 * Time complexity - O(coins.size * amount)
 * Space complexity - O(coins.size * amount)
 *
 * Youtube video -
 * Topdown DP - https://youtu.be/Kf_M7RdHr1M
 * Bottom up DP - https://www.youtube.com/watch?v=jgiZlGzXMBw
 */
public class M_0322_CoinChange {

	/**
	 * Bottom up way of solving this problem. Keep input sorted. Otherwise
	 * temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which can be very low
	 * negative number Returns Integer.MAX_VALUE - 1 if solution is not possible.
	 */
	public int coinChange(int[] coins, int amount) {

		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	/**
	 * Top down dynamic programing. Using map to store intermediate results. Returns
	 * Integer.MAX_VALUE if amount cannot be formed with given coins
	 */
	public int coinChangeTopDown(int[] coins, int amount) {
		Map<Integer, Integer> map = new HashMap<>();
		return coinChangeTopDownHelper(coins, amount, map);
	}

	public int coinChangeTopDownHelper(int coins[], int amount, Map<Integer, Integer> map) {
		// if amount is 0 then there is nothing to do. return 0.
		if (amount == 0) {
			return 0;
		}

		// if map contains the result means we calculated it before. Lets return that
		// value.
		if (map.containsKey(amount)) {
			return map.get(amount);
		}

		// iterate through all coins and see which one gives best result.
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			// if value of coin is greater than amount we are looking for just continue.
			if (coins[i] > amount) {
				continue;
			}
			// recurse with amount - coins[i] as new amount
			int val = coinChangeTopDownHelper(coins, amount - coins[i], map);

			// if val we get from picking coins[i] as first coin for current amount is less
			// than value found so far make it minimum.
			if (val < min) {
				min = val;
			}
		}

		// if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to
		// it.
		min = (min == Integer.MAX_VALUE ? min : min + 1);

		// memoize the minimum for current amount.
		map.put(amount, min);
		return min;
	}

	// to print the selected combination
	public int coinChangePrintCombination(int[] coins, int amount) {

		int max = amount + 1;
		int[] dp = new int[amount + 1];
		int R[] = new int[amount + 1];
		
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					if (dp[i - coins[j]] + 1 < dp[i]) {
						dp[i] = 1 + dp[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		printCoinCombination(R, coins);
		return dp[amount] > amount ? -1 : dp[amount];
	}

	private void printCoinCombination(int R[], int coins[]) {
		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form amount ");
		while (start != 0) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		M_0322_CoinChange obj = new M_0322_CoinChange();
		System.out.println(obj.coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(obj.coinChangeTopDown(new int[] { 1, 2, 5 }, 11));
		System.out.println(obj.coinChangePrintCombination(new int[] { 1, 2, 5 }, 11));		
	}
}
