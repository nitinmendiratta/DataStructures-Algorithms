package Easy;
/*
 * https://leetcode.com/problems/add-strings/
 */
public class E_0415_AddStrings {

	public String addStrings(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
        int i = len1-1, j = len2-1, carry = 0, sum = 0, rem = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry != 0){
            int a = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int b = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            rem = sum%10;
            sb.append(rem);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		E_0415_AddStrings obj = new E_0415_AddStrings();
		System.out.println(obj.addStrings("1111", "9"));
	}
}
