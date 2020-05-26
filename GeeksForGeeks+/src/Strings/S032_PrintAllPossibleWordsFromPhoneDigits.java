package Strings;
/*
 * http://www.geeksforgeeks.org/find-possible-words-phone-digits/
 */
public class S032_PrintAllPossibleWordsFromPhoneDigits {

	// A recursive function to print all possible words that can be obtained
	// by input number[] of size n.  The output words are one by one stored in output[]
	public void  printWordsUtil(char[][] phone, int number[], int curr_digit, char output[], int n){
		// Base case, if current output word is prepared
		int i = 0;
		if (curr_digit == n){
			System.out.println(new String(output));
			return;
		}
		// Try all 3 possible characters for current digit in number[] and recur for remaining digits
		for (i = 0; i < phone[number[curr_digit]].length; i++){
			output[curr_digit] = phone[number[curr_digit]][i];
			printWordsUtil(phone, number, curr_digit+1, output, n);
			if (number[curr_digit] == 0 || number[curr_digit] == 1) return;
		}
	}

	// A wrapper over printWordsUtil().  It creates an output array and calls printWordsUtil()
	public void printWords(char[][] p, int[] number){
		int n = number.length;
		char result[] = new char[n+1];
		printWordsUtil(p, number, 0, result, n);
	}
	
	public static void main(String[] args) {
		S032_PrintAllPossibleWordsFromPhoneDigits obj = new S032_PrintAllPossibleWordsFromPhoneDigits();
		// hashTable[i] stores all characters that correspond to digit i in phone
		char[][] phone = {
                     {},
                     {},
                     {'a','b','c'},
                     {'d','e','f'},
                     {'g','h','i'},
                     {'j','k','l'},
                     {'m','n','o'}, 
                     {'p','q','s','r'}, 
                     {'t','u','v'},
                     {'w','x','y','z'}     
                    };
        int[] n = {2,3,4};
		obj.printWords(phone,n);
	}
}
