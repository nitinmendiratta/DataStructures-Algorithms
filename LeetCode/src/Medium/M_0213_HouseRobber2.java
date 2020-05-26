package Medium;

/*
 * https://leetcode.com/problems/house-robber-ii/
 */
public class M_0213_HouseRobber2 {

	public int rob(int[] nums) {
		int len = nums.length, i = 1;
		if (len == 0)
			return 0;

		// force include first element
		int msi = nums[0], mse = nums[0], temp = 0;

		for (i = 2; i < len - 1; i++) {
			temp = mse + nums[i];
			mse = Math.max(mse, msi);
			msi = temp;
		}
		int res = Math.max(msi, mse);

		// force exclude first element
		msi = 0;
		mse = 0;
		temp = 0;

		for (i = 1; i < len; i++) {
			temp = mse + nums[i];
			mse = Math.max(mse, msi);
			msi = temp;
		}
		return Math.max(res, Math.max(msi, mse));
	}

	public static void main(String[] args) {
		M_0213_HouseRobber2 obj = new M_0213_HouseRobber2();
		System.out.println(obj.rob(new int[] { 2, 3, 2 }));
		System.out.println(obj.rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(obj.rob(new int[] { 1, 1, 100, 1 }));
	}
}
