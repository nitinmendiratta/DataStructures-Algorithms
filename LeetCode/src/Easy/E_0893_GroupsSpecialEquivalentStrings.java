package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class E_0893_GroupsSpecialEquivalentStrings {

	//	For each String, we generate it's corresponding signature, and add it to the set.
	//	In the end, we return the size of the set.
	public int numSpecialEquivGroups(String[] A) {
		Set<String> seen = new HashSet();
		for (String S: A) {
			int[] count = new int[52];
			for (int i = 0; i < S.length(); ++i) {
				if (i%2 == 1) count[S.charAt(i)-'a' + 26]++; // odd
				else count[S.charAt(i)-'a']++; // even
			}
			seen.add(Arrays.toString(count));
		}
		return seen.size();
	}

	// https://www.youtube.com/watch?v=WJ4NtyrakT0
	public int numSpecialEquivGroupsApproach2(String[] A) {
		Set<String> set= new HashSet<>();
		for (String s: A){
			int[] odd= new int[26];
			int[] even= new int[26];
			for (int i=0; i<s.length(); i++){
				if (i%2==1) odd[s.charAt(i)-'a']++;
				else even[s.charAt(i)-'a']++;
			}
			String sig= Arrays.toString(odd)+Arrays.toString(even);
			set.add(sig);
		}
		return set.size();
	}
	public static void main(String[] args) {
		E_0893_GroupsSpecialEquivalentStrings obj = new E_0893_GroupsSpecialEquivalentStrings();
		System.out.println(obj.numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
	}
}
