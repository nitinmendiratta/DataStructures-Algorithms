package Easy;
/*
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class E_0674_LCIS {
	
	public int findLengthOfLCIS(int[] nums) {
		int len = nums.length;
        int count = 0, maxCount = 0;
        
        for(int i = 0; i < len; i++){
            if(i == 0 || nums[i] > nums[i-1]){
                maxCount = Math.max(maxCount, ++count);
            }else {
                count = 1;
            }
        }
        return maxCount;
    }
	public static void main(String[] args) {
		E_0674_LCIS obj = new E_0674_LCIS();
		int[] input = {1,4,3,2};
		System.out.println(obj.findLengthOfLCIS(input));
	}
}
