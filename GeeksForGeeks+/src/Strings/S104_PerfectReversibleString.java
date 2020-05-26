package Strings;
/*
 * http://www.geeksforgeeks.org/perfect-reversible-String/
 */
public class S104_PerfectReversibleString {

	// Reverse of all substrings of ‘str’ will exist in ‘str’ if and only if the entire String ‘str’ is palindrome. 
	// We can justify this fact by considering the whole String, a reverse of it will exist only if it is palindrome. 
	// And if a String is palindrome, then all reverse of all substrings exist.

	// This function basically checks if String is palindrome or not
	public static boolean isReversible(String str){
		int i = 0, j = str.length()-1;

		// iterate from left and right
		while (i < j){
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str="aba";
		if (isReversible(str))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
