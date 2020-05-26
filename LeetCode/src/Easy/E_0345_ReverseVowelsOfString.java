package Easy;
/*
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class E_0345_ReverseVowelsOfString {

	public String reverseVowels(String s) {
		int len = s.length();
		int i = 0, j = len-1;
		char[] sCharArr = s.toCharArray();

		while(i < j){
			while(i < j && !isVowel(sCharArr[i])) i++;
			while(i < j && !isVowel(sCharArr[j])) j--;
			if(i < j){
				char temp = sCharArr[i];
				sCharArr[i] = sCharArr[j];
				sCharArr[j] = temp;
			}
			i++;
			j--;
		}
		return new String(sCharArr);
	}
	public boolean isVowel(char ch){
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		E_0345_ReverseVowelsOfString obj = new E_0345_ReverseVowelsOfString();
		System.out.println(obj.reverseVowels("hello"));
	}
}
