package Easy;
import java.util.HashMap;
/*
 * https://leetcode.com/problems/valid-anagram/
 */
public class E_0242_ValidAnagram {

	public boolean isAnagram(String s, String t) {

		HashMap<Character, Integer> smap = new HashMap<>();
		int sl = s.length();
		int tl = t.length();
		if(sl != tl){
			return false;
		}
		for(int i = 0; i < sl; i++){
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) +1);
			smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) -1);
		}
		for(char c:smap.keySet()){
			if(smap.get(c) != 0){
				return false;
			}
		}
		return true;
	}
	// if range of char is less
	public boolean isAnagramApproach2(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] table = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        table[s.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < t.length(); i++) {
	        table[t.charAt(i) - 'a']--;
	        if (table[t.charAt(i) - 'a'] < 0) {
	            return false;
	        }
	    }
	    return true;
	}
	public static void main(String[] args) {
		E_0242_ValidAnagram obj = new E_0242_ValidAnagram();
		System.out.println(obj.isAnagram("anagram", "nagaram"));
		System.out.println(obj.isAnagramApproach2("anagram", "nagaram"));
	}
}
