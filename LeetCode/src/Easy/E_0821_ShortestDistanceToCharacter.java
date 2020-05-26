package Easy;
import java.util.*;

/*
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

	Example 1:
	Input: S = "loveleetcode", C = 'e'
	Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
	
	
	S string length is in [1, 10000].
	C is a single character, and guaranteed to be in string S.
	All letters in S and C are lowercase.
 */
public class E_0821_ShortestDistanceToCharacter {

	/*
	 * Loop twice on the string S. First forward pass to find shortest distant to
	 * character on left. Second backward pass to find shortest distant to character
	 * on right.
	 */
	public int[] shortestToChar(String S, char C) {
		int N = S.length();
		int[] ans = new int[N];
		int prev = Integer.MIN_VALUE / 2;

		for (int i = 0; i < N; ++i) {
			if (S.charAt(i) == C) prev = i;
			ans[i] = i - prev;
		}

		prev = Integer.MAX_VALUE / 2;
		for (int i = N-1; i >= 0; --i) {
			if (S.charAt(i) == C) prev = i;
			ans[i] = Math.min(ans[i], prev - i);
		}

		return ans;
	}

	// extra memory
	public int[] shortestToCharApproach2(String S, char C) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[] res = new int[S.length()];
		int i = 0, j = 0, ans = 0;

		for(i = 0; i < S.length(); i++){
			if(S.charAt(i) == C){
				arr.add(i);
			}
		}

		for(i = 0; i < S.length(); i++){

			if(j > 0 && i > arr.get(j-1) && i <  arr.get(j)){
				ans = Math.min(arr.get(j) - i, i - arr.get(j-1));
			}else if(i == arr.get(j)){
				ans = 0;
				if(j < arr.size()-1) j++;
			}else{
				ans = arr.get(j) - i;
			}
			res[i] = Math.abs(ans);
		}
		return res;
	}
	public static void main(String[] args) {
		E_0821_ShortestDistanceToCharacter obj = new E_0821_ShortestDistanceToCharacter();
		System.out.println(Arrays.toString(obj.shortestToChar("loveleetcode", 'e')));
	}
}
