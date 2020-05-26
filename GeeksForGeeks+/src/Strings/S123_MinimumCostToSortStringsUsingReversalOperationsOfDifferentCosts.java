package Strings;
/*
 * http://www.geeksforgeeks.org/minimum-cost-sort-strings-using-reversal-operations-different-costs/
 */
public class S123_MinimumCostToSortStringsUsingReversalOperationsOfDifferentCosts {

	// Returns minimum cost for sorting arr[]
	// using reverse operation. This function
	// returns -1 if it is not possible to sort.
	public static int minCost(String arr[], int cost[], int N){
	    // dp[i][j] represents the minimum cost to
	    // make first i strings sorted.
	    // j = 1 means i'th String is reversed.
	    // j = 0 means i'th String is not reversed.
	    int dp[][] = new int[N][2];
	 
	    //  initializing dp array for first String
	    dp[0][0] = 0;
	    dp[0][1] = cost[0];
	 
	    //  getting array of reversed strings
	    String revStr[] = new String[N];
	    for (int i = 0; i < N; i++){
	        revStr[i] = new StringBuilder(arr[i]).reverse().toString();
	    }
	 
	    String curStr;
	    int curCost;
	 
	    //  looping for all strings
	    for (int i = 1; i < N; i++){
	        // Looping twice, once for String and once
	        // for reversed String
	        for (int j = 0; j < 2; j++){
	            dp[i][j] = Integer.MAX_VALUE;
	 
	            // getting current String and current
	            // cost according to j
	            curStr = (j == 0) ? arr[i] : revStr[i];
	            curCost = (j == 0) ? 0 : cost[i];
	 
	            // Update dp value only if current String
	            // is lexicographically larger
	            if (curStr.compareTo(arr[i - 1]) >= 0)
	                dp[i][j] = Math.min(dp[i][j], dp[i-1][0] + curCost);
	            if (curStr.compareTo(revStr[i - 1]) >= 0)
	                dp[i][j] = Math.min(dp[i][j], dp[i-1][1] + curCost);
	        }
	    }
	 
	    //  getting minimum from both entries of last index
	    int res = Math.min(dp[N-1][0], dp[N-1][1]);
	 
	    return (res == Integer.MAX_VALUE)? -1 : res;
	}
	public static void main(String[] args) {
		String arr[] = {"aa", "ba", "ac"};
	    int cost[] = {1, 3, 1};
	    int N = arr.length;
	 
	    int res = minCost(arr, cost, N);
	    if (res == -1)
	        System.out.println("Sorting not possible\n");
	    else
	        System.out.println("Minimum cost to sort strings is "+ res);
	}
}
