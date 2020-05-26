package Strings;
import Graph.*;
/*
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * Time Complexity: The first step to create a graph takes O(n + alhpa) time where n is number of given words 
 * and alpha is number of characters in given alphabet. The second step is also topological sorting. 
 * Note that there would be alpha vertices and at-most (n-1) edges in the graph. 
 * The time complexity of topological sorting is O(V+E) which is O(n + aplha) here. 
 * So overall time complexity is O(n + aplha) + O(n + aplha) which is O(n + aplha).
 * TODO: Convert the integer output to chars
 */
public class S035_FindPrecedenceCharInaSortedDictionary {

	// This function fidns and prints order of characer from a sorted
	// array of words. n is size of words[].  alpha is set of possible
	// alphabets.
	// For simplicity, this function is written in a way that only
	// first 'alpha' characters can be there in words array.  For
	// example if alpha is 7, then words[] should have only 'a', 'b',
	// 'c' 'd', 'e', 'f', 'g'
	public void printOrder(String words[], int n, int alpha){
	    // Create a graph with 'aplha' edges
		Graph g = new Graph(alpha,"directed");
	 
	    // Process all adjacent pairs of words and create a graph
	    for (int i = 0; i < n-1; i++){
	        // Take the current two words and find the first mismatching
	        // character
	        String word1 = words[i], word2 = words[i+1];
	        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++){
	            // If we find a mismatching character, then add an edge
	            // from character of word1 to that of word2
	            if (word1.charAt(j) != word2.charAt(j)){
	            	g.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
	                break;
	            }
	        }
	    }
	    // Print topological sort of the above created graph
	    TopologicalSorting obj = new TopologicalSorting();
	    obj.sort(g);
	    //g.printGraph();
	}
	 
	public static void main(String[] args) {
		S035_FindPrecedenceCharInaSortedDictionary obj = new S035_FindPrecedenceCharInaSortedDictionary();
		String words[] = {"baa", "abcd", "abca", "cab", "cad"};
	    obj.printOrder(words, 5, 4);
	}
}
