package Medium;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 */
public class M_0309_BestTimeBuySellStockWithCooldown {
	/*
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
	 * 	s0 means we can buy
		s1 means we can sell
		s2 means we take a rest, since we have to take a rest before we buy again, s1 can not go to s0 directly and have to go to s2 first.
			I guess this will help to understand the code below
	
		Stay at s0, or rest from s2
	  	can buy, ie, we have no stock now, and the max profit should be ''last no stock profit'' or ''last rest profit''
		s0[i] = max(s0[i - 1], s2[i - 1]);   
		  
		Stay at s1, or buy from s0
		can sell, ie, we now have stock, and the profit should be ''last stock profit'' or ''last no stock but buy this time'' 
		s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]);  
		    
		Only one way from s1  
		we should sell then take a rest
		s2[i] = s1[i - 1] + prices[i]; 
	*/
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int[] s0 = new int[len], s1 = new int[len], s2 = new int[len];

		s1[0] = -prices[0];
		s0[0] = 0;
		s2[0] = Integer.MIN_VALUE;

		for (int i = 1; i < len; i++) {
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return Math.max(s0[len - 1], s2[len - 1]);
	}

	public static void main(String[] args) {
		M_0309_BestTimeBuySellStockWithCooldown obj = new M_0309_BestTimeBuySellStockWithCooldown();
		System.out.println(obj.maxProfit(new int[] { 1, 2, 3, 0, 2 }));
	}
}
