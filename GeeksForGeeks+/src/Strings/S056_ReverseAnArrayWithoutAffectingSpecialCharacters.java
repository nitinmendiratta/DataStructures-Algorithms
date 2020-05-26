package Strings;
/*
 * http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 */
public class S056_ReverseAnArrayWithoutAffectingSpecialCharacters {

	// Returns true if x is an aplhabatic character, false otherwise
	boolean isAlphabet(char x){
	    return ( (x >= 'A' &&  x <= 'Z') ||
	             (x >= 'a' &&  x <= 'z') );
	}
	 
	public String reverse(String inputStr){
		char[] str = inputStr.toCharArray();
	    // Initialize left and right pointers
	    int r = str.length - 1;
	    int l = 0;
	 
	    // Traverse string from both ends until 'l' and 'r'
	    while (l < r){
	        // Ignore special characters
	        if (!isAlphabet(str[l]))
	            l++;
	        else if(!isAlphabet(str[r]))
	            r--;
	 
	        else{ // Both str[l] and str[r] are not spacial
	            swap(str,l,r);
	            l++;
	            r--;
	        }
	    }
	    return new String(str);
	}
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		S056_ReverseAnArrayWithoutAffectingSpecialCharacters obj = new S056_ReverseAnArrayWithoutAffectingSpecialCharacters();
		String str = "a!!!b.c.d,e'f,ghi";
	    System.out.println("Input string: "+str);
	    ;
	    System.out.println("Output string: "+obj.reverse(str));
	}
}
