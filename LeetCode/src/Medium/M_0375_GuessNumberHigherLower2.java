package Medium;
/*
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 */
public class M_0375_GuessNumberHigherLower2 {

	/* 	Credits: https://harunscorner.wordpress.com/2016/09/04/leetcode-guess-number-higher-or-lower-ii-solution/
	 * 	Let’s take an instance, for n = 3, we have 3 choices either to choose 1 or 2 or 3.
		Let’s say we choose 1. There are 2 possible chances,
		
		[Case X]: 1 is the actual number so you pay 0$ or,
		[Case Y]: 1 is not the actual number so you pay 1$ (now you know that the actual number is > 1 because for every guess we will know if its less than or greater than, in our case it can only be greater than) and have the subproblem (2, 3). To choose from (2, 3) again recursively applying the same method, you can choose either 2 or 3. If you pick 2, you have 2 possible outcomes again. 2 is the actual number and you pay 0$ for this choice or 2 is not the actual number and you pay 2$ for this choice and you know 3 is the answer since that’s the only one left. On the other hand, if you had picked 3, then either 3 is correct or you pay 3$ and know 2 is the actual answer since it’s the only one left. So to sum up this, you pay 2$ in the worst case if you choose 2 or pay 3$ in the worst case if you pick 3$. So we will pick the min of the worst cases which is 2$ and hence 2 is the answer for (2, 3) subproblem. (Notice the minimax? 😉 ) So, the total cost paid in this is 1$ + 2$ = 3$.
		Let’s say you picked 2 initially. You have 2 possible outcomes.
		
		2 is the actual number and you pay 0$ or,
		2 is not the actual number and you pay 2$. 
		At this point, you get to know if the actual number is less than or greater than the actual number. 
		So, you will know the answer right away without another guess. So you end up paying 2$.
		So, if you choose 2 initially, you risk paying 2$ at most.
		Similarly, if you had chosen 3 initially, you risk paying 4$ at most. 
		Hence picking 2 initially is the best option and you risk at most 2$.
		
		
		Let’s say you picked 2 initially. You have 2 possible outcomes.

		2 is the actual number and you pay 0$ or,
		2 is not the actual number and you pay 2$. 
		At this point, you get to know if the actual number is less than or greater than the actual number. 
		So, you will know the answer right away without another guess. So you end up paying 2$.
		So, if you choose 2 initially, you risk paying 2$ at most.
		Similarly, if you had chosen 3 initially, you risk paying 4$ at most. 
		Hence picking 2 initially is the best option and you risk at most 2$.

		 * 1 2 3 4 5
		 * 1: 1+ [2,3,4,5]
		 * 2: 2+ max([1], [3,4,5])
		 * 3: 3+ max([1,2], [4,5])
		 * 4: 4+ max([1,2,3], [5])
		 * 5: 5+ [1,2,3,4]
	 */
	public int getMoneyAmount(int n) {
		int[][] table = new int[n + 1][n + 1];
		return helper(table, 1, n);
	}

	public int helper(int[][] table, int start, int end) {
		if (start >= end)
			return 0;
		
		if (table[start][end] > 0)
			return table[start][end];
		
		int ans = Integer.MAX_VALUE;
		
		for (int x = start + (end - start) / 2; x <= end; x++) {
			table[start][end] = x + Math.max(helper(table, start, x - 1), helper(table, x + 1, end));
			ans = Math.min(ans, table[start][end]);
		}

		table[start][end] = ans;
		return table[start][end];
	}
	public static void main(String[] args) {
		M_0375_GuessNumberHigherLower2 obj = new M_0375_GuessNumberHigherLower2();
		System.out.println(obj.getMoneyAmount(10));
	}

}
