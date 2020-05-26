package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class E_1029_TwoCityScheduling {

	/*
	 * How much money can we save if we fly a person to A vs. B? To minimize the total cost, we should fly the person with the maximum saving to A, and with the minimum - to B.

		Example: [30, 100], [40, 90], [50, 50], [70, 50].
		Savings: 70, 50, 0, -20.
		
		Obviously, first person should fly to A, and the last - to B.
		Runtime: O(n log n). We sort the array then go through it once. The second solution has a better average case runtime.
		Memory: O(1). We sort the array in-place.
	 */
	
	public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return a[0] - a[1] - (b[0] - b[1]);
        });
        
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }
	//dp[i][j] represents the cost when considering first (i + j) people in which i people assigned to city A and j people assigned to city B.
	// https://leetcode.com/problems/two-city-scheduling/discuss/278731/Java-DP-Easy-to-Understand
	public int twoCitySchedCostDP(int[][] costs) {
		int N = costs.length / 2;
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
		}
		for (int j = 1; j <= N; j++) {
			dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
			}
		}
		return dp[N][N];
	}
	public static void main(String[] args) {
		E_1029_TwoCityScheduling obj = new E_1029_TwoCityScheduling();
		System.out.println(obj.twoCitySchedCost(
				new int[][] {
					{10,20},
					{30,200},
					{400,50},
					{30,20}
				}
				));
	}
}
