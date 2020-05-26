package Strings;
/*
 * http://www.geeksforgeeks.org/print-string-of-odd-length-in-x-format/
 */
public class S052_PrintStringOfOddLengthInXformat {

	// Function to print given string in cross pattern
	// Length of string must be odd
	public void printPattern(String str){
		int len = str.length();

		// i goes from 0 to len and j goes from len-1 to 0
		for (int i=0,j=len-1; i<=len && j>=0; i++,j--){
			// To print the upper part. This loop runs
			// til middle point of string (i and j become
			// same
			if (i<j){
				// Print i spaces
				for (int x=0; x<i; x++)
					System.out.print(" ");

				// Print i'th character
				System.out.print(str.charAt(i));

				// Print j-i-1 spaces
				for (int x=0; x<j-i-1; x++)
					System.out.print(" ");

				// Print j'th character
				System.out.println(str.charAt(j));
			}

			// To print center point
			if (i==j){
				// Print i spaces
				for (int x=0; x<i; x++)
					System.out.print(" ");

				// Print middle character
				System.out.println(str.charAt(i));
			}

			// To print lower part
			else if (i>j){
				// Print j spances
				for (int x = j-1; x>=0; x--)
					System.out.print(" ");

				// Print j'th character
				System.out.print(str.charAt(j));

				// Print i-j-1 spaces
				for (int x=0; x<i-j-1; x++)
					System.out.print(" ");

				// Print i'h character
				System.out.println(str.charAt(i));
			}
		}
	}
	public static void main(String[] args) {
		S052_PrintStringOfOddLengthInXformat obj = new S052_PrintStringOfOddLengthInXformat();
		obj.printPattern("geeksforgeeks");
	}
}
