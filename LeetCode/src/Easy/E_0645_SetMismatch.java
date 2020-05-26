package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/set-mismatch/
 */
public class E_0645_SetMismatch {

	public int[] findErrorNums(int[] nums) {
		int dup = -1, missing = 1;
		for (int n: nums) {
			if (nums[Math.abs(n) - 1] < 0)
				dup = Math.abs(n);
			else
				nums[Math.abs(n) - 1] *= -1;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0)
				missing = i + 1;
		}
		return new int[]{dup, missing};
	}
	
	// TODO need to understand
	// https://leetcode.com/problems/set-mismatch/discuss/105513/XOR-one-pass
	public int[] findErrorNumsApproach2(int[] nums) {
		int xor = 0, xor0 = 0, xor1 = 0;
		for (int n: nums)
			xor ^= n;
		for (int i = 1; i <= nums.length; i++)
			xor ^= i;
		int rightmostbit = xor & ~(xor - 1);
		for (int n: nums) {
			if ((n & rightmostbit) != 0)
				xor1 ^= n;
			else
				xor0 ^= n;
		}
		for (int i = 1; i <= nums.length; i++) {
			if ((i & rightmostbit) != 0)
				xor1 ^= i;
			else
				xor0 ^= i;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == xor0)
				return new int[]{xor0, xor1};
		}
		return new int[]{xor1, xor0};
	}
	public static void main(String[] args) {
		E_0645_SetMismatch obj = new E_0645_SetMismatch();
		int[] input = {1,2,2,4};
		System.out.println(Arrays.toString(obj.findErrorNums(input)));
	}
}
