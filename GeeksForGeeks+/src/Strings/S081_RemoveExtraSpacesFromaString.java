package Strings;
/*
 * http://www.geeksforgeeks.org/remove-extra-spaces-String/
 * Time complexity of above solution is O(n).
 * Auxiliary Space is O(1) as the conversion is done in-place.
 * TODO: PARTIALLY WORKING
 */

public class S081_RemoveExtraSpacesFromaString {

	// Function to in-place trim all spaces in the
	// String such that all words should contain only
	// a single space between them.
	public String removeSpaces(String inStr){
		// n is length of the original String
		int n = inStr.length();
		char[] str = inStr.toCharArray();

		// i points to next postion to be filled in
		// output String/ j points to next character
		// in the original String
		int i = 0, j = -1;

		// flag that sets to true is space is found
		boolean spaceFound = false;

		// Handles leading spaces
		while (++j < n && str[j] == ' ');

		// read all characters of original String
		while (j < n){
			// if current characters is non-space
			if (str[j] != ' '){
				// remove preceding spaces before dot,
				// comma & question mark
				if ((str[j] == '.' || str[j] == ',' ||
						str[j] == '?') && i - 1 >= 0 &&
						str[i - 1] == ' ')
					str[i - 1] = str[j++];

				else
					// copy current character at index i
					// and increment both i and j
					str[i++] = str[j++];

				// set space flag to false when any
				// non-space character is found
				spaceFound = false;
			}
			// if current character is a space
			else if (str[j++] == ' '){
				// If space is encountered for the first
				// time after a word, put one space in the
				// output and set space flag to true
				if (!spaceFound){
					str[i++] = ' ';
					spaceFound = true;
				}
			}
		}

		System.out.println(i);
//		// Remove trailing spaces
//		if (i <= 1)
//			str.s(i, str.length);
//		else
//			str.erase(str.begin() + i - 1, str.end());
		return new String(str).trim();
	}

	public static void main(String[] args) {
		S081_RemoveExtraSpacesFromaString obj = new S081_RemoveExtraSpacesFromaString();
		String str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
		System.out.println(obj.removeSpaces(str));

	}
}
