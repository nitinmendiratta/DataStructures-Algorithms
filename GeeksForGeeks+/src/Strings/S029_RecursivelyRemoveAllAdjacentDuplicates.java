package Strings;
/*
 * http://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
 */
public class S029_RecursivelyRemoveAllAdjacentDuplicates {

	public static String removeDuplicate(String intputStr) {
		StringBuilder sb = new StringBuilder();
		char lastchar = '\0';
		
		for (int i = 0; i < intputStr.length(); i++) {
			String resultStr = sb.toString();
			//System.out.println("Sb till now: "+str+" processing:"+s.charAt(i));
			// check if current char and result str last char are equal, if so we have dup and remove it
			if (!resultStr.equals("") && (resultStr.charAt(resultStr.length() - 1) == intputStr.charAt(i))) {
				//System.out.println("Removing: "+builder.charAt(str.length()-1));
				sb.deleteCharAt(resultStr.length() - 1); //as we have a repetition
			} else if (intputStr.charAt(i) != lastchar){
				//System.out.println("Adding to builder: "+s.charAt(i));
				sb.append(intputStr.charAt(i));
			}
			lastchar = intputStr.charAt(i);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		S029_RecursivelyRemoveAllAdjacentDuplicates obj = new S029_RecursivelyRemoveAllAdjacentDuplicates();
		System.out.println("After removing: "+obj.removeDuplicate("azxxzy"));
		System.out.println("After removing: "+obj.removeDuplicate("geeksforgeeg"));
		System.out.println("After removing: "+obj.removeDuplicate("caaabbbaacdddd"));
		System.out.println("After removing: "+obj.removeDuplicate("acaaabbbacdddd"));
	}
}
