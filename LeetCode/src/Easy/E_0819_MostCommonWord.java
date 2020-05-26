package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/most-common-word/
 */
public class E_0819_MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph += ".";

		Set<String> banset = new HashSet();
		for (String word: banned) banset.add(word);
		Map<String, Integer> count = new HashMap();

		String ans = "";
		int ansfreq = 0;

		StringBuilder word = new StringBuilder();
		for (char c: paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		E_0819_MostCommonWord obj = new E_0819_MostCommonWord();
		System.out.println(obj.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));

	}
}
