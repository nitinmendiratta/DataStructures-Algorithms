package Easy;
/*
 * https://leetcode.com/problems/count-binary-substrings/
 */
public class E_0696_CountBinarySubstrings {

	/*
	 * Let's take an example, 00011 here currentLength will become 1 -> 2 ->3 because bits at index 0, 1 and 2 are same i.e. 0's. 
	 * Then we encounter a 1 bit and at this point we reset the currLength and store it in prevLength. 
	 * 
	 * The most interesting part is in last if block, where result is incremented. 
	 * When we are at index 3 i.e. first 1 bit then we would have seen substring 0001 and
	 * at this point 01 qualifies as a substring that could be counted towards the final result, so we increment the res. 
	 * 
	 * Similarly, when we encounter 2nd 1 bit at that point we would have seen substring 00011 and 0011 also qualifies as a
	 * substring that could be counted towards the final result, so we increment the
	 * res. 
	 * Therefore, result is 2.
	 */
	public int countBinarySubstrings(String s) {
		int prevRunLength = 0, curRunLength = 1, res = 0;
		for (int i=1;i<s.length();i++) {
			if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
			else {
				prevRunLength = curRunLength;
				curRunLength = 1;
			}
			if (prevRunLength >= curRunLength) res++;
		}
		return res;
	}
	public static void main(String[] args) {
		E_0696_CountBinarySubstrings obj = new E_0696_CountBinarySubstrings();
		System.out.println(obj.countBinarySubstrings("00110011"));
	}
}
