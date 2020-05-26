package Easy;

/*https://leetcode.com/problems/excel-sheet-column-title/
 * https://www.geeksforgeeks.org/find-excel-column-name-given-number/
Suppose we have a number n, let’s say 28. so corresponding to it we need to print the column name. We need to take remainder with 26.

If remainder with 26 comes out to be 0 (meaning 26, 52 and so on) then we put ‘Z’ in the output string and new n becomes n/26 -1 
because here we are considering 26 to be ‘Z’ while in actual it’s 25th with respect to ‘A’.

Similarly if the remainder comes out to be non zero. (like 1, 2, 3 and so on) then we need to just insert the char accordingly in the string and do n = n/26.

Finally we reverse the string and print.
*/

public class E_0168_ExcelSheetColumnTitle {
	
	public String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
        while(n > 0){
            int rem = n%26;
            if(rem == 0){
                res.append("Z");
                n = n/26 -1;
            }else{
                res.append((char)(rem - 1 + 'A'));
                n = n/26;
            }
        }
        return new String(res.reverse());
	}
	
	public static void main(String[] args) {
		E_0168_ExcelSheetColumnTitle obj = new E_0168_ExcelSheetColumnTitle();
		System.out.println(obj.convertToTitle(26));
		System.out.println(obj.convertToTitle(28));
	}
	
}
