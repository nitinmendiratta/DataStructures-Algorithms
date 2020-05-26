package Helper;

public class TrieNode {
	public TrieNode[] children;
	public boolean isEnd;
	public String word;

	public TrieNode() {
		this.children = new TrieNode[26];
	}

}