package Greedy_Backtracking_PS_DnC;
import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 */
public class NaivePatternSearching {

	public ArrayList search(String s1, String s2){
		ArrayList result = new ArrayList();
		if(s1 == null || s2 == null || s1.length() < s2.length()) return result;
		int  i = 0, j = 0;
		
		for(i = 0;i < s1.length();i++){
			for(j = 0;j < s2.length();j++){
				if(((i+j) >= s1.length()) || (s1.charAt(i+j) != s2.charAt(j)))break;
				//else i++;
			}
			if(j == s2.length()) result.add(i);;
		}
		return result;
	}	
	
	public static void main(String[] args) {
		NaivePatternSearching obj = new NaivePatternSearching();
		String text = "AABAACAADAABAAABAA";
		String pat = "AABA";
		System.out.println("pattern found at index: "+obj.search(text,pat));
	}
}