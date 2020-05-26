package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class E_0205_IsomorphicStrings {

	public boolean isIsomorphic(String sString, String tString) {

		char[] s = sString.toCharArray();
		char[] t = tString.toCharArray();

		int length = s.length;

		char[] sm = new char[256];
		char[] tm = new char[256];

		for(int i = 0; i < length; i++){
			char sc = s[i];
			char tc = t[i];
			if(sm[sc] == 0 && tm[tc] == 0){
				sm[sc] = tc;
				tm[tc] = sc;
			}else{
				if(sm[sc] != tc || tm[tc] != sc){
					return false;
				}
			}
		}
		return true;
	}
	public boolean isIsomorphicApproach2(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();
		if(len1 != len2){
			return false;
		}
		HashMap<Character, Character> hm = new HashMap();
		int i = 0;
		while(i < len1){
			char a = s.charAt(i);
			char b = t.charAt(i);
			if(hm.containsKey(a)){
				char prev = hm.get(a);
				if(prev != b){
					return false;
				}
			}else if(hm.containsValue(b)){
				return false;
			}
			hm.put(a, b);
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		E_0205_IsomorphicStrings obj = new E_0205_IsomorphicStrings();
		System.out.println(obj.isIsomorphic("aa", "ab"));
		System.out.println(obj.isIsomorphicApproach2("aa", "ab"));
	}

}
