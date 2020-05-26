package Easy;
/*
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class E_0557_ReverseWordsString3 {

	public String reverseWords(String s) {
		int len = s.length();
		char[] a = s.toCharArray();
		int i = 0, j = 0;
		for(; i < len; i++){
			if(a[i] == ' '){
				reverse(a, j, i-1);
				j = i+1;
			}
		}
		reverse(a, j, len-1);
		return new String(a);
	}
	public void reverse(char[] a, int start, int end){
		while(start < end){
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		E_0557_ReverseWordsString3 obj = new E_0557_ReverseWordsString3();
		System.out.println(obj.reverseWords("Let's take LeetCode contest"));
	}
}
