package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class E_1170_CompareStringsByFrequencyOfSmallestCharacter {


	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		// This arr's index represents frequency, and its value represents how many Strings in "words" array have same or more frequency
		// For example, words = ["a","aa","aaa","aaaa"], arr[1]=4,  arr[2]=3,  arr[3]=2,  arr[4]=1
		int[] arr = new int[12];  // <= I first used 11 as well and got ArrayIndexOutOfBound error 

		for(String s: words) {
			int count = findMinChar(s);
			arr[count]++;
		}
		System.out.println(Arrays.toString(arr));
		// Fill accumulated values from backward  ex: 2 freq words will also be counted in 3 and 4
		for(int i = arr.length-2 ; i >= 0; i--) {
			arr[i] = arr[i+1] + arr[i];
		}
		System.out.println(Arrays.toString(arr));
		int[] ret=  new int[queries.length];
		for(int i = 0; i < queries.length; i++) {
			int c = findMinChar(queries[i]);
			ret[i] = arr[c+1]; //  O(1) access to get the number of words with more frequencies 
		}
		return ret;
	}

	public int findMinChar(String s) {
		int min= 'z'-'a';
		int count = 0;
		for(char ch: s.toCharArray()) {
			int curr = ch - 'a';
			if (curr < min) {
				min = ch-'a';
				count=1;
			} else if (curr == min){
				count++;
			}
		}
		return count;
	}


	// MY APPROACH
	public int[] numSmallerByFrequencyMyApproach(String[] queries, String[] words) {
		int[] minCharWordArray = minCharacterCountArray(words);
		//System.out.println(Arrays.toString(minCharWordArray));
		int[] res = new int[queries.length];

		for(int i = 0; i < queries.length; i++) {
			String currQuery = queries[i];
			int queryFreq = freqMinChar(currQuery);
			res[i] = search(minCharWordArray, queryFreq);
		}
		return res;
	}

	public int[] minCharacterCountArray(String[] input) {
		int[] res = new int[input.length];

		for(int j = 0; j < input.length; j++) {
			int[] arr = new int[26];
			String str = input[j];

			for(int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a'] += 1;
			}

			for(int i = 0; i < arr.length; i++) {
				if(arr[i] > 0) {
					res[j] = arr[i];
					break;
				}
			}
		}
		Arrays.sort(res);
		return res;
	}

	public int freqMinChar(String str) {
		int[] arr = new int[26];

		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a'] += 1;
		}

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) return arr[i];
		}
		return 0;
	}

	// return <= target index
	public int search(int[] arr, int target) {
		System.out.println(target);
		int i = arr.length -1;
		while(i >= 0 && arr[i] > target) i--;

		return arr.length - i -1;
	}

	public static void main(String[] args) {
		E_1170_CompareStringsByFrequencyOfSmallestCharacter obj = new E_1170_CompareStringsByFrequencyOfSmallestCharacter();
		System.out.println(Arrays.toString(obj.numSmallerByFrequency(new String[] {"bbb","cc"}, new String[] {"a","aa","aaa","aaaa"})));
		//System.out.println(Arrays.toString(obj.numSmallerByFrequency(new String[] {"cc"}, new String[] {"awerwerewr","aawerwerwe","aaeweerr","aawerw"})));
	}
}
