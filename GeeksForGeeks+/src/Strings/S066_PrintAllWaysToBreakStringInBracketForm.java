package Strings;
/*
 * http://www.geeksforgeeks.org/print-ways-break-string-bracket-form/
 */
public class S066_PrintAllWaysToBreakStringInBracketForm {

	// find all combinations of non-overlapping
	// substrings formed by input string str
	// index – index of the next character to be processed
	// out - output string so far
	void findCombinations(String str, int index, String out){
	    if (index == str.length())
	        System.out.println(out);
	 
	    for (int i = index; i < str.length(); i ++)
	 
	        // append substring formed by str[index, i] to output string
	        findCombinations(str, i + 1, out + "(" + str.substring(index, i+1) + ")" );
	}
	
	public static void main(String[] args) {
		S066_PrintAllWaysToBreakStringInBracketForm obj = new S066_PrintAllWaysToBreakStringInBracketForm();
		// input string
	    String str = "abcd";
	 
	    obj.findCombinations(str, 0, "");
	}
}
