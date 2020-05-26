package Easy;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class E_0387_FirstUniqueCharacter {

	public int firstUniqChar(String s) {
		int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
	}
	
	// approach2
	public int firstUniqCharApproach2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
	// approach3
	public int firstUniqCharApproach3(String s) {
        int result = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) == -1) continue;
            if (s.indexOf(c) == s.lastIndexOf(c))  result = Math.min(result, s.indexOf(c));
        }
        return result == s.length() ? -1 : result;
    }
	public static void main(String[] args) {
		E_0387_FirstUniqueCharacter obj = new E_0387_FirstUniqueCharacter();
		System.out.println(obj.firstUniqChar("loveleetcode"));
		System.out.println(obj.firstUniqCharApproach2("loveleetcode"));
		System.out.println(obj.firstUniqCharApproach3("loveleetcode"));
	}
}
