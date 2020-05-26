package Easy;

/*
 * https://leetcode.com/problems/consecutive-characters/
 */
public class E_1446_ConsecutiveCharacters {

	public int maxPower(String s) {
		int max = 1, len = s.length(), slow = 0, fast = 1;

		while (fast < len) {

			while (fast < len && s.charAt(slow) == s.charAt(fast))
				fast++;
			if (fast - slow > max) {
				max = fast - slow;
			}
			slow = fast;
			fast++;
		}
		return max;
	}

	public static void main(String[] args) {
		E_1446_ConsecutiveCharacters obj = new E_1446_ConsecutiveCharacters();
		System.out.println(obj.maxPower("leetcode"));
		System.out.println(obj.maxPower("abbcccddddeeeeedcba"));
		System.out.println(obj.maxPower("triplepillooooow"));
		System.out.println(obj.maxPower("hooraaaaaaaaaaay"));
		
	}

}
