package Easy;
/*
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class E_0844_BackspaceStringCompare {

	/*
	 * Time Complexity: O(M + N)
	 * Space Complexity: O(1)
	 */
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;

		while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
			while (i >= 0) { // Find position of next possible char in build(S)
				if (S.charAt(i) == '#') {skipS++; i--;}
				else if (skipS > 0) {skipS--; i--;}
				else break;
			}
			while (j >= 0) { // Find position of next possible char in build(T)
				if (T.charAt(j) == '#') {skipT++; j--;}
				else if (skipT > 0) {skipT--; j--;}
				else break;
			}
			// If two actual characters are different
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
				return false;
			// If expecting to compare char vs nothing
			if ((i >= 0) != (j >= 0))
				return false;
			i--; j--;
		}
		return true;
	}

	public boolean backspaceCompareMyApproach(String S, String T) {
		int sLen = S.length(), tLen = T.length(), cS = 0, cT = 0, i = sLen-1, j = tLen-1;

		while(true){

			while(i >= 0 && S.charAt(i) == '#'){
				cS++;
				i--;
			}
			while(j >= 0 && T.charAt(j) == '#'){
				cT++;
				j--;
			}

			while(cS > 0){
				if(i >= 0 && S.charAt(i) == '#') cS++;
				else cS--;
				i--;
			}

			while(cT > 0){
				if(j >= 0 && T.charAt(j) == '#') cT++;
				else cT--;
				j--;
			}

			if(i >= 0 && S.charAt(i) == '#' || j >= 0 && T.charAt(j) == '#') continue;

			if(i < 0 && j < 0) return true;

			if(i >= 0 && j < 0 || i < 0 && j >= 0 || (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))) return false;

			i--;
			j--;
		}
	}
	public static void main(String[] args) {
		E_0844_BackspaceStringCompare obj = new E_0844_BackspaceStringCompare();
		System.out.println(obj.backspaceCompare("ab#c", "ad#c")); // true
		System.out.println(obj.backspaceCompare("ab##", "c#d#")); // true
		System.out.println(obj.backspaceCompare("a##c", "#a#c")); // true
		System.out.println(obj.backspaceCompare("a#c", "b")); // false

		System.out.println(obj.backspaceCompare("abc", "ad#c")); // false

		System.out.println(obj.backspaceCompare("abc###", "adc##")); // FALSE

		System.out.println(obj.backspaceCompare("bxj##tw", "bxo#j##tw")); // TRUE


	}
}
