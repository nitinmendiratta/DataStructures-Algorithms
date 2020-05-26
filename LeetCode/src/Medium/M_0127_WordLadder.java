package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/word-ladder/
 */
public class M_0127_WordLadder {

	// Bidirectional Breadth First Search
	// Difficult to understand
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet();
		for(String word: wordList) {
			set.add(word);
		}
		if(!set.contains(endWord)) return 0;
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		set1.add(beginWord);
		set2.add(endWord);

		return helper(set, set1, set2, 1);
	}

	public int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
		if (set1.isEmpty()) return 0;

		if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

		// remove words from both ends
		for (String word : set1) { dict.remove(word); };
		for (String word : set2) { dict.remove(word); };

		// the set for next level
		Set<String> set = new HashSet<String>();

		// for each string in the current level
		for (String str : set1) {
			for (int i = 0; i < str.length(); i++) {
				char[] chars = str.toCharArray();

				// change letter at every position
				for (char ch = 'a'; ch <= 'z'; ch++) {
					chars[i] = ch;
					String word = new String(chars);

					// found the word in other end(set)
					if (set2.contains(word)) {
						return level + 1;
					}

					// if not, add to the next level
					if (dict.contains(word)) {
						set.add(word);
					}
				}
			}
		}

		return helper(dict, set2, set, level + 1);
	}
	/* https://leetcode.com/problems/word-ladder/discuss/40728/Simple-Java-BFS-solution-with-explanation
	 * BFS
	 * time complexity is O(N*M), where N is size of the dictionary and M is length
	 * of the word.
	 * 
	 * Details:
	 * 
	 * To generate neighbors - O(26 * M) To check if the word exists in dict - O(1).
	 * This is a reason why it is better to put all words to the Set. Note, that the
	 * original version of this problem uses List<String> wordList. It is a bit
	 * confusing since author changed the signature to Set<String> dict. To generate
	 * a tree and traverse the tree via BFS - O(N) So, the result is 
	 * O(26 * M * 1 * N) -> O(M * N)
	 */
	public int ladderLengthApproach2(String beginWord, String endWord, List<String> wordList) {
		// create set of word list so lookup is faster
		HashSet<String> set = new HashSet();
		for(String word: wordList) {
			set.add(word);
		}
		if(!set.contains(endWord)) return 0;

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int level = 0;

		while(!queue.isEmpty()){
			int size = queue.size();
			// loop over the queue and find words that are 1 edit distance apart of the current element and add it to queue
			for(int i = 0; i < size; i++){
				String cur = queue.remove();

				if(cur.equals(endWord))	return level + 1;

				for(int j = 0; j < cur.length(); j++){
					char[] word = cur.toCharArray();

					// find words that are 1 edit distance apart of the current element and present in the word list
					for(char ch = 'a'; ch < 'z'; ch++){
						word[j] = ch;
						String check = new String(word);
						if(!check.equals(cur) && wordList.contains(check)){
							queue.add(check);
							// remove from queue to avoid dup check as now we have already processed this element
							wordList.remove(check);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		M_0127_WordLadder obj = new M_0127_WordLadder();
		System.out.println(obj.ladderLength("hit", "cog", new ArrayList(Arrays.asList("hot","dot","dog","lot","log","cog"))));
	}

}
