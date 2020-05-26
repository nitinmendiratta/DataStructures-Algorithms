package Easy;
/*
 * https://leetcode.com/problems/rotate-string/
 */
public class E_0796_RotateString {

	public boolean rotateString(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int i = 0, j = 0, match = 0;

		// BASE CASES
		if(lenA != lenB) return false;
		if(A.isEmpty() && B.isEmpty()) return true;

		// find the first index of j where both char match
		while(j < lenB && A.charAt(i) != B.charAt(j)){
			j++;
		}
		// if no match return false;
		if(j == lenB) return false;

		match = j;
		// now run loop from start of A and match pos of B
		while(i < lenA){
			
			// if we reach end of B reset index because there is a shift
			if(j == lenB){
				j = 0;
			}
			// if no char match there could be a dup so lets move to next index of first char of A in B
			if(A.charAt(i) != B.charAt(j)){
				j = match+1;
				i = 0;
				// find next macth char in B
				while(j < lenB && A.charAt(i) != B.charAt(j)){
					j++;
				}
				if(j == lenB) return false;
				match = j;
			}
			i++;
			j++;
		}
		return true;
	}
	
	// using internal methods
	public boolean rotateStringApproach2(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}
	public static void main(String[] args) {
		E_0796_RotateString obj = new E_0796_RotateString();
		System.out.println(obj.rotateString("abcde", "cdeab"));
	}
}
