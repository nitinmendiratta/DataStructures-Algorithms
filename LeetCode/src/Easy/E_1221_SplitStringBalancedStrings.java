package Easy;
/*
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class E_1221_SplitStringBalancedStrings {

	public int balancedStringSplit(String s) {
		
		char prevChar = s.charAt(0);
		int res = 0, count = 1;
		
		for(int i = 1; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(curr != prevChar)count--;
			else count++;
			
			// We completed one balance string so reset counts
			if(count == 0) {
				res++;
				i++;
				if(i < s.length()) prevChar = s.charAt(i);
				count = 1;
			}
		}
		return res;
    }
	public static void main(String[] args) {
		E_1221_SplitStringBalancedStrings obj = new E_1221_SplitStringBalancedStrings();
		System.out.println(obj.balancedStringSplit("RLRRLLRLRL"));
		System.out.println(obj.balancedStringSplit("RLLLLRRRLR"));
		System.out.println(obj.balancedStringSplit("LLLLRRRR"));
		System.out.println(obj.balancedStringSplit("RLRRRLLRLL"));
		System.out.println(obj.balancedStringSplit("LLLLLR"));
	}
}
