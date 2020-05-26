package Easy;
/*
 * https://leetcode.com/problems/ransom-note/
 */
public class E_0383_RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || ransomNote.length() == 0) {
			return true;
		}
		if (magazine == null || magazine.length() == 0) {
			return false;
		}
		int[] count = new int[26];
		int noteCount = ransomNote.length();
		for (char c : ransomNote.toCharArray()) {
			count[c - 'a']++;
		}
		for (char c : magazine.toCharArray()) {
			if (count[c - 'a'] > 0) {
				count[c - 'a']--;
				noteCount--;
			}
			if (noteCount == 0) {
				return true;
			}
		}
		return false;
	}
	public boolean canConstructApproach2(String ransomNote, String magazine) {
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if(--arr[ransomNote.charAt(i)-'a'] < 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		E_0383_RansomNote obj = new E_0383_RansomNote();
		System.out.println(obj.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
	}
}
