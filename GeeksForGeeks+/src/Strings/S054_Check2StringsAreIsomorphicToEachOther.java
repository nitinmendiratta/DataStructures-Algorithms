package Strings;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
 * O(n) time
 */
public class S054_Check2StringsAreIsomorphicToEachOther {

	// This function returns true if str1 and str2 are ismorphic
	public boolean areIsomorphic(String str1, String str2){

		int m = str1.length(), n = str2.length();

		// Length of both strings must be same for one to one
		// corresponance
		if (m != n)
			return false;

		// To mark visited characters in str2
		boolean marked[] = new boolean[256];

		// To store mapping of every character from str1 to
		// that of str2. Initialize all entries of map as -1.
		int map[] = new int[256];
		Arrays.fill(map, -1);

		// Process all characters one by on
		for (int i = 0; i < n; i++){
			// If current character of str1 is seen first time in it.
			if (map[str1.charAt(i)] == -1){
				// If current character of str2 is already
				// seen, one to one mapping not possible
				if (marked[str2.charAt(i)] == true)
					return false;

				// Mark current character of str2 as visited
				marked[str2.charAt(i)] = true;

				// Store mapping of current characters
				map[str1.charAt(i)] = str2.charAt(i);
			}

			// If this is not first appearance of current
			// character in str1, then check if previous
			// appearance mapped to same character of str2
			else if (map[str1.charAt(i)] != str2.charAt(i))
				return false;
		}

		return true;
	}
	public static void main(String[] args) {
		S054_Check2StringsAreIsomorphicToEachOther obj = new S054_Check2StringsAreIsomorphicToEachOther();
		System.out.println(obj.areIsomorphic("aab", "xxy"));
		System.out.println(obj.areIsomorphic("aab", "xyz"));
	}
}
