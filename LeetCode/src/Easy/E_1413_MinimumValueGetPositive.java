package Easy;
/*
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class E_1413_MinimumValueGetPositive {

	
	public int minStartValue(int[] nums) {
        int sum = 0, minPrefixSum = 0;
        for (int n : nums) {
            sum += n;
            minPrefixSum = Math.min(sum, minPrefixSum);
        }
        return 1 - minPrefixSum;
    }
	
	// my approach
	public int minStartValueApproach2(int[] nums) {
        int res = 1, sum = 1;
		for(int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
			if(sum < 1) {
				res += 1-sum;
				sum = 1;
			}
		}
		return res;
    }
	public static void main(String[] args) {
		E_1413_MinimumValueGetPositive obj = new E_1413_MinimumValueGetPositive();
		System.out.println(obj.minStartValue(new int[] {-3,2,-3,4,2}));
		System.out.println(obj.minStartValue(new int[] {1,2}));
		System.out.println(obj.minStartValue(new int[] {1,-2,-3}));
	}
}
