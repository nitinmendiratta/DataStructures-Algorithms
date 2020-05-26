package Easy;
/*
 * https://leetcode.com/problems/reverse-bits/
 * https://www.youtube.com/watch?v=KE5Axm7uzok
 * https://www.geeksforgeeks.org/reverse-actual-bits-given-number/
 */
public class E_0190_ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		// init first bit of output (will be the left-most in the end)
		int output = n & 1;
		for (int i = 1; i < 32; i++) {
			// bitwise left shift 'output' by 1 so to start creating space for the new bit
			output <<= 1; 

			// check if the i-th input bit is set, it is shifting 1 to left by i bits so to compare smae position bit in n
			if ((n & (1 << i)) != 0) // set least significant output bit
				output += 1;
		} 
		// required number 
		return output;
	}
	public static void main(String[] args) {
		E_0190_ReverseBits obj = new E_0190_ReverseBits();
		System.out.println(obj.reverseBits(
				00000000000000000000000000001011));
	}
}
