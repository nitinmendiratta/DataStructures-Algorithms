package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/count-largest-group/
 */
public class E_1399_CountLargestGroup {

	public int countLargestGroup(int n) {
		int maxGroupSize = 0;
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();

		// Iterate all the numbers from [1,n] inclusive
		for (int i = 1; i <= n; i++) {
			int val = i;
			if (i > 9) {
				// If number is more than one digit then calculate the sum of digits and add it
				// to the map
				val = sumOfDigits(i);
			}
			int totalVals = map.getOrDefault(val, 0) + 1;
			// Keep a track of the maxGroupSize while adding to the map
			maxGroupSize = Math.max(maxGroupSize, totalVals);

			// Add the sum of digits to the map
			map.put(val, totalVals);
		}

		// Iterate for all the frequency counts in the map and which is equivalent to
		// the maxGroupSize
		for (Integer cnt : map.values()) {
			if (cnt == maxGroupSize) {
				result++;
			}
		}

		return result;
	}

	private int sumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

	// Approach2
	public int countLargestGroupApproach2(int n) {
		final int N = 100;
		int[] counter = new int[N];
		int maxGroupSize = 0, res = 0;
		for (int num = 1; num <= n; ++num) {
			int val = num;
			int cnt = 0;

			while (val != 0) {
				cnt += val % 10;
				val /= 10;
			}
			++counter[cnt];
			maxGroupSize = Math.max(maxGroupSize, counter[cnt]);
		}

		for (int i = 0; i < N; ++i) {
			if (counter[i] == maxGroupSize)
				++res;
		}
		return res;
	}

	public static void main(String[] args) {
		E_1399_CountLargestGroup obj = new E_1399_CountLargestGroup();
		System.out.println(obj.countLargestGroup(13));
		System.out.println(obj.countLargestGroup(15));
		System.out.println(obj.countLargestGroupApproach2(24));
	}
}
