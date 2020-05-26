package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class E_1010_PairsSongsWithTotalDurationsDivisibleBy60 {

	/*
	 * t % 60 gets the remainder 0 ~ 59.
	 * We count the occurrence of each remainders in a array/hashmap c.
	 * we want to know that, for each t, how many x satisfy (t + x) % 60 = 0.

	 * One idea is take x % 60 + t % 60 = 60 , which is valid for the most cases.
	 * But if t % 60 = 0, x % 60 = 0 instead of 60. for cases if x,t both are multiple of 60
	 * 60 - t % 60 will get a number in range 1 ~ 60.
	 * (60 - t % 60) % 60 can get number in range 0 ~ 59, which is what we want.

	 * Another idea is that x % 60 = (600 - t) % 60.
	 */
	public int numPairsDivisibleBy60(int[] time) {
		Map<Integer, Integer> count = new HashMap<>();
		int ans = 0;

		for (int t : time) {
			// get the nearest number which can be added to a particular X to sum up to 60 (which is found using 60 - t % 60).
			// 60 - t % 60 will get a number in range 1 ~ 60.
			// (60 - t % 60) % 60 can get number in range 0 ~ 59, which is what we want.
			// x%60 + t%60 = 60%60
			int d = (60 - t % 60) % 60;
			ans += count.getOrDefault(d, 0); // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
			count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
		}
		return ans;
	}
	
	public int numPairsDivisibleBy60Fast(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
	
	public static void main(String[] args) {
		E_1010_PairsSongsWithTotalDurationsDivisibleBy60 obj = new E_1010_PairsSongsWithTotalDurationsDivisibleBy60();
		System.out.println(obj.numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
	}
}
