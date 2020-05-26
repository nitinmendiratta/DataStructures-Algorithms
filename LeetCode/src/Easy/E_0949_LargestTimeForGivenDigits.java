package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class E_0949_LargestTimeForGivenDigits {


	// (0-2)_ (0-3)_ : (0-5)_ (0-9)_
	public String largestTimeFromDigits(int[] A) {
		Arrays.sort(A);
		for (int i = 3; i >= 0; i--) {
			if (A[i] <= 2) {
				for (int j = 3; j >= 0; j--) {
					if ((A[i] != 2 || A[j] <= 3) && i != j) {
						for (int k = 3; k >= 0; k--) {
							if (A[k] <= 5 && i != k && j != k) {
								// 6 comes from 0+1+2+3 which are indexes of array so left index is calculated from 6 - i,j,k
								return "" + A[i] + A[j] + ":" + A[k] + A[6 - i - j - k];
							}
						}
					}
				}
			}
		}
		return "";
	}
	
	public String largestTimeFromDigitsSolution(int[] A) {
		int ans = -1;

		// Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j) if (j != i)
				for (int k = 0; k < 4; ++k) if (k != i && k != j) {
					int l = 6 - i - j - k;

					// For each permutation of A[i], read out the time and
					// record the largest legal time.
					int hours = 10 * A[i] + A[j];
					int mins = 10 * A[k] + A[l];
					if (hours < 24 && mins < 60)
						ans = Math.max(ans, hours * 60 + mins);
				}

		return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
	}
	public static void main(String[] args) {
		E_0949_LargestTimeForGivenDigits obj = new E_0949_LargestTimeForGivenDigits();
		System.out.println(obj.largestTimeFromDigits(new int[] {1,2,3,4}));
	}
}
