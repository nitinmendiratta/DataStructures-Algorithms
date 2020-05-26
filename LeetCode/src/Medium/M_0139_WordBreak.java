package Medium;
import java.util.*;
import Helper.*;

/*
 * https://leetcode.com/problems/word-break/
 * https://www.youtube.com/watch?v=hLQYQ4zj0qg
 */
public class M_0139_WordBreak {

	/*
	 * SOLUTION 1: Difficult, dp dp[i] represents if substring (0,i) is breakable. for each
	 * longer substring, we just need to check
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		
		if (s.length() == 0)
			return false;

		boolean[] breakable = new boolean[s.length() + 1];
		breakable[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (breakable[j] && wordDict.contains(s.substring(j, i))) {
					breakable[i] = true;
					break;
				}
			}
		}
		// for(boolean b : breakable) System.out.print(b + ", ");
		return breakable[s.length()];
	}

	/*
	 * SOLUTION 2: DFS use a set to record the substring (i, s.length) that is not
	 * breakable start from the front, try to see if the substring (0,i) is in the
	 * dict, if so, recursively check if there is a way to break (i, s.length)
	 */
	// O(2^n)
	public boolean wordBreakApproach2(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		HashMap<String, Boolean> map = new HashMap<>();
		return wordBreakHelper(s, wordDictSet, map);
	}

	public boolean wordBreakHelper(String s, Set<String> wordDictSet, HashMap<String, Boolean> map) {

		if (s.equals("")) {
			return true;
		}

		if (map.containsKey(s))
			return map.get(s);

		for (int i = 1; i <= s.length(); i++) {
			if (wordDictSet.contains(s.substring(0, i))
					&& wordBreakHelper(s.substring(i, s.length()), wordDictSet, map)) {
				map.put(s.substring(i), true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}

	/*
	 * SOLUTION 3: BFS Idea is to try to chop off prefix of s that is in the dict
	 * enqueue the left-over of each chop off if there is a time the left over
	 * happens to be in the dict as well we know word is breakable, b/c all the
	 * previous chops are all in the dict otherwise the original world is not
	 * breakable.
	 * 
	 * we can use a set to store all the leftovers that we have tried, to avoid
	 * enqueue the same leftover multiple times.
	 * 
	 */
	public boolean wordBreakApproach3(String s, List<String> wordDict) {
		
		if (s.length() == 0)
			return false;
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(s);
		Set<String> visited = new HashSet<String>();
		
		while (!queue.isEmpty()) {
			String candidate = queue.poll();
			if (wordDict.contains(candidate))	return true;
			
			for (int i = 0; i < candidate.length(); i++) {
				String chop = candidate.substring(0, i);
				String next = candidate.substring(i, candidate.length());
				
				if (!visited.contains(next) && wordDict.contains(chop)) {
					next = candidate.substring(i, candidate.length());
					queue.offer(next);
					visited.add(next);
				}
			}
		}
		return false;
	}

	/* SOLUTION 4: TRIE + MAP */
	public boolean wordBreakApproach4(String s, List<String> wordDict) {
		
		if (s.length() == 0)
			return false;

		Trie trie = new Trie();
		for (String d : wordDict) {
			trie.insert(d);
		}
		List<String> prefix = findPrefix(trie, s);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (String split : prefix) {
			if (canBeSplitted(trie, s.replaceFirst(split, ""), map)) {
				map.put(split, true);
				return true;
			}
		}
		return false;
	}

	private boolean canBeSplitted(Trie root, String input, Map<String, Boolean> map) {
		if (map.containsKey(input))
			return map.get(input);
		if (root.search(input) || input.length() == 0)
			return true;
		List<String> prefix = findPrefix(root, input);
		for (String s : prefix) {
			String copy = new String(input);
			if (canBeSplitted(root, copy.replaceFirst(s, ""), map)) {
				map.put(input, true);
				return true;
			}
		}
		map.put(input, false);
		return false;
	}

	private List<String> findPrefix(Trie root, String input) {
		char[] split = input.toCharArray();
		List<String> result = new ArrayList<String>();
		TrieNode pointer = root.root;
		for (int i = 0; i < split.length; i++) {
			pointer = pointer.children[split[i] - 'a'];
			if (pointer == null)
				break;
			if (pointer.word != null)
				result.add(pointer.word);
		}
		return result;
	}

	public static void main(String[] args) {
		M_0139_WordBreak obj = new M_0139_WordBreak();
		System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
		System.out.println(obj.wordBreakApproach2("leetcode", Arrays.asList("leet", "code")));
		System.out.println(obj.wordBreakApproach3("leetcode", Arrays.asList("leet", "code")));
		System.out.println(obj.wordBreakApproach4("leetcode", Arrays.asList("leet", "code")));
		System.out.println(obj.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(obj.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
		System.out.println(obj.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
						"aaaaaaaaaa")));
	}
}
