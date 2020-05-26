package Medium;
import java.util.*;
/*
 * S102: http://www.geeksforgeeks.org/String-with-additive-sequence/
 * http://www.programmeronrails.com/2015/12/15/leetcode-additive-number/
 * M_306: https://leetcode.com/problems/additive-number/
 */
public class M_0306_AdditiveNumber {

	public boolean isAdditiveNumber(String num) {

		// we only need to check the leading 2n/3 digits as
		// the length of the sum is at least num.length()/3
		// EX: s1=1000 (4 digits)
		// s2=123 (3 digits)
		// sum=1123 (4 digits)
		for (int i = 2; i <= 2 * num.length() / 3; i++) {

			for (int j = 1; j < i; j++) {
				if (isValid(num, j, i))
					return true;
			}
		}
		return false;
	}

	// check if the addictive sequence ahead
	// with num[0..j) and num[j..i) matches the string
	private boolean isValid(String num, int j, int i) {
		String s1 = num.substring(0, j); // excluding j
		String s2 = num.substring(j, i); // including j and excluding i
		int sumStart = i;
		while (sumStart < num.length()) {

			// if the s1 or s2 have leading 0 they are not valid
			if (s1.length() > 1 && s1.charAt(0) == '0')
				return false;
			if (s2.length() > 1 && s2.charAt(0) == '0')
				return false;

			String sum = add(s1, s2);
			int sumEnd = sumStart + sum.length();
			
			

			// if the sum is shorter than the next possible number
			if (sumEnd > num.length())
				return false;

			String match = num.substring(sumStart, sumEnd);
			
			//System.out.println(s1+","+s2+","+sum+","+match);

			// if the sum does not match the next number continue outer loop for other potential match
			if (!sum.equals(match))
				return false;

			s1 = s2;
			s2 = sum;

			sumStart = sumEnd;
		}

		return true;
	}

	// If s1 and s2 are very large numbers, we only need to rewrite the add(s1,s2) method.
	// Here we use the BigInteger class in java to handle big integers.
	private String add(String s1, String s2) {
		/*
		 * BigInteger a = new BigInteger(s1); BigInteger b = new BigInteger(s2);
		 * BigInteger result = a.add(b);
		 */
		return String.valueOf(Long.valueOf(s1) + Long.valueOf(s2));
	}

	public static void main(String[] args) {
		M_0306_AdditiveNumber obj = new M_0306_AdditiveNumber();
		String num = "23581320";
		System.out.println(obj.isAdditiveNumber(num));
		num = "199100";
		System.out.println(obj.isAdditiveNumber(num));
	}
}
