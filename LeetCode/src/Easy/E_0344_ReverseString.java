package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/reverse-string/
 */
public class E_0344_ReverseString {

	public void reverseString(char[] sCharArr) {
		int len = sCharArr.length;
		int i = 0, j = len-1;

		while(i < j && i <= len/2 && j >= len/2){
			char temp = sCharArr[i];
			sCharArr[i] = sCharArr[j];
			sCharArr[j] = temp;
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		E_0344_ReverseString obj = new E_0344_ReverseString();
		char[] input = {'h', 'e', 'l', 'l', 'o'};
		obj.reverseString(input);
		System.out.println(input);
	}
}
