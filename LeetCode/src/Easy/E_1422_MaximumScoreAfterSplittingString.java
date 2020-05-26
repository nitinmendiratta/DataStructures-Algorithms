package Easy;
/*
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class E_1422_MaximumScoreAfterSplittingString {

	public int maxScore(String s) {
		int ls = 0, rs = 0, max = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				rs++;
		}

		for (int i = 0; i < s.length()-1; i++) {
			if (s.charAt(i) == '0')
				ls++;
			else
				rs--;

			max = Math.max(max, ls + rs);
		}
		return max;
	}

	public static void main(String[] args) {
		E_1422_MaximumScoreAfterSplittingString obj = new E_1422_MaximumScoreAfterSplittingString();
		System.out.println(obj.maxScore("011101"));
		System.out.println(obj.maxScore("00111"));
		System.out.println(obj.maxScore("1111"));
	}
}
