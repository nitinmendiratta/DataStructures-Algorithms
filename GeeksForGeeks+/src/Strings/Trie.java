package Strings;
/*
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * Each trie node can only contains 'a'-'z' characters. So we can use a small childrenay to store the character.
 */
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
 
}
 
public class Trie {
    private TrieNode root;
 
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
        node.isEnd = true;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p == null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p == null){
            return false;
        }else{
            return true;
        }
    }
 
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c-'a';
            if(p.children[index]!=null){
                p = p.children[index];
            }else{
                return null;
            }
        }
 
        if(p == root)
            return null;
 
        return p;
    }
}
