package Strings;
/*
 * http://www.geeksforgeeks.org/program-toggle-characters-string/
 */
public class S131_ProgramToToggleAllCharactersInaString {

	public static String toggleChars(String inStr){
		
		char str[] = inStr.toCharArray();
		
	    for (int i=0; i < str.length; i++){
	        if (str[i]>='A' && str[i]<='Z')
	            str[i] = (char) (str[i] + 'a' - 'A');
	        else if (str[i]>='a' && str[i]<='z')
	            str[i] = (char) (str[i] + 'A' - 'a');
	    }
	    return new String(str);
	}
	 	
	public static void main(String[] args) {
	    System.out.println(toggleChars("GeKf@rGeek$"));
	}
}
