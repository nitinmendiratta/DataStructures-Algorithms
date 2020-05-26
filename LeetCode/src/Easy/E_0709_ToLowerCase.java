package Easy;
/*
 * https://leetcode.com/problems/to-lower-case/
 */
public class E_0709_ToLowerCase {


	public String toLowerCase(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++)
			if ('A' <= a[i] && a[i] <= 'Z')
				a[i] = (char) (a[i] - 'A' + 'a');
		return new String(a);
	}

	public String toLowerCaseApproach2(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0, len = str.length();
		while(i < len){
			int curr = str.charAt(i);
			if(curr >= 65 && curr <= 90) {
				curr = curr + 32;
			}
			sb.append((char) (curr));
			i++;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		E_0709_ToLowerCase obj = new E_0709_ToLowerCase();
		System.out.println(obj.toLowerCase("LOVELY"));
	}
}
