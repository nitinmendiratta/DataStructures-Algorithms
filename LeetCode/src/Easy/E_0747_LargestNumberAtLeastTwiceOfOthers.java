package Easy;
/*
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class E_0747_LargestNumberAtLeastTwiceOfOthers {

	public int dominantIndex(int[] nums) {
		if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE + 1;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
             // handle the case of dup too
            } else if(nums[i] != max && nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(secondMax * 2 <= max){
            return index;
        }
        return -1;
    }
	public static void main(String[] args) {
		E_0747_LargestNumberAtLeastTwiceOfOthers obj = new E_0747_LargestNumberAtLeastTwiceOfOthers();
		System.out.println(obj.dominantIndex(new int[] {3, 6, 1, 0}));
	}
}
