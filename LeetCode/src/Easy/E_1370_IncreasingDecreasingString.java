package Easy;
import java.util.*;

public class E_1370_IncreasingDecreasingString {

	public String sortString(String s) {
		StringBuilder ans = new StringBuilder();
		int[] count = new int[26];
		
		for (char c : s.toCharArray())
			++count[c - 'a'];
		
		while (ans.length() < s.length()) {
			add(count, ans, true);
			add(count, ans, false);
		}
		return ans.toString();
	}
	private void add(int[] cnt, StringBuilder ans, boolean asc) {
		/*
		 * if asc true means 
		 * Pick the smallest character from s and append it to the result.
		 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
		 * 
		 * if asc false
		 * Pick the largest character from s and append it to the result.
		 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
		 */
		for (int i = 0; i < 26; ++i) {
			int j = asc ? i : 25 - i;
			if (cnt[j]-- > 0)
				ans.append((char)(j + 'a'));
		}
	}
	
	/*
	 * Use TreeMap to count each char in s; Append to StringBuilder the keys in
	 * TreeMap in sorted order, decrease the count of each key, and remove the entry
	 * if reaching 0; 
	 * Do the similar operation in step 2, but in descending order of the keys; 
	 * Repeat 2 and 3 till the TreeMap is empty.
	 */
	public String sortStringApproach2(String s) {
		StringBuilder ans = new StringBuilder();
		TreeMap<Character, Integer> tm = new TreeMap<>();
		
		for (char c : s.toCharArray()) {
			tm.put(c, 1 + tm.getOrDefault(c, 0));
		}
		boolean asc = true;
		while (!tm.isEmpty()) {
			TreeSet<Character> ts = asc ? new TreeSet<>(tm.keySet()) : new TreeSet(tm.descendingKeySet());
			
			for (char c : ts) {
				ans.append(c);
				tm.put(c, tm.get(c) - 1);
				tm.remove(c, 0);
			}
			asc = !asc; // same as asc ^= true;
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		E_1370_IncreasingDecreasingString obj = new E_1370_IncreasingDecreasingString();
		System.out.println(obj.sortString("aaaabbbbcccc"));
		System.out.println(obj.sortStringApproach2("aaaabbbbcccc"));
	}
}
