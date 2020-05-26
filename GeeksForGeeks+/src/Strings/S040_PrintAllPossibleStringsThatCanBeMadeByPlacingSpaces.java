package Strings;
/*
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 * Time Complexity: Since number of Gaps are n-1, there are total 2^(n-1) patters each having length ranging from n to 2n-1. 
 * Thus overall complexity would be O(n*(2^n)).
 */
public class S040_PrintAllPossibleStringsThatCanBeMadeByPlacingSpaces {

	/* Function recursively prints the strings having space pattern.
	   i and j are indices in 'str[]' and 'buff[]' respectively */
	public void printPatternUtil(char str[], char buff[], int i, int j, int n){
	    if (i==n){
	        buff[j] = '\0';
	        System.out.println(buff);
	        return;
	    }
	 
	    // Either put the character
	    buff[j] = str[i];
	    printPatternUtil(str, buff, i+1, j+1, n);
	 
	    // Or put a space followed by next character
	    buff[j] = ' ';
	    buff[j+1] = str[i];
	 
	    printPatternUtil(str, buff, i+1, j+2, n);
	}
	 
	// This function creates buf[] to store individual output string and uses
	// printPatternUtil() to print all permutations.
	public void printPattern(String str){
	    int n = str.length();
	    char[] strArr = str.toCharArray();
	    
	    // Buffer to hold the string containing spaces
	    char buf[] = new char[2*n]; // 2n-1 characters and 1 string terminator
	 
	    // Copy the first character as it is, since it will be always
	    // at first position
	    buf[0] = str.charAt(0);
	 
	    printPatternUtil(strArr, buf, 1, 1, n);
	}
	 
	public static void main(String[] args) {
		S040_PrintAllPossibleStringsThatCanBeMadeByPlacingSpaces obj = new S040_PrintAllPossibleStringsThatCanBeMadeByPlacingSpaces();
		String str = "ABCD";
	    obj.printPattern(str);
	}
}
