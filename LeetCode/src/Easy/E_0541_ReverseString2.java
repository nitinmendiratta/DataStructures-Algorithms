package Easy;
/*
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class E_0541_ReverseString2 {
	
	public String reverseStr(String s, int k) {
		int len = s.length(), i = 0, j = 0, r = 0;
		char[] a = s.toCharArray();
		while(i < len){
			j = Math.min(i + k - 1, len - 1);
			r = i + 2*k;
			while(i < j){
				char temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
			i = r;
		}
		return new String(a);
	}
	public static void main(String[] args) {
		E_0541_ReverseString2 obj = new E_0541_ReverseString2();
		System.out.println(obj.reverseStr("abcdefg", 2));
	}
}
