package Easy;
/*
 * https://leetcode.com/problems/house-robber/
 */
public class E_0198_HouseRobber {
	
	public int rob(int[] nums) {
        int len = nums.length, i = 1;
        if(len == 0) return 0;
        int msi = nums[0], mse = 0, temp = 0;
        
        while(i < len){
            temp = mse + nums[i];
            mse = Math.max(mse, msi);
            msi = temp;
            i++;
        }
        return Math.max(msi, mse);
    }
	public static void main(String[] args) {
		E_0198_HouseRobber obj = new E_0198_HouseRobber();
		int[] arr = {8,8,7,7,7};
		System.out.println(obj.rob(arr));
	}
}
