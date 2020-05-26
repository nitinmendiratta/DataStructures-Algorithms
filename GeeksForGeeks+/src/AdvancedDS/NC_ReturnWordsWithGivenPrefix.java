package AdvancedDS;

public class NC_ReturnWordsWithGivenPrefix {

	/*public class Trie{
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	// Adds a word to the Trie
	public void addWord(String word){
		root.addWord(word.toLowerCase());
	}

	// Get the words in the Trie with the given prefix and return a List containing String objects containing the words in the Trie with the given prefix.
	public List getWords(String prefix){
		//Find the node which represents the last letter of the prefix
		TrieNode lastNode = root;
		for (int i=0; i<prefix.length(); i++){
			lastNode = lastNode.getNode(prefix.charAt(i));
			//If no node matches, then no words exist, return empty list
			if (lastNode == null) return new ArrayList();      
		}
		//Return the words which eminate from the last node
		return lastNode.getWords();
	}
}
public class TrieNode{
	private TrieNode parent;
	private TrieNode[] children;
	private boolean isLeaf;     //Quick way to check if any children exist
	private boolean isWord;     //Does this node represent the last character of a word
	private char character;     //The character this node represents

	public TrieNode(){
		children = new TrieNode[26];
		isLeaf = true;
		isWord = false;
	}
	public TrieNode(char character){
		this();
		this.character = character;
	}
	// Adds a word to this node. This method is called recursively and adds child nodes for each successive letter in the word, therefore
	// recursive calls will be made with partial words.
	protected void addWord(String word){
		isLeaf = false;
		int charPos = word.charAt(0) - 'a';

		if (children[charPos] == null){
			children[charPos] = new TrieNode(word.charAt(0));
			children[charPos].parent = this;
		}

		if (word.length() > 1){
			children[charPos].addWord(word.substring(1));
		}
		else{
			children[charPos].isWord = true;
		}
	}

	// Returns the child TrieNode representing the given char, or null if no node exists.
	protected TrieNode getNode(char c){
		return children[c - 'a'];
	}

	// Returns a List of String objects which are lower in the hierarchy that this node
	protected List getWords(){
		//Create a list to return
		List list = new ArrayList();
		//If this node represents a word, add it
		if (isWord){
			list.add(toString());
		}
		//If any children
		if (!isLeaf){
			//Add any words belonging to any children
			for (int i=0; i<children.length; i++){
				if (children[i] != null){
					list.addAll(children.getWords());
				}
			}
		}
		return list; 
	}

	// Gets the String that this node represents. For example, if this node represents the character t, whose parent represents the charater a, 
	// whose parent represents the character c, then the String would be "cat".
	public String toString(){
		if (parent == null)		return "";
		else	return parent.toString() + new String(new char[] {character});
	} 
	
	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
		char keys[][8] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		trie_t trie;

		char output[][32] = {"Not present in trie", "Present in trie"};

		initialize(&trie);

		// Construct trie
		for(int i = 0; i < ARRAY_SIZE(keys); i++){
			insert(&trie, keys[i]);
		}

		// Search for different keys
		printf("%s --- %s\n", "the", output[search(&trie, "the")] );
		printf("%s --- %s\n", "these", output[search(&trie, "these")] );
		printf("%s --- %s\n", "their", output[search(&trie, "their")] );
		printf("%s --- %s\n", "thaw", output[search(&trie, "thaw")] );
	}
}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
