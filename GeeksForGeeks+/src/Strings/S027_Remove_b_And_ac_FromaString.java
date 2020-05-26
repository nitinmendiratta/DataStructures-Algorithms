package Strings;
/*
 * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
 * Tough problem
 */
public class S027_Remove_b_And_ac_FromaString {

	public String remove(String s){
		if(s == null || s.equals("b") || s.length() == 0) return null;
		char[] str = s.toCharArray();
		int n = str.length;

		// state is initially ONE (The previous character is not a)
		int state = 1;

		// i and j are index variables, i is used to read next character of input
		// string, j is used for indexes of output string (modified input string)
		int j = 0;

		// Process all characters of input string one by one
		for (int i = 0; i < n; i++){
			/* If state is ONE, then do NOT copy the current character to output if one of the following conditions is true
           ...a) Current character is 'b' (We need to remove 'b')
           ...b) Current character is 'a' (Next character may be 'c') */
			if (state == 1 && str[i] != 'a' && str[i] != 'b'){
				//System.out.println("sate: "+state+"replacing: "+str[j]+" with: "+str[i]);
				str[j] = str[i];
				j++;
			}
			
			// If state is TWO and current character is not 'c' (otherwise
			// we ignore both previous and current characters)
			if (state == 2 && str[i] != 'c'){
				// First copy the previous 'a'
				str[j] = 'a';
				j++;

				// Then copy the current character if it is not 'a' and 'b'
				if (str[i] != 'a' && str[i] != 'b'){
					//System.out.println("sate: "+state+"replacing: "+str[j]+" with: "+str[i]);
					str[j] = str[i];
					j++;
				}
			}
			
			// Change state according to current character
			state = (str[i] == 'a')? 2: 1;
		}

		// If last character was 'a', copy it to output
		if (state == 2){
			str[j] = 'a';
			j++;
		}
		 // Set the string terminator
    	str[j] = '\0';

		return new String(str);
	}

	public static void main(String[] args) {
		S027_Remove_b_And_ac_FromaString obj = new S027_Remove_b_And_ac_FromaString();
		System.out.println("After removing:"+obj.remove("aaac"));
		System.out.println("After removing:"+obj.remove("ababac"));
		System.out.println("After removing:"+obj.remove("bbbbd"));
	}
}
