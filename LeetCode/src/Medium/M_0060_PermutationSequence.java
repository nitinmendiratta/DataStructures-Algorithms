package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/permutation-sequence/
 */
public class M_0060_PermutationSequence {

	//https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
			num.add(i);
		}
		for (int i = 0, l = k - 1; i < n; i++) {
			fact /= (n - i);
			int index = (l / fact);
			sb.append(num.remove(index));
			l -= index * fact;
		}
		return sb.toString();
	}


	// My Approach: Takes toooo long complexity n!	
	int currentCount = 0;
	public String getPermutationMyApproach(int n, int k) {
		if (n == 1) return "1";
		return getPermutationHelper(n, new StringBuilder(), k, new boolean[n+1]);
	}

	public String getPermutationHelper(int n, StringBuilder currResult, int k, boolean[] used) {
		if (currResult.length() == n) {
			currentCount++;
			return null;
		}

		for (int i = 1; i <= n; i++) {
			if (used[i]) continue;
			currResult.append(i);
			used[i] = true;
			getPermutationHelper(n, currResult, k, used);
			if(currentCount == k) return currResult.toString();
			used[i] = false;
			currResult.deleteCharAt(currResult.length() - 1);
		}
		return null;
	}

	public static void main(String[] args) {
		M_0060_PermutationSequence obj = new M_0060_PermutationSequence();
		System.out.println(obj.getPermutation(9, 362880));
	}
}
