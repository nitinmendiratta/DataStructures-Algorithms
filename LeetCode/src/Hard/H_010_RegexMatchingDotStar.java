package Hard;
/*
 * S25a: http://www.geeksforgeeks.org/wildcard-character-matching/
 * H_010: https://leetcode.com/problems/regular-expression-matching/
 * https://www.youtube.com/watch?v=l3hda49XcDE
 * Time: O(m*n)
 * Space: o(m*n)
 */
public class H_010_RegexMatchingDotStar {
	//'.' Matches any single character. *' Matches zero or more of the preceding element.
	public boolean isMatchDP(String str, String pattern) {
		char[] inputStrArr = str.toCharArray();
		char[] regexStr = pattern.toCharArray();
		
        boolean T[][] = new boolean[inputStrArr.length + 1][regexStr.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (regexStr[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (regexStr[j - 1] == '.' || regexStr[j - 1] == inputStrArr[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (regexStr[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (regexStr[j-2] == '.' || regexStr[j - 2] == inputStrArr[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[inputStrArr.length][regexStr.length];
    }
	
	//'.' Matches any single character. *' Matches zero or more of the preceding element.
	public boolean isMatchRecur(String inputStr, String regexStr) {
		
		// case1: regexStr = null inputStr = null
        if(regexStr.length() == 0) return inputStr.length() == 0;
        //regexStr length 1 is special case    
        if(regexStr.length() == 1 || regexStr.charAt(1) != '*'){
            if(inputStr.length() < 1 || (regexStr.charAt(0) != '.' && inputStr.charAt(0) != regexStr.charAt(0)))  return false;
            return isMatchRecur(inputStr.substring(1), regexStr.substring(1));    
         }else{
            int len = inputStr.length();
            int i = -1; 
            while(i<len && (i < 0 || regexStr.charAt(0) == '.' || regexStr.charAt(0) == inputStr.charAt(i))){
                if(isMatchRecur(inputStr.substring(i+1), regexStr.substring(2))) return true;
                i++;
            }
            return false;
        } 
    }
    
	public static void main(String[] args) {
		H_010_RegexMatchingDotStar obj = new H_010_RegexMatchingDotStar();
		
		System.out.println("DP way Faster");
		System.out.println("Match: "+obj.isMatchDP("aa","a")+" Expected: false");
		System.out.println("Match: "+obj.isMatchDP("aa","aa")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("aaa","aa")+" Expected: false");
		System.out.println("Match: "+obj.isMatchDP("aa", "a*")+" Expected: true");
		System.out.println("Match: "+obj.isMatchDP("aa", ".*")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("ab", ".*")+" Expected: True");
		System.out.println("Match: "+obj.isMatchDP("aab", "c*a*b")+" Expected: True");

		System.out.println("Recursion way slower");
		System.out.println("Match: "+obj.isMatchRecur("aa","a")+" Expected: false");
		System.out.println("Match: "+obj.isMatchRecur("aa","aa")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("aaa","aa")+" Expected: false");
		System.out.println("Match: "+obj.isMatchRecur("aa", "a*")+" Expected: true");
		System.out.println("Match: "+obj.isMatchRecur("aa", ".*")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("ab", ".*")+" Expected: True");
		System.out.println("Match: "+obj.isMatchRecur("aab", "c*a*b")+" Expected: True");
	}
}
