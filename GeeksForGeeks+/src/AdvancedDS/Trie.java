package AdvancedDS;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/trie-insert-and-search/
 */
public class Trie {    
	TrieNode root;

	public Trie(){
		root = new TrieNode((char)0);       
	}    
	// Method to insert a new word to Trie
	public TrieNode insert(String word){
		// Find length of the given word
		int length = word.length();        
		TrieNode crawl = root;
		// Traverse through all characters of given word
		for(int level = 0; level < length; level++){
			HashMap<Character,TrieNode> child = crawl.getChildren();            
			char ch = word.charAt(level);
			// If there is already a child for current character of given word 
			if(child.containsKey(ch))
				crawl = child.get(ch);
			else{   // Else create a child
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp );
				crawl = temp;
			}
		}     
		// Set bIsEnd true for last character
		crawl.setIsEnd(true);
		return root;
	}

	public boolean search(String word){
		//TrieNode head = dictionary.getHead();
		int length = word.length();  // Find length of the input string       
		// Initialize reference to traverse through Trie
		TrieNode crawl = root;   
		// Iterate through all characters of input string 'str' and traverse down the Trie
		int level, prevMatch = 0; 
		for(level = 0 ; level < length; level++){    
			// Find current character of str
			char ch = word.charAt(level);    
			// HashMap of current Trie node to traverse down
			HashMap<Character,TrieNode> child = crawl.getChildren();                        
			// See if there is a Trie edge for the current character
			if(child.containsKey(ch)){
				crawl = child.get(ch); //Update crawl to move down in Trie
			}            
			else  return false;
		}
		return true; // not sure sth else in gfg
	}

	public static void main(String[] args) {
		Trie dict = new Trie();    

		TrieNode head = dict.insert("are");
		head = dict.insert("area");
		head = dict.insert("base");
		head = dict.insert("cat");
		head = dict.insert("cater");        
		head = dict.insert("basement");

		System.out.println("search are: "+dict.search("are"));
		System.out.println("search area: "+dict.search("area"));
		System.out.println("search base: "+dict.search("base"));
		System.out.println("search cat: "+dict.search("cat"));
		System.out.println("search nitin: "+dict.search("nitin"));
		System.out.println("search cater: "+dict.search("cater"));
		
	}
}