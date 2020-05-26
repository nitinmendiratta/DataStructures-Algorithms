package Strings;
/*
 * http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
 * o(n)
 */
public class S018_LexicographicRankOfaString {

	// A utility function to find factorial of n
	int fact(int n){
		return (n <= 1)? 1 :n * fact(n-1);
	}

	// Construct a count array where value at every index
	// contains count of smaller characters in whole string
	void populateAndIncreaseCount (int[] count, String str){
		for(int i = 0; i < str.length(); ++i)
			++count[ str.charAt(i) ];

		for(int i = 1; i < 256; ++i )
			count[i] += count[i-1];
	}

	// Removes a character ch from count[] array constructed by populateAndIncreaseCount()
	void updatecount (int[] count, char ch){
		for(int i = ch; i < 256; ++i )
			--count[i];
	}

	// A function to find rank of a string in all permutations
	// of characters
	int findRank (String str){
		int len = str.length();
		int mul = fact(len);
		int rank = 1, i;
		int count[] = new int[256];  // all elements of count[] are initialized with 0

		// Populate the count array such that count[i] contains count of 
		// characters which are present in str and are smaller than i
		populateAndIncreaseCount(count, str);

		for (i = 0; i < len; ++i){
			mul /= len - i;
			// count number of chars smaller than str[i] fronm str[i+1] to str[len-1]
			rank += count[str.charAt(i) - 1] * mul;

			// Reduce count of characters greater than str[i]
			updatecount (count, str.charAt(i));
		}
		return rank;
	}

	public static void main(String[] args) {
		S018_LexicographicRankOfaString obj = new S018_LexicographicRankOfaString();
		System.out.println("Rank is: "+obj.findRank("STRING"));
	}
}
