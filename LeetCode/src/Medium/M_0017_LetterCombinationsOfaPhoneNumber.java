package Medium;
import java.util.*;
/*
 * S64: http://www.geeksforgeeks.org/combinations-strings-can-used-dial-given-phone-number/
 * M017: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Time complexity of O(n^m), where n is the number of characters for each digit, m is the length of the digit string. 
 */ 
public class M_0017_LetterCombinationsOfaPhoneNumber {

	// Prints all possible combinations of strings that can be used to dial c[].
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) return result;
		// For every digit, store characters that can be used to dial it.
		String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		// Create a string to store a particular output string
		StringBuilder sb = new StringBuilder();
		// Call recursive function
		letterCombinationsHelper(digits, 0, sb, dict, result);

		return result;
	}
	// A Recursive function to print all combinations
	// that can be used to dial a given number.
	// digits ==> Given Phone Number
	// start    ==> Current digit of phNo to be processed
	// dict   ==> Stores characters that can be used to dial a digit.
	// sb  ==> Current output string
	private static void letterCombinationsHelper(String digits, int start, StringBuilder sb, String[] dict, List<String> result) {
		// If all digits are processed, print output string
		if (start >= digits.length()) {
			result.add(sb.toString());
			return;
		}
		// Get current digit of phNo, and recur for all characters that can be used to dial it.
		// char to int
		int num = digits.charAt(start) - '0';
		for (int i = 0; i < dict[num].length(); i++) {
			sb.append(dict[num].charAt(i));
			letterCombinationsHelper(digits, start + 1, sb, dict, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// Approach 2: better to understand
	public static List<String> letterCombinationsIterative(String digits) {
		LinkedList<String> res = new LinkedList<String>(); // queue
		if(digits.isEmpty()) return res;
		
		String[] dict = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		
		while(res.peek().length() != digits.length()){
			String prev = res.remove();
			// Get current digit of phNo, and recur for all characters that can be used to dial it.
			// char to int
			int num = digits.charAt(prev.length())-'0';
			for (int i = 0; i < dict[num].length(); i++) {
				res.addLast(prev + dict[num].charAt(i));
				//System.out.println(prev + dict[num].charAt(i));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinationsIterative("23"));
	}
}
