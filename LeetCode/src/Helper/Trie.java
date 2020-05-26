package Helper;
import java.util.*;
/*
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * Each trie node can only contains 'a'-'z' characters. So we can use a small array to store the character.
 */

public class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			int index = word.charAt(i) -'a';
			if(node.children[index] == null){ 
				node.children[index] = new TrieNode();
			}
			node  = node.children[index];
		}
		// here node is the last char in the word
		node.word = word;
		node.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		if(node == null){
			return false;
		}else{
			if(node.isEnd)
				return true;
		}

		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = searchNode(prefix);
		if(node == null){
			return false;
		}else{
			return true;
		}
	}

	public TrieNode searchNode(String s){
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++){
			int index = s.charAt(i) -'a';
			if(node.children[index] != null){
				node = node.children[index];
			}else{
				return null;
			}
		}

		if(node == root)
			return null;

		return node;
	}
}
