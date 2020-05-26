package Medium;
import java.util.*;

/*
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class M_0388_LongestAbsoluteFilePath {

	/*  Credit: https://leetcode.com/problems/longest-absolute-file-path/discuss/389124/Simple-or-easy-to-understand-with-explanation-or-JAVA
	 * https://www.youtube.com/watch?v=EtmOdDYrU0U
		1. Split the string by '\n'
		2. Find the last index of '\t' { last because a sub-string may contain multiple '\t' but as above question they effectively a single sub-dir or file}
		3. Compute the remaining length of string without '\t'
		4. Check does this is a file or not
			a) if a sub-dir, than append its length to just higher level sub-dir
			b) if its a file, compute the length of string for this file. To compute, get the level at this file is and add the length of the file
		
		Time Complexity : O(n) where n is length of given string { lastIndexOf takes O(L) time and contains take O(L) time. In worst case, there is no \n and we run both in O(n) time}
		Space: O(h) where h represent levels of string h~=n
	 */
	   public int lengthLongestPath(String input) {

		if (input == null || input.isEmpty())
			return 0;

		int maxLength = 0; // if may possible the string does not contain any file at all hence 0

		// to keep the length of every sub-dir at same level. It stores length of string
		// at each level
		Map<Integer, Integer> levelVsLength = new HashMap<>();

		levelVsLength.putIfAbsent(0, 0); // empty level will have 0 length string

		// 1. Split the string by '\n'
		String[] string = input.split("\n");

		for (String s : string) {

			// 2. Find the last index of '\t' { last because a sub-string may contain
			// multiple '\t' but as above question they effectively a single sub-dir or file}
			int tabIndexLevel = s.lastIndexOf('\t') + 1; // this will return the index of '\' if '\t' present, to make
															// index of '\t' we add 1. It also play well when there is
															// no '\t' then it makes level 0

			// 3. Compute the remaining length of string without '\t'
			int len = s.length() - tabIndexLevel;

			// 4. Check file or not
			if (!s.contains(".")) {
				// a) if a sub-dir, then add its length to just prev level sub-dir
				levelVsLength.put(tabIndexLevel + 1, levelVsLength.get(tabIndexLevel) + len + 1);
			} else {
				// b) if its a file, compute the length of string for this file. To compute, get
				// the level at this file is and add the length of the file
				maxLength = Math.max(maxLength, levelVsLength.get(tabIndexLevel) + len);
			}
		}
		return maxLength;

	   }

	   
	   //Using stack
	public int lengthLongestPathApproach2(String input) {

		if (input == null || input.isEmpty())
			return 0;

		int maxLength = 0; // if may possible the string does not contain any file at all hence 0

		// to keep the length of every sub-dir at same level. It stores length of string
		// at each level
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // empty level will have 0 length string

		// 1. Split the string by '\n'
		String[] string = input.split("\n");

		for (String s : string) {

			// 2. Find the last index of '\t' { last because a sub-string may contain
			// multiple '\t' but as above question they effectively a single sub-dir or file}
			int tabIndexLevel = s.lastIndexOf('\t') + 1; // this will return the index of '\' if '\t' present, to make
															// index of '\t' we add 1. It also play well when there is
															// no '\t' then it makes level 0

			// 3. Compute the remaining length of string without '\t'
			int len = s.length() - tabIndexLevel;

			// remove all the level which is bigger than this because we must have evaluate
			// the sub-string size by them
			while (stack.size() > tabIndexLevel + 1)
				stack.pop();

			// 4. Check does this is a file or not
			if (!s.contains(".")) {
				// a) if a sub-dir, than append its length to just higher level sub-dir
				stack.push(stack.peek() + len + 1);
			} else {
				// b) if its a file, compute the length of string for this file. To compute, get
				// the level at this file is and add the length of the file
				maxLength = Math.max(maxLength, stack.peek() + len);
			}
		}
		return maxLength;

	}
	public static void main(String[] args) {
		M_0388_LongestAbsoluteFilePath obj = new M_0388_LongestAbsoluteFilePath();
		System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

	}

}
