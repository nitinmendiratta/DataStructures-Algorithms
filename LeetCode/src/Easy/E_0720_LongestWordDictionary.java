package Easy;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class E_0720_LongestWordDictionary {

	public String longestWord(String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		return findLongestWord(trie.root);
	}
	public String findLongestWord(TrieNode root) {
		String result = null;
		Queue<TrieNode> queue = new LinkedList<>();	
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TrieNode node = queue.poll();
				// run loop from end so that we get result as the lexicographical smaller string
				for (int j = 25; j >= 0; j--) {
					// loop over the children array to get each substring by checking isEnd
					// and then make this substring as the new node to process. 
					if (node.children[j] != null && node.children[j].isEnd) {
						result = node.children[j].word;
						queue.offer(node.children[j]);
					}
				}
			}
		}
		return result;
	}
	// using set
	public String longestWordApproach2(String[] words) {
		String ans = "";
		Set<String> wordset = new HashSet();
		// create a set of all words
		for (String word: words) wordset.add(word);

		// loop over all words and check if we found a word of greater length then answer
		// if of equal length check for the lexicographical  order
		for (String word: words) {
			if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
				boolean good = true;

				// loop over all the substrings of the word and see if they all exist in the set and if not dont update the answer
				for (int k = 1; k < word.length(); ++k) {
					if (!wordset.contains(word.substring(0, k))) {
						good = false;
						break;
					}
				}
				// update answer if we have a word length greater then ans and all its substring exist in dictionary
				if (good) ans = word;
			}    
		}
		return ans;
	}
	public static void main(String[] args) {
		E_0720_LongestWordDictionary obj = new E_0720_LongestWordDictionary();
		String[] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(obj.longestWord(words));
		System.out.println(obj.longestWordApproach2(words));
	}
}
