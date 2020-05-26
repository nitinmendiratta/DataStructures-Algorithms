package Strings;
import java.util.*;

/*
 * http://www.geeksforgeeks.org/distinct-strings-odd-even-changes-allowed/
 */
public class S113_DistinctStringsWithOddAndEvenChangesAllowed {

	static int MAX_CHAR = 26;
	// Returns encoding of String that can be used for hashing.
	// The idea is to return same encoding for strings which 
	// can become same after swapping a even positioned character
	// with other even characters OR swapping an odd character
	// with other odd characters.
	public static String encodeString(String str){
		// hashEven stores the count of even indexed character
		// for each String hashOdd stores the count of odd
		// indexed characters for each String
		int hashEven[] = new int[MAX_CHAR];
		int hashOdd[] = new int[MAX_CHAR];

		// creating hash for each String
		for (int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if ((i&1) == 1) // If index of current character is odd
				hashOdd[c-'a']++;
			else
				hashEven[c-'a']++;
		}

		// For every character from 'a' to 'z', we store its
		// count at even position followed by a separator,
		// followed by count at odd position.
		String encoding = "";
		for (int i=0; i<MAX_CHAR; i++){
			encoding += hashEven[i];
			encoding += '-';
			encoding += hashOdd[i];
			encoding += '-';
		}
		return encoding;
	}

	// This function basically uses a hashing based set to
	// store strings which are distinct according to accoding
	// to criteria given in question.
	public static int countDistinct(String input[]){
		int n = input.length;
		int countDist = 0;  // Initialize result

		// Create an empty set and store all distinct strings in it.
		HashMap<String, Integer> s = new HashMap<String, Integer>();
		for (int i=0; i<n; i++){
			// If this encoding appears first time, increment count of distinct encodings.
			if (s.get(encodeString(input[i])) == null){
				s.put(encodeString(input[i]), 1);
				countDist++;
			}
		}

		return countDist;
	}
	public static void main(String[] args) {
		String input[] = {"abcd", "acbd", "adcb", "cdba","bcda", "badc"};
		System.out.println(countDistinct(input));
	}
}
