package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class E_0914_XKindDeckOfCards {

	/*
	 * Time Complexity: O(Nlog^2 N), where N is the number of votes. If there are C
	 * cards with number i, then each gcd operation is naively O(log^2 C).
	 * 
	 * Space Complexity: O(N).
	 */

	// using array
	public boolean hasGroupsSizeX(int[] deck) {
		int[] count = new int[10000];
		for (int c: deck)
			count[c]++;

		int gcd = -1;
		for (int i = 0; i < 10000; ++i)
			if (count[i] > 0) {
				if (gcd == -1)
					gcd = count[i];
				else
					gcd = getGcd(gcd, count[i]);
			}

		return gcd >= 2;
	}

	// using hashmap
	public boolean hasGroupsSizeXApproach2(int[] deck) {
		int len = deck.length;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for(int i = 0; i < len; i++){
			hm.put(deck[i], hm.getOrDefault(deck[i], 0)+1);
		}
		int gcd = -1;
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int value = entry.getValue();
			if (gcd == -1)
				gcd = value;
			else
				gcd = getGcd(gcd, value);
		}
		return gcd >= 2;
	}
	public int getGcd(int x, int y) {
		return x == 0 ? y : getGcd(y%x, x);
	}
	public static void main(String[] args) {
		E_0914_XKindDeckOfCards obj = new E_0914_XKindDeckOfCards();
		System.out.println(obj.hasGroupsSizeX(new int[] {1,2,3,4,4,3,2,1}));
		System.out.println(obj.hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3,3}));
		System.out.println(obj.hasGroupsSizeX(new int[] {1,1,1,1,2,2,2,2,2,2}));
	}
}
