package Greedy_Backtracking_PS_DnC;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * http://www.youtube.com/watch?v=EH6h7WA7sDw
 */

public class KnapSack0_1 {

	private int maxBenefit(int wt[], int val[], int Wmax){
		int i, w;
		int n = val.length; //total number of items
		int[][] result = new int[n+1][Wmax+1];

		
		// Build table result[][] in bottom up manner
		for (i = 0; i <= n; i++){
			for (w = 0; w <= Wmax; w++){
				if (i==0 || w==0)
					result[i][w] = 0;
				else if (wt[i-1] <= w)
					result[i][w] = Math.max((val[i-1] + result[i-1][w-wt[i-1]]), result[i-1][w]);
				else
					result[i][w] = result[i-1][w];
			}
		}
		return result[n][Wmax];
	}

	public static void main(String[] args) {
		KnapSack0_1 obj = new KnapSack0_1();
		int wt[] = {3,2,1};
		int val[] = {5,3,4};
		int  W = 5;
		System.out.println("Max benefit:"+obj.maxBenefit(wt,val,W));
	}

}
