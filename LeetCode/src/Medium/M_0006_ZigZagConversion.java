package Medium;
/*
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class M_0006_ZigZagConversion {

	// Create nRows StringBuffers, and keep collecting characters from original string to corresponding StringBuffer. 
	// Just take care of your index to keep them in bound.
	// https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
	// https://leetcode.com/problems/zigzag-conversion/discuss/3435/If-you-are-confused-with-zigzag-patterncome-and-see!
	public String convert(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuffer[] sb = new StringBuffer[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        // 2nd elem of 2nd last buffer
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    // merge all the SBs
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}
	
	
	// Difficult approach
	public String convertApproach2(String s, int nRows) {
		if (nRows == 1)		return s;
		StringBuilder builder = new StringBuilder();
		int step = 2 * nRows - 2;
		for (int i = 0; i < nRows; i++) {
			if (i == 0 || i == nRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					builder.append(s.charAt(j));
				}
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (nRows - 1 - i);
				int step2 = step - step1;
				while (j < s.length()) {
					builder.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		M_0006_ZigZagConversion obj = new M_0006_ZigZagConversion();
		System.out.println(obj.convert("PAYPALISHIRING", 3));
	}
}
