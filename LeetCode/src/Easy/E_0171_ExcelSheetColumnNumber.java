package Easy;
/*
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class E_0171_ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int res = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			res += (int)(c - 'A' + 1) * Math.pow(26, s.length()-i-1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		E_0171_ExcelSheetColumnNumber obj = new E_0171_ExcelSheetColumnNumber();
		System.out.println("Col Num corresponding to Z is: "+obj.titleToNumber("Z"));	
	}
}
