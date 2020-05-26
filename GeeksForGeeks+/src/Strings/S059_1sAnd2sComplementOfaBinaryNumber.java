package Strings;
/*
 * http://www.geeksforgeeks.org/1s-2s-complement-binary-number/
 * As a side note, signed numbers generally use 2’s complement representation. 
 * Positive values are stored as it is and negative values are stored in their 2’s complement form.
 * One extra bit is required to indicate whether number is positive or negative. 
 * For example char is 8 bits in C. If 2’s complement representation is used for char, 
 * then 127 is stored as it is, i.e., 01111111 where first 0 indicates positive. But -127 is stored as 10000001.
 */
public class S059_1sAnd2sComplementOfaBinaryNumber {

	// Returns '0' for '1' and '1' for '0'
	char flip(char c) {return (c == '0')? '1': '0';}
	 
	// Print 1's and 2's complement of binary number represented by "bin"
	public void printOneAndTwosComplement(String bin){
	    int n = bin.length();
	    int i;
	    StringBuilder ones = new StringBuilder();
	    
	 
	    //  for ones complement flip every bit
	    for (i = 0; i < n; i++)
	        ones.append(flip(bin.charAt(i)));
	 
	    //  for two's complement go from right to left in
	    //  ones complement and if we get 1 make, we make
	    //  them 0 and keep going left when we get first
	    //  0, make that 1 and go out of loop
	    StringBuilder twos = new StringBuilder(ones);
	    
	    for (i = n - 1; i >= 0; i--){
	        if (ones.charAt(i) == '1')
	            twos.setCharAt(i, '0');
	        else{
	            twos.setCharAt(i, '1');
	            break;
	        }
	    }
	 
	    // If No break : all are 1  as in 111  or  11111;
	    // in such case, add extra 1 at beginning
	    if (i == -1)
	        twos.insert(0, '1');	 
	 
	    System.out.println("1's complement: "+ ones);
	    System.out.println("2's complement: "+twos);
	}
	public static void main(String[] args) {
		 S059_1sAnd2sComplementOfaBinaryNumber obj = new S059_1sAnd2sComplementOfaBinaryNumber();
		 String bin = "0111";
		 obj.printOneAndTwosComplement(bin);
	}

}
