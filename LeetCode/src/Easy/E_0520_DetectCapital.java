package Easy;
/*
 * https://leetcode.com/problems/detect-capital/
 */
public class E_0520_DetectCapital {

	public boolean detectCapitalUse(String word) {
		int len = word.length();
		if(len == 1) return true;
		boolean isCapital = false;
		if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) isCapital = true;                

		for(int i = 1; i < len; i++){
			if((isCapital && !Character.isUpperCase(word.charAt(i))) || !isCapital && Character.isUpperCase(word.charAt(i))){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		E_0520_DetectCapital obj = new E_0520_DetectCapital();
		System.out.println(obj.detectCapitalUse("FlaG"));
	}
}
