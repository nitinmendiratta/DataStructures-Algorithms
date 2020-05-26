package Medium;

import Helper.Trie;

/*
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class M_0208_ImplementTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}
}
