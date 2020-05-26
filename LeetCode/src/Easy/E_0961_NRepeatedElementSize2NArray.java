package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class E_0961_NRepeatedElementSize2NArray {

	/*
	 * Check if A[i] == A[i - 1] or A[i] == A[i - 2] 
	 * If so, we return A[i] If not,
	 * it must be [x, x, y, z] or [x, y, z, x]. 
	 * We return A[0] for the cases that we miss. 
	 * O(N) time O(1) space
	 */
	// if the number is repeated N times in a 2N array then in worst case it can only be 2 indexes apart, so checking 3 numbers works
	public int repeatedNTimes(int[] A) {
		for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
	
	// my approach
	public int repeatedNTimesApproach2(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;

        throw null;
    }
	public static void main(String[] args) {
		E_0961_NRepeatedElementSize2NArray obj = new E_0961_NRepeatedElementSize2NArray();
		System.out.println(obj.repeatedNTimes(new int[] {5,1,5,2,5,3,5,4}));
	}
}
