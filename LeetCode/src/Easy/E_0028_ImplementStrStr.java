package Easy;
/*
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class E_0028_ImplementStrStr {

	public int strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if(len2 > len1) return -1;
		boolean match = false;
		int i = 0, j = 0;
		for(;i < len1 && j < len2; i++){
			if(haystack.charAt(i) == needle.charAt(j)){
				j++;
				match = true;
			}else{
				if(match){
					i = i-j;
					match = false;
				}
				j = 0;
			}
		}
		if(j == len2){
			return i-j;
		}
		return -1;
	}
	public int strStrApproach2(String haystack, String needle) {
		if(haystack == null && needle == null)return -1;
		if(haystack == "" && needle == "") return 0;

		int len1 = haystack.length();
		int len2 = needle.length();
		int i = 0,j = 0;
		for(i = 0;i < len1;i++){
			for(j = 0;j < len2;j++){
				if(((i+j) >= len1) || haystack.charAt(i+j) != needle.charAt(j)) break;
			}
			if(j == len2) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		E_0028_ImplementStrStr obj = new E_0028_ImplementStrStr();
		System.out.println(obj.strStr("","nitin"));
	}
}
