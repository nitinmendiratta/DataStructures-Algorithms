package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/find-all-strings-that-match-specific-pattern-in-a-dictionary/
 */
public class S093_FindAllStringsThatMatchSpecificPatternInaDictionary {

	public static ArrayList<String> match(String[] dict,String pattern){
		ArrayList<String> retVal=new ArrayList<>();
		int[] rule=makePatternRules(pattern);
		for(int i=0;i<dict.length;i++){
			int[] arr=makePatternRules(dict[i]);
			if(Arrays.equals(arr, rule)){
				retVal.add(dict[i]);
			}
		}
		return retVal;
	}
	public static int[] makePatternRules(String pattern){
		HashMap<Character,Integer> map=new HashMap<>();
		int[] rule=new int[pattern.length()];
		for(int i=0;i<pattern.length();i++){
			if(!map.containsKey(pattern.charAt(i))){
				map.put(pattern.charAt(i), i);
			}
			rule[i]=map.get(pattern.charAt(i));
		}
		return rule;
	}
	public static void main(String[] args) {
		String pat="foo";
		String[] dict={"abb", "abc", "xyz", "xyy"};
		ArrayList<String> ans=match(dict, pat);
		System.out.println(ans);
		
		String[] dict2 = {"abb", "abc", "xyz", "xyy"};
		pat = "mno";
		ans=match(dict2, pat);
		System.out.println(ans);
		
		String[] dict3 = {"abb", "abc", "xyz", "xyy"};
		pat = "aba";
		ans=match(dict3, pat);
		System.out.println(ans);
		
		String[] dict4 = {"abab", "aba", "xyz", "xyx"};
		pat = "aba";
		ans=match(dict4, pat);
		System.out.println(ans);
	}
}
