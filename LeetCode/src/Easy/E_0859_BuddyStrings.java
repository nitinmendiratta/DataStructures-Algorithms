package Easy;
/*
 * https://leetcode.com/problems/buddy-strings/
 */
public class E_0859_BuddyStrings {

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length()) return false;
		
		// if strings equal count chars and if there are dups we can swap them so true
		if (A.equals(B)) {
			int[] count = new int[26];
			for (int i = 0; i < A.length(); ++i)
				count[A.charAt(i) - 'a']++;

			for (int c: count)
				if (c > 1) return true;
			return false;
		} else {
			// if strings diff find first and second diff chars and store there indexes, if more diff return false
			int first = -1, second = -1;
			for (int i = 0; i < A.length(); ++i) {
				if (A.charAt(i) != B.charAt(i)) {
					if (first == -1)
						first = i;
					else if (second == -1)
						second = i;
					else
						return false;
				}
			}

			// verify first diff char of A is second diff char of B, so that they can be swapped
			return (second != -1 && A.charAt(first) == B.charAt(second) &&
					A.charAt(second) == B.charAt(first));
		}
	}
	public static void main(String[] args) {
		E_0859_BuddyStrings obj = new E_0859_BuddyStrings();
		System.out.println(obj.buddyStrings("ab", "ba"));
	}
}
