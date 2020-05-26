package Medium;

/*
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class M_0165_CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		int len1 = version1.length(), len2 = version2.length();
		int dotIdx1 = 0, dotIdx2 = 0, v1 = 0, v2 = 0;
		
		while(dotIdx1 < len1 || dotIdx2 < len2) {

			while(dotIdx1 < len1 && version1.charAt(dotIdx1) != '.') {
				v1 = 10*v1 + Integer.parseInt(String.valueOf(version1.charAt(dotIdx1)));
				dotIdx1++;
			}
			
			while(dotIdx2 < len2 && version2.charAt(dotIdx2) != '.') {
				v2 = 10*v2 + Integer.parseInt(String.valueOf(version2.charAt(dotIdx2)));
				dotIdx2++;
			}
			
			if(v1 > v2) return 1;
			else if(v1 < v2) return -1;
			
			dotIdx1++;
			dotIdx2++;
			v1 = 0;
			v2 = 0;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		M_0165_CompareVersionNumbers obj = new M_0165_CompareVersionNumbers();
		System.out.println(obj.compareVersion("0.1", "1.1"));
		System.out.println(obj.compareVersion("1.0.1", "1"));
		System.out.println(obj.compareVersion("7.5.2.4", "7.5.3"));
		System.out.println(obj.compareVersion("1.01", "1.001"));
		System.out.println(obj.compareVersion("1.0", "1.0.0"));
	}
}
