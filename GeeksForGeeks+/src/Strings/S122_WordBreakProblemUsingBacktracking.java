package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 * http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 */
public class S122_WordBreakProblemUsingBacktracking {


	public static List<String> wordBreakApproach1(String s, Set<String> wordDict) {
		ArrayList<String> [] pos = new ArrayList[s.length()+1];
		pos[0] = new ArrayList<String>();

		for(int i=0; i<s.length(); i++){
			if(pos[i] != null){
				for(int j=i+1; j<=s.length(); j++){
					String sub = s.substring(i,j);
					// if dictionary conatins this prefix, then
					// we check for remaining string. Otherwise
					// we ignore this prefix (there is no else for
					// this if) and try next
					if(wordDict.contains(sub)){
						// if no more elements are there, print it
						if(pos[j] == null){
							ArrayList<String> list = new ArrayList<String>();
							list.add(sub);
							pos[j]=list;
						}else{
							pos[j].add(sub);
						}
					}
				}
			}
		}

		if(pos[s.length()] == null){
			return new ArrayList<String>();
		}else{
			ArrayList<String> result = new ArrayList<String>();
			dfs(pos, result, "", s.length());
			return result;
		}
	}

	public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
		if(i == 0){
			result.add(curr.trim());
			return;
		}

		for(String s: pos[i]){
			String combined = s + " "+ curr;
			dfs(pos, result, combined, i-s.length());
		}
	}
	

	private static void wordBreakApproach2(String input, Set<String> dict) {
		wordutil(input, input.length(), "", dict);
	}

	private static void wordutil(String input, int n, String result, Set<String> dict) {

		for (int i = 1; i <= n; i++) {
			//extract substring from 0 to i in prefix
	        String prefix = input.substring(0, i);
	        // if dictionary conatins this prefix, then we check for remaining string. Otherwise
	        // we ignore this prefix (there is no else for this if) and try next
			if (dict.contains(prefix)) {
				 // if no more elements are there, print it
				if (i == n) {
					// add this element to previous prefix
					System.out.println(result + " " + input);
					break;
				} else {
					wordutil(input.substring(i, n), n - i, result + prefix + " ", dict);
				}
			}
		}
	}
	public static void main(String[] args) {
		
		String count[] = {"mobile","samsung","sam","sung","man","mango", "icecream","and",
				"go","i","love","ice","cream"};
		Set<String> dict = new HashSet<String>();
		for(int i = 0; i < count.length; i++) {
			dict.add(count[i]);
		}
		System.out.println("Approach1");
		System.out.println("First Test:");
		System.out.println(wordBreakApproach1("iloveicecreamandmango", dict));

		System.out.println("Second Test:");
		System.out.println(wordBreakApproach1("ilovesamsungmobile", dict));
		
		System.out.println("Approach2");
		System.out.println("First Test:");
		wordBreakApproach2("iloveicecreamandmango", dict);
		System.out.println();

		System.out.println("Second Test:");
		wordBreakApproach2("ilovesamsungmobile", dict);
		System.out.println();
		
	}
}
