package Easy;
/*
 * https://leetcode.com/problems/long-pressed-name/
 */
public class E_0925_LongPressedName {

	
	public boolean isLongPressedName(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        
        for (int j = 0; j < n; ++j)
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        return i == m;
    }
	
	// my approach
	public boolean isLongPressedNameMyApproach(String name, String typed) {
		int i = 0, j = 0, len1 = name.length(), len2 = typed.length();
        
        while(i < len1 && j < len2){
            
            if(name.charAt(i) != typed.charAt(j)){
                // long press
                while(j >= 1 && j < len2 && typed.charAt(j) == typed.charAt(j-1)) j++;
            }
            
            if(j < len2 && name.charAt(i) != typed.charAt(j)) return false;
            i++;
            j++;
        }
        // last char could be long pressed
        if(j != len2) {
        	while(j >= 1 && j < len2 && typed.charAt(j) == typed.charAt(j-1)) j++;
        }
        // if we still didn't reach end of both strings its false
        return i == len1 && j == len2;
    }
	public static void main(String[] args) {
		E_0925_LongPressedName obj = new E_0925_LongPressedName();
		System.out.println(obj.isLongPressedName("alex", "aaleex")); // true
		System.out.println(obj.isLongPressedName("saeed", "ssaaedd")); // false
		System.out.println(obj.isLongPressedName("leelee", "lleeelee")); // true
		System.out.println(obj.isLongPressedName("laiden", "laiden")); // true
		System.out.println(obj.isLongPressedName("laiden", "llllllllllaaaaaaidennnnnn")); // true
		System.out.println(obj.isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz")); // false
	}
}
