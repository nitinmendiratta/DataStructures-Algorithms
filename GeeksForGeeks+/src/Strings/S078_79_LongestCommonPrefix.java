package Strings;
/*
 * http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
 * http://www.geeksforgeeks.org/longest-common-prefix-set-5-using-trie/
 */
public class S078_79_LongestCommonPrefix {


	/* A Function that returns the longest common prefix from the array of strings using Binary Search
		Time Complexity : 
		The recurrence relation is

		T(M) = T(M/2) + O(MN) where,

		N = Number of strings, M = Length of the largest String String
		So we can say that the time complexity is O(NM log M)

		Auxiliary Space: To store the longest prefix String we are allocating space which is O(N) 
		where, N = length of the largest String among all the strings
	 */
	public String commonPrefixApproach3(String arr[]){
		int n = arr.length;
		int index = findMinLength(arr, n);
		String prefix = ""; // Our resultant String

		// We will do an in-place binary search on the
		// first String of the array in the range 0 to
		// index
		int low = 0, high = index;

		while (low <= high){
			// Same as (low + high)/2, but avoids overflow
			// for large low and high
			int mid = low + (high - low) / 2;

			if (allContainsPrefix (arr, n, arr[0], low, mid)){
				// If all the strings in the input array contains
				// this prefix then append this substring to
				// our answer
				prefix = prefix + arr[0].substring(low, mid-low+1);

				// And then go for the right part
				low = mid + 1;
			}

			else // Go for the left part
				high = mid - 1;
		}

		return (prefix);
	}
	// A Function to find the String having the minimum length and returns that length
	public int findMinLength(String arr[], int n){
		int min = Integer.MAX_VALUE;

		for (int i=0; i<=n-1; i++)
			if (arr[i].length() < min)
				min = arr[i].length();
		return(min);
	}

	boolean allContainsPrefix(String arr[], int n, String str, int start, int end){
		for (int i=0; i<=n-1; i++)
			for (int j=start; j<=end; j++)
				if (arr[i].charAt(j) != str.charAt(j))
					return (false);
		return (true);
	}
	/*
	 * Time Complexity : Inserting all the words in the trie takes O(MN) 
	 * time and performing a walk on the trie takes O(M) time, where-
	 * N = Number of strings
	 * M = Length of the largest string string
	 * Auxiliary Space: To store all the strings we need to allocate O(26*M*N) ~ O(MN) space for the Trie.
	 */
	// TODO: USING TRIE
	public String commonPrefixApproach4(String arr[]){
		return null;
		
	}
	public static void main(String[] args) {
		S078_79_LongestCommonPrefix obj = new S078_79_LongestCommonPrefix();
		//String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
		String arr[] = {"apple", "ape", "april"};
		String ans = obj.commonPrefixApproach3(arr);

		if (ans != null)
			System.out.println("The longest common prefix is "+ans);
		else
			System.out.println("There is no common prefix");

//		ans = obj.commonPrefixApproach4(arr);
//
//		if (ans != null)
//			System.out.println("The longest common prefix is "+ans);
//		else
//			System.out.println("There is no common prefix");
	}
}
