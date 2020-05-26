package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/unique-morse-code-words/
 */
public class E_0804_UniqueMorseCodeWords {

	public int uniqueMorseRepresentations(String[] words) {
		String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
				"....","..",".---","-.-",".-..","--","-.",
				"---",".--.","--.-",".-.","...","-","..-",
				"...-",".--","-..-","-.--","--.."};

		Set<String> seen = new HashSet();
		for (String word: words) {
			StringBuilder code = new StringBuilder();
			for (char c: word.toCharArray())
				code.append(MORSE[c - 'a']);
			seen.add(code.toString());
		}

		return seen.size();
	}
	public static void main(String[] args) {
		E_0804_UniqueMorseCodeWords obj = new E_0804_UniqueMorseCodeWords();
		System.out.println(obj.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
	}
}
