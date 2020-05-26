package AdvancedDS;
import java.util.HashMap;
/*
 * http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 */
public class LongestPrefixMatching {

	// The main method that finds out the longest string 'input'
	public String getMatchingPrefix(Trie dictionary, String input){
		String result = ""; // Initialize resultant string
		int length = input.length();  // Find length of the input string       
		// Initialize reference to traverse through Trie
		TrieNode crawl = dictionary.root;   
		// Iterate through all characters of input string 'str' and traverse down the Trie
		int level, prevMatch = 0; 
		for(level = 0 ; level < length; level++){    
			// Find current character of str
			char ch = input.charAt(level);    
			// HashMap of current Trie node to traverse down
			HashMap<Character,TrieNode> child = crawl.getChildren();                        
			// See if there is a Trie edge for the current character
			if(child.containsKey(ch)){
				result += ch;          //Update result
				crawl = child.get(ch); //Update crawl to move down in Trie
				// If this is end of a word, then update prevMatch
				if(crawl.isEnd()) 	prevMatch = level + 1;
			}            
			else  break;
		}
		// If the last processed character did not match end of a word, return the previously matching prefix
		if(!crawl.isEnd())	return result.substring(0, prevMatch);        
		else return result;
	}

	public static void main(String[] args) {
		Trie dict = new Trie();    
		LongestPrefixMatching obj = new LongestPrefixMatching();
		
		TrieNode head = dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");        
		dict.insert("basement");
		
		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));              

		input = "basement";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));                      

		input = "are";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));              

		input = "arex";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));              

		input = "basemexz";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));                      

		input = "xyz";
		System.out.print(input + ":   ");
		System.out.println(obj.getMatchingPrefix(dict,input));                      
	}
}

