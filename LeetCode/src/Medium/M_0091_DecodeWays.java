package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/decode-ways/
 */
public class M_0091_DecodeWays {

	/*
	 * Let's say we have string 1234, when i = 4, first = 4, second = 34, 
	 * then we can go on decoding it like 123 4(123 has many different ways to be decoded but we don't care), 
	 * all the ways 123 can be decoded remain valid only if 4 is decodable. Let's assume first is 0 instead of 4, 
	 * then we have string 123 0, decoding of 123 becomes useless because 0 is not decodable.
	 * It's the same idea about second.
	 */
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;

		for(int i = 2; i <= n; i++) {
			int oneDigit = Integer.valueOf(s.substring(i-1, i));
			int twoDigit = Integer.valueOf(s.substring(i-2, i));

			if(oneDigit >= 1 && oneDigit <= 9) {
				dp[i] += dp[i-1];  
			}
			if(twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
	} 

	public static void main(String[] args) {
		M_0091_DecodeWays obj = new M_0091_DecodeWays();
		System.out.println(obj.numDecodings("1234"));
	}
}
