package Easy;

/*
 * https://leetcode.com/problems/reformat-the-string/
 */
public class E_1417_ReformatString {

	public String reformat(String s) {
		int cntDigits = 0, cntAlpha = 0, len = s.length(), i = 0, dIdx = 0, lIdx = 0;
		char[] res = new char[len];

		// count digits and letters
		for (; i < len; i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				cntDigits++;
			} else {
				cntAlpha++;
			}
		}

		if (cntDigits - cntAlpha == 1 || cntDigits - cntAlpha == 0) {
			// we have more digits or equal
			lIdx = 1;
		} else if (cntAlpha - cntDigits == 1) {
			// we have more letters
			dIdx = 1;
		} else {
			return "";
		}

		for (i = 0; i < len; i++) {
			// digit
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				res[dIdx] = s.charAt(i);
				dIdx += 2;
			} else {
				// letter
				res[lIdx] = s.charAt(i);
				lIdx += 2;
			}
		}
		return new String(res);
	}

	public static void main(String[] args) {
		E_1417_ReformatString obj = new E_1417_ReformatString();
		System.out.println(obj.reformat("a0b1c2"));
		System.out.println(obj.reformat("leetcode"));
		System.out.println(obj.reformat("1229857369"));
		System.out.println(obj.reformat("covid2019"));
		System.out.println(obj.reformat("ab123"));
	}
}
