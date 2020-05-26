package Medium;
/*
 * https://leetcode.com/problems/single-number-ii/
 */
public class M_0137_SingleNumber2 {

	// https://www.youtube.com/watch?v=ny1tk1AkON8
	// for every bit of each num
	// if the bit is 1, then 3 * num will generate 3*1 on that bit of the sum of all
	// nums
	// for example [2,3,2,2]
	// 2 : 0010
	// 3 : 0011
	// 2 : 0010
	// 2 : 0010
	// --------------------
	// sum 9 : 1001
	// 2nd bit in all nums has four 1, three of them comes from num 2 because it
	// appear 3 times
	// so after remove those 2, the count will be 1, this
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			int mask = 1 << i;

			for (int n : nums)
				// check if ith bit is set or not in element, if ith bit is set, then
				// increment counter
				if ((n & mask) != 0)
					count++;

			// if count of 1's is divisible by 3, then on ith position of result, set bit 0,
			// otherwise 1
			// now the count shows total num of 1 on the same bit of the sum of all num
			// setting result bit with 0 or 1 based on whether count is multiple of 3 or not
			//
			// so count%3 will give the the bit of sum of all nums that contributes by
			// the num which just appear 1 time
			if (count % 3 == 1)
				res |= mask;
		}
		return res;
	}

	public static void main(String[] args) {
		M_0137_SingleNumber2 obj = new M_0137_SingleNumber2();
		int[] nums = { 2, 2, 3, 2 };

		System.out.print(obj.singleNumber(nums));
	}
}
