package Strings;
/*
 * http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * o(n)
 * 
 */
public class S013_FindSmallestWindowInaStringContainingAllCharactersOfAnotherString {
	// Returns false if no valid window is found. Else returns true and updates minWindowBegin and minWindowEnd with the 
	// starting and ending position of the minimum window.
	public String containsAll(String S, String T){
		if(S == null || S.length() < T.length()) return null;

		int sLen = S.length(), tLen = T.length(), minWindowBegin = 0,minWindowEnd = 0;
		//  needToFind stores the total count of a character in T and hasFound stores the total count of a character met so far
		int needToFind[] = new int[256];
		int hasFound[] = new int[256];
		
		for (int i = 0; i < tLen; i++)
			needToFind[T.charAt(i)]++;
		
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;

		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S.charAt(end)] == 0) continue;
			
			// char is present in T so u increment hasFound
			hasFound[S.charAt(end)]++;
			// to store the total characters in T that's met so far 
			//(not counting characters where hasFound[x] exceeds needToFind[x]).
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;

			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible, stop when advancing breaks window constraint.
				while (needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for
		String result = S.substring(minWindowBegin,minWindowEnd+1);

		return (count == tLen) ? result : null;
	}

	public static void main(String[] args) {
		S013_FindSmallestWindowInaStringContainingAllCharactersOfAnotherString obj = new S013_FindSmallestWindowInaStringContainingAllCharactersOfAnotherString();
		String s = "this is a test string";
		String word = "tist";
		System.out.println("substring is: "+obj.containsAll(s,word));
	}
}
