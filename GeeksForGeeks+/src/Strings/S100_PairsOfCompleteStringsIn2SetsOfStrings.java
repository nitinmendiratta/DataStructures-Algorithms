package Strings;
/*
 * http://www.geeksforgeeks.org/pairs-of-complete-strings-in-two-sets-of-strings/
 */
public class S100_PairsOfCompleteStringsIn2SetsOfStrings {

	// Returns count of complete pairs from set[0..n-1] and set2[0..m-1]
	public static int countCompletePairs(String set1[], String set2[], int n, int m){
		int result = 0;

		// con_s1[i] is going to store an integer whose
		// set bits represent presence/absence of characters
		// in String set1[i].
		// Similarly con_s2[i] is going to store an integer
		// whose set bits represent presence/absence of
		// characters in String set2[i]
		int con_s1[] = new int[n];
		int con_s2[] = new int[m];

		// Process all strings in set1[]
		for (int i=0; i<n; i++){
			// initializing all bits to 0
			con_s1[i] = 0;
			for (int j=0; j<set1[i].length(); j++){
				// Setting the ascii code of char s[i][j]
				// to 1 in the compressed integer.
				con_s1[i] = con_s1[i] | (1<<(set1[i].charAt(j)-'a'));
			}
		}

		// Process all strings in set2[]
		for (int i=0; i<m; i++){
			// initializing all bits to 0
			con_s2[i] = 0;
			for (int j=0; j<set2[i].length(); j++){
				// setting the ascii code of char s[i][j]
				// to 1 in the compressed integer.
				con_s2[i] = con_s2[i]|(1<<(set2[i].charAt(j)-'a'));
			}
		}

		// assigning a variable whose all 26 (0..25) bits are set to 1
		int complete = (1<<26) - 1;

		// Now consider every pair of integer in con_s1[]
		// and con_s2[] and check if the pair is complete.
		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				// if all bits are set, the strings are complete!
				if ((con_s1[i] | con_s2[j]) == complete)
					result++;
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		String set1[] = {"abcdefgh", "geeksforgeeks","lmnopqrst", "abc"};
		String set2[] = {"ijklmnopqrstuvwxyz","abcdefghijklmnopqrstuvwxyz","defghijklmnopqrstuvwxyz"};
		int n = set1.length;
		int m = set2.length;

		System.out.println(countCompletePairs(set1, set2, n, m));
	}
}
