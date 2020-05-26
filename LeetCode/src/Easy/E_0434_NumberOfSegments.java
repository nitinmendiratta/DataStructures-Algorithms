package Easy;
/*
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class E_0434_NumberOfSegments {

	/*
	 * Time complexity : O(n)
	 * We do a constant time check for each of the string's nn indices, so the runtime is overall linear.
	 * Space complexity : O(1)
	 * There are only a few integers allocated, so the memory footprint is constant.
	 */
	public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
	public static void main(String[] args) {
		E_0434_NumberOfSegments obj = new E_0434_NumberOfSegments();
		System.out.println(obj.countSegments("Hello, my name is John"));
	}
}
