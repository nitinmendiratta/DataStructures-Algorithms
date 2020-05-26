package Strings;
/*
 * http://www.geeksforgeeks.org/longest-common-prefix-set-1-word-by-word-matching/
 * http://www.geeksforgeeks.org/longest-common-prefix-set-2-character-by-character-matching/
 * http://www.geeksforgeeks.org/longest-common-prefix-set-3-divide-and-conquer/
 */

public class S073_74_76_LongestCommonPrefix {

	/* A Function that returns the longest common prefix from the array of strings
	 * character by character matching algorithm.
	 * Time Complexity : Since we are iterating through all the characters of all the strings, 
	 * so we can say that the time complexity is O(N M) where,
	 * N = Number of strings, M = Length of the largest String String 
	 * Auxiliary Space : To store the longest prefix String we are allocating space which is O(M).
	 */
	public String commonPrefixApproach1(String arr[]){
		int minlen = findMinLength(arr);

		StringBuilder result = new StringBuilder(); // Our resultant String
		char current;  // The current character

		for (int i=0; i<minlen; i++){
			// Current character (must be same in all strings to be a part of result)
			current = arr[0].charAt(i);

			for (int j=1 ; j<arr.length; j++)
				if (arr[j].charAt(i) != current)
					return result.toString();

			// Append to result
			result.append(current);
		}

		return (result.toString());
	}

	/* A Function to find the String having the minimum length and returns that length
	 * Time Complexity : Since we are iterating through all the characters of all the strings, the time complexity is O(N M)
	 * N = Number of strings
	 * M = Length of the largest string string
	 * Auxiliary Space : To store the longest prefix string we are allocating space which is O(M Log N).
	 */
	public int findMinLength(String arr[]){
		int min = arr[0].length();

		for (int i=1; i<arr.length; i++)
			if (arr[i].length() < min)
				min = arr[i].length();

		return(min);
	}

	// A Divide and Conquer based function to find the
	// longest common prefix. This is similar to the merge sort technique
	public String commonPrefixApproach2(String arr[], int low, int high){
		if (low == high)
			return (arr[low]);

		if (high > low){
			// Same as (low + high)/2, but avoids overflow for
			// large low and high
			int mid = low + (high - low) / 2;

			String str1 = commonPrefixApproach2(arr, low, mid);
			String str2 = commonPrefixApproach2(arr, mid+1, high);

			return (commonPrefixUtil(str1, str2));
		}
		return null;
	}
	// A Utility Function to find the common prefix between strings- str1 and str2
	public String commonPrefixUtil(String str1, String str2){
		String result = "";;
		int n1 = str1.length(), n2 = str2.length();

		for (int i=0, j=0; i<=n1-1&&j<=n2-1; i++,j++){
			if (str1.charAt(i) != str2.charAt(j))
				break;
			result +=str1.charAt(i);
		}
		return (result);
	}
	
	public static void main(String[] args) {
		S073_74_76_LongestCommonPrefix obj = new S073_74_76_LongestCommonPrefix();
		String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
		//String arr[] = {"apple", "ape", "april"};
		String ans = obj.commonPrefixApproach1(arr);

		if (ans != null)
			System.out.println("The longest common prefix is "+ans);
		else
			System.out.println("There is no common prefix");

		ans = obj.commonPrefixApproach2(arr, 0, arr.length-1);

		if (ans != null)
			System.out.println("The longest common prefix is "+ans);
		else
			System.out.println("There is no common prefix");
	}
}
