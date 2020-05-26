package Medium;
import Helper.*;
/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class M_0211_AddSearchWord {

	Trie trie;

	/** Initialize your data structure here. */
	public M_0211_AddSearchWord() {
		trie = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		trie.insert(word);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return match(word.toCharArray(), 0, trie.root);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length)
			return !node.word.equals("");
		if (chs[k] != '.') {
			TrieNode childNode = node.children[chs[k] - 'a'];
			return childNode != null && match(chs, k + 1, childNode);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					if (match(chs, k + 1, node.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		M_0211_AddSearchWord obj = new M_0211_AddSearchWord();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad")); // false
		System.out.println(obj.search("bad")); // true
		System.out.println(obj.search(".ad")); // true
		System.out.println(obj.search("b..")); // true
	}
}
