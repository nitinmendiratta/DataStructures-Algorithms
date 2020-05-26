package Medium;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/counting-bits/
 */
public class M_0338_CountingBits {

	// https://www.youtube.com/watch?v=QjEyO1137cM
	/*
	 * 0 -> 0, 0
		1 -> 1, 1
		2 -> 10, 1
		3 -> 11, 2
		4 -> 100, 1
		5 -> 101, 2
		6 -> 110, 2
		7 -> 111, 3
		8 -> 1000, 1
		9 -> 1001, 2
		
		This is how dp[] is getting calculated

		dp[i+b] = dp[i] + 1
		-----------------------------
		dp[0+1] = dp[0] + 1 ~ dp[1] = dp[0]+1

		dp[0+2] = dp[0] + 1 ~ dp[2] = dp[0]+1
		dp[1+2] = dp[1] + 1 ~ dp[3] = dp[1]+1
		
		dp[0+4] = dp[0] + 1 ~ dp[4] = dp[0]+1
		dp[1+4] = dp[1] + 1 ~ dp[5] = dp[1]+1
		dp[2+4] = dp[2] + 1 ~ dp[6] = dp[2]+1
		dp[3+4] = dp[3] + 1 ~ dp[7] = dp[3]+1

		dp[0+8] = dp[0] + 1 ~ dp[8] = dp[0]+1
		dp[1+8] = dp[1] + 1 ~ dp[9] = dp[1]+1
	 */
	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		int i = 0;
		int b = 1; // 2 ^ 0

		while (b <= num) {

			while (i < b && i + b <= num) {
				dp[i + b] = dp[i] + 1;
				i++;
			}
			i = 0; // i is the pointer
			b = b << 1; // b is doubled
		}
		return dp;
	}

	public static void main(String[] args) {
		M_0338_CountingBits obj = new M_0338_CountingBits();
		System.out.println(Arrays.toString(obj.countBits(2)));
	}
}
