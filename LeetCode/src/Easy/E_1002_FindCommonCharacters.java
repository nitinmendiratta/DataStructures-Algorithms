package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/find-common-characters/
 */
public class E_1002_FindCommonCharacters {

	public List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) {
            dict[A[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            // Dictionary of the current word
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                curr[A[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j]) dict[j] = curr[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		E_1002_FindCommonCharacters obj = new E_1002_FindCommonCharacters();
		System.out.println(obj.commonChars(new String[] {"bella","label","roller"}));
	}
}
