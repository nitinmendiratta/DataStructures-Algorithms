package Easy;
/*
 * https://leetcode.com/problems/third-maximum-number/
 */
public class E_0414_ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		long max1 = Long.MIN_VALUE;
		long max2 = Long.MIN_VALUE;
		long max3 = Long.MIN_VALUE;
		int count = 0; // max updated freqency

		// be very careful with the statement order of line 11-13, 16-17
		for(int n : nums) {
			if(n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
				count++;
			}else if(n > max2 && n < max1) {
				max3 = max2;
				max2 = n;
				count++;
			}else if(n > max3 && n < max2) {
				max3 = n;
				count++;
			}
		}

		if(count >= 3) {
			return (int)max3;
		}else {
			return (int)max1;
		}
	}
	public static void main(String[] args) {
		E_0414_ThirdMaximumNumber obj = new E_0414_ThirdMaximumNumber();
		int[] input = new int[]{-2, 0, 3, -5, 2, -1};
		System.out.println(obj.thirdMax(input));
	}
}
