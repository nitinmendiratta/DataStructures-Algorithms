package Easy;
/*
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class E_0643_MaximumAverageSubarray1 {

	public double findMaxAverage(int[] nums, int k) {
        int len = nums.length, i = 0, j = 0;
        double max_so_far = Integer.MIN_VALUE, curr_sum = 0;
        while(j < len){
            if(j - i < k){
                curr_sum += nums[j];
                max_so_far = curr_sum;
            }else{
                curr_sum += nums[j] - nums[i];
                i++;
            }
            j++;
            if(max_so_far < curr_sum) max_so_far = curr_sum;
        }
        return max_so_far/k;
    }
	public static void main(String[] args) {
		E_0643_MaximumAverageSubarray1 obj = new E_0643_MaximumAverageSubarray1();
		int[] input = {1,12,-5,-6,50,3};
		System.out.println(obj.findMaxAverage(input, 3));
	}
}
