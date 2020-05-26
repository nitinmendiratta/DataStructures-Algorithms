package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/word-pattern/
 */
public class E_0290_WordPattern {

	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> hm = new HashMap();
		String[] strArr = str.split(" ");
		int i = 0, len = pattern.length();
		if(strArr.length != len){
			return false;
		}
		while(i < len){
			char currChar = pattern.charAt(i);
			String currStr = strArr[i];
			if(hm.containsKey(currChar)){
				String val = hm.get(currChar);
				if(!currStr.equals(val)) return false;
			}
			else if(hm.containsValue(currStr)) return false;
			else hm.put(currChar, currStr);
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		E_0290_WordPattern obj = new E_0290_WordPattern();
		System.out.println(obj.wordPattern("abba", "dog dog dog dog"));
	}
}
