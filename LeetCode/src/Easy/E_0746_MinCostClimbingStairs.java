package Easy;
/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * https://leetcode.com/problems/min-cost-climbing-stairs/discuss/110111/Javascript-and-C%2B%2B-solutions
 */
public class E_0746_MinCostClimbingStairs {

	/*
	 * Same DP concept as approach2, however, more concisely we only need the last two
	 * answers ( pPrev and prev ) in order to calculate the current answer curr as follows:
	 * 
	 * Let a be the optimal cost to reach stair i - 2 ( ie. two stairs away from stair i) 
	 * Let b be the optimal cost to reach stair i - 1 ( ie. one stair away from stair i) 
	 * Let c be the optimal cost to reach stair i DP formula:
	 * 
	 * curr = A[i] + min(pPrev, prev) 
	 * 
	 * Base case:
	 * pPrev = A[0] ( ie. two stairs away from stair i starting at i = 2 ) 
	 * prev = A[1] ( ie. one stair away from stair i starting at i = 2 )
	 */
	public int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		// base case
		int pPrev = cost[0], prev = cost[1], curr = 0;
		
		// we dont need to create dp array here as we need to reach last element and we can keep track of last 2 results in a variable
		for (int i = 2; i < len; ++i) {
			
			//we include curr cost too assuming we will eventually more from this step as the result is to reach end
			curr = cost[i] + Math.min(pPrev, prev);
			pPrev = prev;
			prev = curr;
		}
		return Math.min(pPrev, prev);
	}


	/*
	 * Bottom-Up Dynamic Programming 
	 * dp[i] be the minimum cost to reach stair i.
	 * 
	 * DP formula:
	 * 
	 * dp[i] = A[i] + min(dp[i - 2], dp[i - 1]) 
	 * 
	 * Base case:
	 * dp[0] = A[0] dp[1] = A[1] 
	 * Note: the top floor n can be reached from either n - 2 or n - 1 stairs away, return the minimum.
	 */
	public int minCostClimbingStairsApproach2(int[] cost) {
		int len = cost.length;
		int[] dp = new int[len];
		// base case
		dp[0] = cost[0];
		dp[1] = cost[1];

		// loop over to initialise the dp array
		for (int i = 2; i < len; ++i)
			dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);

		// return min of last 2 values as we can reach top from any of those
		return Math.min(dp[len - 2], dp[len - 1]);
	}
	public static void main(String[] args) {
		E_0746_MinCostClimbingStairs obj = new E_0746_MinCostClimbingStairs();
		System.out.println(obj.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
}
