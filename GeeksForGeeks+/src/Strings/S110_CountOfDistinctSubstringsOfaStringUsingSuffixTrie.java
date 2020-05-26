package Strings;
/*
 * http://www.geeksforgeeks.org/count-distinct-substrings-String-using-suffix-trie/
 * http://www.cs.cornell.edu/courses/cs409/2000SP/Homework/SuffixTree.java
 */
//A Suffix Trie (A Trie of all suffixes) Node
class SuffixTrieNode{
	SuffixTrieNode children[] = new SuffixTrieNode[26];
	// Constructor
	SuffixTrieNode() {
		// Initialize all child pointers as null
		for (int i = 0; i < 26; i++)
			children[i] = null;
	}
	// A recursive function to insert a suffix of the s in subtree rooted with this node
	public void insertSuffix(String s){
		// If String has more characters
		if (s.length() > 0){
			// Find the first character and convert it into 0-25 range.
			char cIndex = (char) (s.charAt(0) - 'a');

			// If there is no edge for this character,
			// add a new edge
			if (children[cIndex] == null)
				children[cIndex] = new SuffixTrieNode();

			// Recur for next suffix
			children[cIndex].insertSuffix(s.substring(1));
		}
	}
};

public class S110_CountOfDistinctSubstringsOfaStringUsingSuffixTrie {
	int  MAX_CHAR = 26;

	SuffixTrieNode root;
	// Constructor (Builds a trie of suffies of the given text)
	S110_CountOfDistinctSubstringsOfaStringUsingSuffixTrie(String s){
		root = new SuffixTrieNode();

		// Consider all suffixes of given String and insert
		// them into the Suffix Trie using recursive function
		// insertSuffix() in SuffixTrieNode class
		for (int i = 0; i < s.length(); i++)
			root.insertSuffix(s.substring(i));

	}
	//  method to count total nodes in suffix trie
	public int countNodesInTrie() { return _countNodesInTrie(root); }
	// A recursive function to count nodes in trie
	public int _countNodesInTrie(SuffixTrieNode node){
		// If all characters of pattern have been processed,
		if (node == null)
			return 0;

		int count = 0;
		for (int i = 0; i < MAX_CHAR; i++){
			// if children is not null then find count of all nodes in this subtrie
			if (node.children[i] != null){
				count += _countNodesInTrie(node.children[i]);
			}
		}

		// return count of nodes of subtrie and plus
		// 1 because of node's own count
		return (1 + count);
	}
	/**
	 * Main program; used for testing.
	 */
	public static void main (String[] args) {

		String str = "ababa";
		S110_CountOfDistinctSubstringsOfaStringUsingSuffixTrie sTrie = new S110_CountOfDistinctSubstringsOfaStringUsingSuffixTrie(str);
		System.out.println("Count of distinct substrings is "+ sTrie.countNodesInTrie());
	}
}
