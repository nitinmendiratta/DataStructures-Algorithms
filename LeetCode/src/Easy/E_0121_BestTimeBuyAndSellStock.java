package Easy;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class E_0121_BestTimeBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	public static void main(String[] args) {
		E_0121_BestTimeBuyAndSellStock obj = new E_0121_BestTimeBuyAndSellStock();
		int[] arr = new int[] {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(arr));
	}

}
