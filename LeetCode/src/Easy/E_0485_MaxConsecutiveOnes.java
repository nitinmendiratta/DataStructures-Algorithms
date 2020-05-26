package Easy;
/*
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class E_0485_MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 1)
                    j++;
                if (j - i > max) {
                    max = j - i;
                }
                i = j;
            }
        }
        return max;
    }
	public static void main(String[] args) {
		E_0485_MaxConsecutiveOnes obj = new E_0485_MaxConsecutiveOnes();
		int[] nums = new int[]{1,1,0,1,1,1};
		System.out.println(obj.findMaxConsecutiveOnes(nums));
	}
}
