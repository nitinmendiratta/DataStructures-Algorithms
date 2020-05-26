package Strings;
/*
 * http://www.geeksforgeeks.org/find-excel-column-name-given-number/
 */
public class S034_FindExcelColumnNameFromaColumnNumber {

	public String colName(int n) {
		if( n <= 0) return null;
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			int rem = n%26;
			if(rem == 0){
				sb.append('Z');
				n = n/26-1;
			}else{
				sb.append((char)((rem-1)+'A'));
				n = n/26;
			}
		}
		return new String(sb.reverse());
	}
	
	public static void main(String[] args) {
		S034_FindExcelColumnNameFromaColumnNumber obj = new S034_FindExcelColumnNameFromaColumnNumber();
		System.out.println("Col Name corresponding to 26 is: "+obj.colName(26));
		System.out.println("Col Name corresponding to 51 is: "+obj.colName(51));
		System.out.println("Col Name corresponding to 52 is: "+obj.colName(52));
		System.out.println("Col Name corresponding to 80 is: "+obj.colName(80));
		System.out.println("Col Name corresponding to 676 is: "+obj.colName(676));
		System.out.println("Col Name corresponding to 702 is: "+obj.colName(702));
		System.out.println("Col Name corresponding to 705 is: "+obj.colName(705));		
	}
}
