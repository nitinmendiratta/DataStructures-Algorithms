package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class E_0884_UncommonWordsFromTwoSentences {
	
	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> count = new HashMap();
		for (String word: A.split(" "))
			count.put(word, count.getOrDefault(word, 0) + 1);
		for (String word: B.split(" "))
			count.put(word, count.getOrDefault(word, 0) + 1);

		List<String> ans = new LinkedList();
		for (String word: count.keySet())
			if (count.get(word) == 1)
				ans.add(word);

		return ans.toArray(new String[ans.size()]);
	}
	public static void main(String[] args) {
		E_0884_UncommonWordsFromTwoSentences obj = new E_0884_UncommonWordsFromTwoSentences();
		System.out.println(Arrays.toString(obj.uncommonFromSentences("this apple is sweet", "this apple is sour")));
	}
}
