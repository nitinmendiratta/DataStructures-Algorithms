package Medium;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * M_003: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class M_0003_LongestSubstringWithoutRepeatingCharacters {


	/*
	 * the basic idea is, keep a hashmap which stores the characters in string as
	 * keys and their positions as values, and keep two pointers which define the
	 * max substring. move the right pointer to scan through the string , and
	 * meanwhile update the hashmap. If the character is already in the hashmap,
	 * then move the left pointer to the right of the same character last found.
	 * Note that the two pointers can only move forward.

	 * Time complexity : O(n). Index j will iterate n times.
	 * Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
	 * Space complexity (Table): O(m). m is the size of the charset.
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), maxLen = 0;
		// a map to store key as char and value as its current index
		Map<Character, Integer> map = new HashMap<>();

		for (int currIdx = 0, leftPtr = 0; currIdx < n; currIdx++) {
			// if curr char already seen before update the left ptr to be prev idx + 1
			if (map.containsKey(s.charAt(currIdx))) {
				int prevIdx = map.get(s.charAt(currIdx));
				// max needed because we can have curr char to be dup of a char even before leftptr in that case we dont want to move our left ptr back to start
				leftPtr = Math.max(prevIdx+1, leftPtr);
			}

			maxLen = Math.max(maxLen, currIdx - leftPtr + 1);
			map.put(s.charAt(currIdx), currIdx);
		}
		return maxLen;
	}

	static final int NO_OF_CHARS = 256; 
	public static int lengthOfLongestSubstringApproach2(String str) { 
		int n = str.length(); 
		if(n == 0) return 0;
		int cur_len = 1;    // length of current substring 
		int max_len = 1;    // result 
		int prev_index;        //  previous index 
		int i; 
		int visited[] = new int[NO_OF_CHARS]; 

		/* Initialize the visited array as -1, -1 is used to indicate that character has not been visited yet. */
		for (i = 0; i < NO_OF_CHARS; i++) { 
			visited[i] = -1; 
		} 

		/* Mark first character as visited by storing the index of first character in visited array. */
		visited[str.charAt(0)] = 0; 

		/* Start from the second character. First character is already processed (cur_len and max_len are initialized 
         as 1, and visited[str[0]] is set */
		for(int currIdx = 1; currIdx < n; currIdx++) { 
			prev_index = visited[str.charAt(currIdx)]; 

			/* If the current character is not present in the already processed substring or it is not 
              part of the current NRCS, then do cur_len++ */
			if(prev_index == -1 || currIdx - cur_len > prev_index) 
				cur_len++; 

			/* If the current character is present in currently considered NRCS, then update NRCS to start from 
               the next character of previous instance. */
			else{ 
				/* Also, when we are changing the NRCS, we should also check whether length of the 
                   previous NRCS was greater than max_len or not.*/
				max_len = Math.max(cur_len, max_len);

				cur_len = currIdx - prev_index; 
			} 

			// update the index of current character 
			visited[str.charAt(currIdx)] = currIdx; 
		} 

		// Compare the length of last NRCS with max_len and update max_len if needed 
		max_len = Math.max(cur_len, max_len);

		return max_len; 
	} 

	public static void main(String[] args) {
		M_0003_LongestSubstringWithoutRepeatingCharacters obj = new M_0003_LongestSubstringWithoutRepeatingCharacters();
		String text = "GEEKSFORGEEKS";
		System.out.println("Longest Substring: "+obj.lengthOfLongestSubstring(text));
		System.out.println("Longest Substring: "+obj.lengthOfLongestSubstringApproach2(text));
	}
}
