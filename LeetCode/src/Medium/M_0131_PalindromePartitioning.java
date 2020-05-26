package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class M_0131_PalindromePartitioning {

	public List<List<String>> partition(String str) {
		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), str, 0);
		return list;
	}

	public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
		if(start == s.length()) {
			list.add(new ArrayList<>(tempList));
			return;
		}

		for(int i = start; i < s.length(); i++){
			//System.out.println("checking : "+s.substring(start, i + 1));

			if(isPalindrome(s, start, i)){
				//System.out.println("Adding: "+s.substring(start, i + 1));
				tempList.add(s.substring(start, i + 1));
				backtrack(list, tempList, s, i + 1);
				//System.out.println("removing: "+tempList.get(tempList.size() - 1));
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s, int low, int high){
		while(low < high)
			if(s.charAt(low++) != s.charAt(high--)) return false;
		return true;
	}

	public static void main(String[] args) {
		M_0131_PalindromePartitioning obj = new M_0131_PalindromePartitioning();
		List<List<String>> res = obj.partition("aab");
		System.out.println(res);
	}
}
