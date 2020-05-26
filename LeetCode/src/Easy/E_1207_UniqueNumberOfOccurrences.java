package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class E_1207_UniqueNumberOfOccurrences {

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int a : arr)
			count.put(a, 1 + count.getOrDefault(a, 0));
		
		return count.size() == new HashSet<>(count.values()).size();
	}
	public static void main(String[] args) {
		E_1207_UniqueNumberOfOccurrences obj = new E_1207_UniqueNumberOfOccurrences();
		System.out.println(obj.uniqueOccurrences(new int[] {1,2,2,1,1,3}));
	}
}
