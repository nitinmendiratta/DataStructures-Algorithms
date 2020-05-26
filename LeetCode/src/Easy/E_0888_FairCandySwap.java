package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class E_0888_FairCandySwap {

	public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }
	public static void main(String[] args) {
		E_0888_FairCandySwap obj = new E_0888_FairCandySwap();
		System.out.println(Arrays.toString(obj.fairCandySwap(new int[] {1, 1}, new int[] {2, 2})));
	}
}
