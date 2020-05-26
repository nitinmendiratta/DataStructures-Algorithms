package Easy;
/*
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

public class E_0303_RangeSumQueryImmutable {

	private int[] sum;

	class NumArray{
		public NumArray(int[] nums) {
		    sum = new int[nums.length + 1];
		    for (int i = 0; i < nums.length; i++) {
		        sum[i + 1] = sum[i] + nums[i];
		    }
		}
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
	public static void main(String[] args) {
		E_0303_RangeSumQueryImmutable obj = new E_0303_RangeSumQueryImmutable();
		int[] input = new int[]{-2, 0, 3, -5, 2, -1};
		NumArray obj2 = obj.new NumArray(input);
		System.out.println(obj.sumRange(0, 5));
	}
}
