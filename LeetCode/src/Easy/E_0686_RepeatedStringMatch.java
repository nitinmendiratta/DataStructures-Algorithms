package Easy;
/*
 * https://leetcode.com/problems/repeated-string-match/
 * https://www.programcreek.com/2012/04/leetcode-repeated-string-match-java/
 */
public class E_0686_RepeatedStringMatch {

	/*
	 * Idea is to keep matching char in both strings and reset index on A whenever we reach end
	 */
	public int repeatedStringMatch(String A, String B) {
		int i = 0;
		int j = 0;

		int result = 0;
		int k = 0;

		while (j < B.length()) {
			// Keep going until char match
			if (A.charAt(i) == B.charAt(j)) {
				i++;
				j++;
				
				// if we reached end of A and not B's end that means we need to start again (which is similar to concatenating same string at the end of A
				if (i == A.length()) {
					i = 0;
					result++;
				}
			} else {
				// if char dont match yet keep incrementing A's index but not B's as we need to basically find first indexof B in A
				k++;
				if (k == A.length()) {
					return -1;
				}
				i = k;
				j = 0;
				result = 0;
			}
		}

		if (i > 0) {
			result++;
		}

		return result;
	}
	public static void main(String[] args) {
		E_0686_RepeatedStringMatch obj = new E_0686_RepeatedStringMatch();
		System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab"));
	}
}
