package Strings;
import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
 */
public class S015_PrintAllInterleavingsOfTwoStrings {

	public ArrayList<String> permute(String s1,String s2){
		ArrayList<String> resultList = new ArrayList<String>();
		int m = s1.length();
		int n = s2.length();
		char[] tempArr = new char[m+n+1];
		helper(s1, s2, tempArr, m, n, 0, resultList);
		return resultList;
	}

	public void helper(String str1, String str2, char[] tempArr, int m, int n, int i, ArrayList<String> resultList){
		// Base case: If all characters of str1 and str2 have been included in output string, then print the output string
		if (m == 0 && n == 0){
			resultList.add(new String(tempArr));
		}
		// If some characters of str1 are left to be included, then include the first character from the remaining characters and recur for rest
		if ( m != 0 ){
			tempArr[i] = str1.charAt(0);
			helper (str1.substring(1), str2, tempArr, m-1, n, i+1, resultList);
		}
		// If some characters of str2 are left to be included, then include the first character from the remaining characters and recur for rest
		if ( n != 0 ){
			tempArr[i] = str2.charAt(0);
			helper (str1, str2.substring(1), tempArr, m, n-1, i+1, resultList);
		}
	}

	public static void main(String[] args) {
		S015_PrintAllInterleavingsOfTwoStrings obj = new S015_PrintAllInterleavingsOfTwoStrings();
		String s1 = "AB";
		String s2 = "CD";
		System.out.println("Permutations are: "+obj.permute(s1,s2));
	}
}
