package Easy;
/*
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class E_0058_LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int len = s.length();
		int i = len - 1, lastWordLength = 0;
		while(i >= 0){
			if(s.charAt(i) != ' '){
				lastWordLength++;
			}else if(lastWordLength > 0){
				break;
			}
			i--;
		}
		return lastWordLength;
	}

	public static void main(String[] args) {
		E_0058_LengthOfLastWord	obj = new E_0058_LengthOfLastWord();
		System.out.println("Length is: "+obj.lengthOfLastWord("a "));
	}
}
