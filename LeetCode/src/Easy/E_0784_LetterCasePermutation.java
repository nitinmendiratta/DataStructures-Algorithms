package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class E_0784_LetterCasePermutation {

	/* BFS Solution
	 *       DummyNode
			  /      \
		     a         A
		   /   \      / \
		  ab    aB   Ab AB
		/   \   / \     / \ 
		abc abC................................
		
	Obviously our goal here will be printing out all leaf nodes, which we can accomplished by using DFS with backTracking or BFS. Hope this helps
	 */
	public List<String> letterCasePermutation(String S) {
		if (S == null) {
			return new LinkedList<>();
		}
		Queue<String> queue = new LinkedList<>();
		// add the whole string in the queue
		queue.offer(S);

		for (int i = 0; i < S.length(); i++) {
			
			// ignore if any integer
			if (Character.isDigit(S.charAt(i))) continue; 
			
			// run loop only till size of queue
			int size = queue.size();
			
			// for each loop we will change 1 char to upper/lower using i as index
			for (int j = 0; j < size; j++) {
				// will give you abc for first run
				String cur = queue.poll();
				// convert abc to char Array
				char[] chs = cur.toCharArray();

				// convert first char to upper case ie Abc and add it to queue
				chs[i] = Character.toUpperCase(chs[i]);
				queue.offer(String.valueOf(chs));

				// convert first char to lower case ie abc and add it to queue
				chs[i] = Character.toLowerCase(chs[i]);
				queue.offer(String.valueOf(chs));
				
				// now we have Abc and abc in queue
				// 2nd run we will have 
				//	1. when we take out Abc it will put ABc and Abc as i will point to 1 index
				//	2. when we take out abc it will put aBc and abc as i will point to 1 index
			}
		}

		return new LinkedList<>(queue);
	}

	// DFS Solution
	public List<String> letterCasePermutationDFS(String S) {
		if (S == null) {
			return new LinkedList<>();
		}

		List<String> res = new LinkedList<>();
		helper(S.toCharArray(), res, 0);
		return res;
	}

	public void helper(char[] chs, List<String> res, int pos) {
		if (pos == chs.length) {
			res.add(new String(chs));
			return;
		}
		if (chs[pos] >= '0' && chs[pos] <= '9') {
			helper(chs, res, pos + 1);
			return;
		}
		
		chs[pos] = Character.toUpperCase(chs[pos]);
		helper(chs, res, pos + 1);

		chs[pos] = Character.toLowerCase(chs[pos]);
		helper(chs, res, pos + 1);
	}

	public static void main(String[] args) {
		E_0784_LetterCasePermutation obj = new E_0784_LetterCasePermutation();
		System.out.println(obj.letterCasePermutation("abc"));
	}
}
