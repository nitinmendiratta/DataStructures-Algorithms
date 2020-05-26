package Easy;
/*
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class E_1071_GCD_Strings {

	public String gcdOfStrings(String str1, String str2) {
		
		if (!(str1+str2).equals(str2+str1)) {
			return "";
		}
		int len = str1.length();
		int len2 = str2.length();
		int gcd = getGcd(len, len2);
		if (len < len2) {
			return str1.substring(0, gcd);
		}
		return str2.substring(0, gcd);
	}
	public int getGcd(int x, int y) {
		return x == 0 ? y : getGcd(y%x, x);
	}
	public static void main(String[] args) {
		E_1071_GCD_Strings obj = new E_1071_GCD_Strings();
		System.out.println(obj.gcdOfStrings("ABC", "ABC"));
	}
}
