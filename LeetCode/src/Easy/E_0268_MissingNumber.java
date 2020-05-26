package Easy;
/*
 * https://leetcode.com/problems/missing-number/
 */
public class E_0268_MissingNumber {

	public int missingNumber(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}
	public static void main(String[] args) {
		E_0268_MissingNumber obj = new E_0268_MissingNumber();
		int[] input = new int[]{3,0,1};
		System.out.println(obj.missingNumber(input));
	}
}
