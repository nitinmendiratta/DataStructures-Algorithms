package Easy;
/*
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class E_1281_SubtractProductSumDigits {

	// Time O(logN) -- strange check discussion
	// Space O(1)
	 public int subtractProductAndSum(int n) {
	        int sum = 0, product = 1;
	        while(n > 0){
	            int rem = n%10;
	            product *= rem;
	            sum += rem;
	            n = n/10;
	        }
	        return product-sum;
	    }
	public static void main(String[] args) {
		E_1281_SubtractProductSumDigits obj = new E_1281_SubtractProductSumDigits();
		System.out.println(obj.subtractProductAndSum(123));
	}
}
