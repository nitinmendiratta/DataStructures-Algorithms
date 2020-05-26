package Strings;
/*
 * http://www.geeksforgeeks.org/nth-character-concatenated-decimal-string/
 */
public class S121_NthCharacterInConcatenatedDecimalString {

	public static int findNthDigit(int m) {
	    long n = m; // convert int to long 
	    long start = 1,  len = 1,  count = 9;
	 
	    while(n > len*count){
	        n=n-len*count;
	        len++;
	        count=count*10;
	        start=start*10;
	    }
	 
	    // identify the number
	    start = start + (n-1)/len;
	 
	    // identify the digit
	    return String.valueOf(start).charAt((int)((n-1)%len))-'0';
	}
	public static void main(String[] args) {
		System.out.println(findNthDigit(251));
	}
}
