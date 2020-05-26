package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */
public class E_1394_FindLuckyIntegerInArray {

	public int findLucky(int[] arr) {
		int[] cnt = new int[501];
		for (int a : arr) {
			++cnt[a];
		}
		for (int i = 500; i > 0; --i) {
			if (cnt[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public int findLuckyApproach2(int[] arr) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int a : arr) {
			freq.put(a, 1 + freq.getOrDefault(a, 0));
		}
		int ans = -1;
		for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
			if (e.getKey() == e.getValue()) {
				ans = Math.max(ans, e.getKey());
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		E_1394_FindLuckyIntegerInArray obj = new E_1394_FindLuckyIntegerInArray();
		System.out.println(obj.findLucky(new int[] { 2, 2, 3, 4 }));
	}
}
