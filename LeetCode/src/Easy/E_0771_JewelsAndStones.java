package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class E_0771_JewelsAndStones {

	public int numJewelsInStones(String J, String S) {
		if (J == null || J.length() == 0 || S == null || S.length() == 0) { 
			return 0; 
		}
		// also you can take array of size 58 ASCII of 'z' - 'A' is 58.
		Set<Character> set = new HashSet<>();
		for (char j : J.toCharArray()) {
			set.add(j);
		}
		int counter = 0;
		for (char s : S.toCharArray()) {
			if (set.contains(s)) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		E_0771_JewelsAndStones obj = new E_0771_JewelsAndStones();
		System.out.println(obj.numJewelsInStones("aA", "aAAbbbb"));
	}
}
