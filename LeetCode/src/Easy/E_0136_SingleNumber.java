package Easy;
/*
 * https://leetcode.com/problems/single-number/
 */
public class E_0136_SingleNumber {

	public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for(int i = 1; i < len; i++){
            res = res^nums[i];
        }
        return res;
    }
	public static void main(String[] args) {
		E_0136_SingleNumber obj = new E_0136_SingleNumber();
		int[] arr = new int[]{2,2,1};
		System.out.println(obj.singleNumber(arr));
	}
}
