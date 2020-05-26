package Greedy_Backtracking_PS_DnC;
import java.lang.reflect.Array;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
 * http://www.lifeincode.net/programming/leetcode-palindrome-partitioning-i-and-iijava/
 */
public class ReturnAllPossiblePalindromePartitioning {

	public ArrayList<ArrayList<String>> partition1(String s) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0)	return result;
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
		return result;
	}

	private void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result){
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}

	/*public List<List<String>> partition2(String s) {
		int n = s.length();
		boolean[][] isPalindrome = new boolean[n][n];
		for (int i = 0; i < n; i++)
			isPalindrome[i][i] = true;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 2 || isPalindrome[i + 1][j - 1])
						isPalindrome[i][j] = true;
				}
			}
		}
		
		List<List<String>>[] palindromes = (List<List<String>>[])Array.newInstance(List.class, n + 1);
		palindromes[n] = (List)(new LinkedList<List<String>>());
		List<String> emptyList = new LinkedList<>();
		palindromes[n].add(emptyList);
		for (int i = n - 1; i >= 0; i--) {
			palindromes[i] = (List)(new LinkedList<List<String>>());
			for (int j = i; j < n; j++) {
				if (isPalindrome[i][j]) {
					List<List<String>> lists = palindromes[j + 1];
					String substring = s.substring(i, j + 1);
					for (List<String> list : lists) {
						List<String> newList = new LinkedList<>();
						newList.add(substring);
						newList.addAll(list);
						palindromes[i].add(newList);
					}
				}
			}
		}
		return palindromes[0];
	}
*/
	public static void main(String[] args) {
		ReturnAllPossiblePalindromePartitioning obj = new ReturnAllPossiblePalindromePartitioning();
		int j = 1;
		for(List<String> result : obj.partition1("nitin")){
			System.out.println((j++)+"set:");
			for(int i = 0;i < result.size();i++){
				System.out.print(result.get(i)+",");
			}
			System.out.println();
		}
	}
}
