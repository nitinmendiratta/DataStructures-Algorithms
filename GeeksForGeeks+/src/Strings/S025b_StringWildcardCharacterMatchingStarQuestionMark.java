package Strings;
/*
 * http://www.geeksforgeeks.org/wildcard-character-matching/
 * https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 * Time: O(m*n)
 * Space: o(m*n)
 */
public class S025b_StringWildcardCharacterMatchingStarQuestionMark {

	// * --> Matches with 0 or more instances of any character or set of characters. ? --> Matches with any one character.
	public boolean isMatchDP(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //below loop replaces multiple * with one * e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        // if first char of pattern is a *
        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }
        return T[str.length][writeIndex];
    }
	
	public boolean isMatchRecur(String inputStr, String regexStr){
		// case1: regexStr = null inputStr = null
		if (regexStr.length() == 0 && inputStr.length() == 0)	return true;
		// case2: (regexStr = null and inputStr = sth) || (inputStr = null and regexStr = sth and regexStr != *sth)
		if((regexStr.length() == 0 && inputStr.length() != 0) || (inputStr.length() == 0 && regexStr.length() > 0 && regexStr.charAt(0) != '*')) return false;
		// case3: when regexStr = * and inputStr = null
		if (regexStr.charAt(0) == '*' && regexStr.length() == 1 && inputStr.length() == 0) return true;

		// case4: This function assumes that the first string will not contain two consecutive '*' 
		// when regexStr = *sth and inputStr = null
		if (regexStr.charAt(0) == '*' && regexStr.length() > 1 && inputStr.length() == 0) return false;

		// case5: regexStr = ?sth || regexStr = (a)Sth and inputStr = (a)Sth
		if (regexStr.charAt(0) == '?' || regexStr.charAt(0) == inputStr.charAt(0))
			return isMatchRecur(regexStr.substring(1), inputStr.substring(1));

		// case6: If first char is *, then there are two possibilities
		// a) We consider first character of regex string and ignore first char of input string
		// b) We ignore first character of regex string and consider first character of input string.
		if (regexStr.charAt(0) == '*')
			return isMatchRecur(regexStr, inputStr.substring(1)) || isMatchRecur(regexStr.substring(1), inputStr);
		return false;
	}
	

	public static void main(String[] args) {
		S025b_StringWildcardCharacterMatchingStarQuestionMark obj = new S025b_StringWildcardCharacterMatchingStarQuestionMark();
		System.out.println("DP Way");
		System.out.println("Match: "+obj.isMatchDP("g*ks", "geeks")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("ge?ks*","geeksforgeeks")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("g*k", "gee")+" Expected: false");
		System.out.println("Match: "+obj.isMatchDP("*pqrs", "pqrst")+" Expected: false");
		System.out.println("Match: "+obj.isMatchDP("abc*bcd", "abchjbcbcd")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("abc*c?d", "abcd")+" Expected: false");
		System.out.println("Match: "+obj.isMatchDP("*c*d", "abcd")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("*?c*d", "abcd")+" Expected: True");
		
		System.out.println("Recursion way");
		System.out.println("Match: "+obj.isMatchRecur("g*ks", "geeks")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("ge?ks*","geeksforgeeks")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("g*k", "gee")+" Expected: false");
		System.out.println("Match: "+obj.isMatchRecur("*pqrs", "pqrst")+" Expected: false");
		System.out.println("Match: "+obj.isMatchRecur("abc*bcd", "abchjbcbcd")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("abc*c?d", "abcd")+" Expected: false");
		System.out.println("Match: "+obj.isMatchRecur("*c*d", "abcd")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("*?c*d", "abcd")+" Expected: True");
	}
}
