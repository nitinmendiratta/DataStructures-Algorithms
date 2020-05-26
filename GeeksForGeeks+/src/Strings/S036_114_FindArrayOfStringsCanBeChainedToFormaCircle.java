package Strings;
import java.util.*;
import java.util.Map.Entry;

import Graph.*;
/*
 * http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 * http://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
 * https://github.com/jiemingxin/LeetCode/blob/master/tutorials/graph/CircularStringChains.java
 * TODO: implement isEulerianCircuit but approach2 works
 */
public class S036_114_FindArrayOfStringsCanBeChainedToFormaCircle {
	static int CHAR_MAX = 26;

	/*public static boolean canFormCircleGraphApproach1(String[] words){

		int numChars = 26; 
		Graph graph = new Graph(numChars, "directed"); 

		// add an edge from the first character to the last 
		// character of every String 
		for(String word:words)
			graph.addEdge(word.charAt(0)-'a', word.charAt(word.length()-1)-'a'); 

		return graph.isEulerianCircuit(); 			
	}*/

	public static boolean canFormCircleGraphApproach2(String[] arr) {
		int i;
		HashSet<Character> al;
		Map<Character, HashSet<Character>> g = new HashMap<Character, HashSet<Character>>();
		Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
		int[] in = new int[CHAR_MAX];
		int[] out = new int[CHAR_MAX];

		for (i = 0; i < arr.length; i++) {
			String str = arr[i];
			// Find first and last characters
			char cFirst = str.charAt(0);
			char cLast = str.charAt(str.length() - 1);
			if (g.get(cFirst) == null) {
				al = new HashSet<Character>();
				al.add(cLast);
				g.put(cFirst, al);
			} else {
				al = g.get(cFirst);
				al.add(cLast);
				g.put(cFirst, al);
			}
			//  increase indegree and outdegree count
			in[cFirst - 'a']++;
			out[cLast - 'a']++;
			// Mark the characters
			visited.put(cFirst, true);
			visited.put(cLast, true);
		}

		// If for any character indegree is not equal to outdegree then ordering is not possible
		for (i = 0; i < CHAR_MAX; i++) {
			if (in[i] != out[i])
				return false;
		}
		return isConnected(g, visited, arr[0].charAt(0));
	}

	//  Returns true if all vertices are strongly connected i.e. can be made as loop
	public static boolean isConnected(Map<Character, HashSet<Character>> g, Map<Character, Boolean> visited, char ch){
		dfs(g, visited, ch);
		for (Entry e : visited.entrySet()) {
			if (e.getValue().equals(false)) {
				return false;
			}
		}
		return true;
	}
	
	//  Utility method for a depth first search among vertices
	private static void dfs(Map<Character, HashSet<Character>> g, Map<Character, Boolean> visited, char ch) {
		if (visited.get(ch) == true) {
			return;
		}
		visited.put(ch, true);
		HashSet<Character> val = g.get(ch);
		if (val != null) {

			Iterator<Character> it = val.iterator();
			while (it.hasNext()) {
				char key = it.next();
				dfs(g, visited, key);
			}
		}
	}

	public static void main(String[] args) {

		String arr1[] =  {"for", "geek", "rig", "kaf"};
		//int n1 = sizeof(arr1)/sizeof(arr1[0]);
		System.out.println("Can be chained:"+canFormCircleGraphApproach2(arr1));

		String arr2[] =  {"ab", "bc", "cd", "de", "ed", "da"};
		//int n1 = sizeof(arr1)/sizeof(arr1[0]);
		System.out.println("Can be chained:"+canFormCircleGraphApproach2(arr2));

		String arr3[] =  {"aab", "abb"};
		//int n2 = sizeof(arr2)/sizeof(arr2[0]);
		System.out.println("Can be chained:"+canFormCircleGraphApproach2(arr3));
	}
}
