package Easy;
/*
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class E_0665_NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {
		int len = nums.length, i = 0, count = 0;

		while(i < len-1){
			if(nums[i] > nums[i+1]){
				count++;
				// special case if first element is the wrong one
				if(i == 0) nums[i] = nums[i+1];
				// 2nd case if prev elem is smaller then next element then curr elt should be prev to maintain uphill
				// ex: 1423
				else if(nums[i-1] <= nums[i+1]){
					nums[i] = nums[i-1];
				} else {
					// 3rd case if prev elem is greater then next element then next elt should be made curr to maintain uphill
					// ex: 3425
					nums[i+1] = nums[i];
				}
			}
			if(count == 2) return false;
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		E_0665_NonDecreasingArray obj = new E_0665_NonDecreasingArray();
		int[] input = {4,2,1};
		System.out.println(obj.checkPossibility(input));
	}
}
