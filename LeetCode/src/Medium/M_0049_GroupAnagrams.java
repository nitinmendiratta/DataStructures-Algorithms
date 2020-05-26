package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/group-anagrams/
 */
public class M_0049_GroupAnagrams {


	/*
	 * Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs. 
	 * Counting each string is linear in the size of the string, and we count every string.
	 * 
	 * Space Complexity: O(NK), the total information content stored in ans.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key)) ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	/*
	 * Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. 
	 * The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
	 * 
	 * Space Complexity: O(NK), the total information content stored in ans.
	 */
	public List<List<String>> groupAnagramsApproach2(String[] strs) {
		if (strs.length == 0) return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key)) ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	public static void main(String[] args) {
		M_0049_GroupAnagrams obj = new M_0049_GroupAnagrams();
		List<List<String>> res = obj.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		for(List<String> temp : res) {
			System.out.println(Arrays.toString(temp.toArray()));
		}
	}
}
