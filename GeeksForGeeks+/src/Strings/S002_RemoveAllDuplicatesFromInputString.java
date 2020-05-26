package Strings;
import java.util.*;
/*
 * https://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
 * Time Complexity: O(n)
 */
public class S002_RemoveAllDuplicatesFromInputString {

	public String removeDuplicateString(final String input){
	
		final Set<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < input.length(); i++)
			set.add(input.charAt(i));
			
		final StringBuilder sb = new StringBuilder(set.size());
		for (final Character c : set)
			sb.append(c);
			
		return sb.toString();
	}

	public static void main(String[] args) {
		S002_RemoveAllDuplicatesFromInputString obj = new S002_RemoveAllDuplicatesFromInputString();
		String s = "geeksforgeeks";
		System.out.println("New String after removing dup is: "+obj.removeDuplicateString(s));
	}
}
