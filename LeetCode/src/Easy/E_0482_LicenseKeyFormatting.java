package Easy;
/*
 * https://leetcode.com/problems/license-key-formatting/
 */
public class E_0482_LicenseKeyFormatting {

	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int len = S.length(), i = len-1, kCount = 0;
		while(i >= 0){
			if(S.charAt(i) != '-'){
				if (kCount > 0 && kCount % K == 0){
					sb.append('-');
				}
				kCount++;
				sb.append(S.charAt(i));
			}
			i--;
		}
		return sb.reverse().toString().toUpperCase();
	}

	public static void main(String[] args) {
		E_0482_LicenseKeyFormatting obj = new E_0482_LicenseKeyFormatting();
		System.out.println(obj.licenseKeyFormatting("--a-a-a-a--", 2));
	}
}
