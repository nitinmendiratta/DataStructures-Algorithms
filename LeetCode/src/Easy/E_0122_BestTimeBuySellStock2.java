package Easy;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class E_0122_BestTimeBuySellStock2 {

	public int maxProfit(int[] prices) {
		int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
	}
	public static void main(String[] args) {
		E_0122_BestTimeBuySellStock2 obj = new E_0122_BestTimeBuySellStock2();
		int[] arr = new int[] {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(arr));
	}
}
