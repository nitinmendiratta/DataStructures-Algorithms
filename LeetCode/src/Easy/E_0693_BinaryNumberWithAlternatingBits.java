package Easy;
/*
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 */
public class E_0693_BinaryNumberWithAlternatingBits {

	public boolean hasAlternatingBits(int n) {

		boolean bitSet = false;
		
		// intialise bitSet depending on right most bit set or not
        if((n&1) == 1){
			bitSet = true;
		}
        // run over rest of the bits and alternate bitset flag to check for invalid case
		while(n > 0){
			n = n >> 1;
			if((n&1) == 1){
				if(bitSet) return false;
				bitSet = true;
			}else {
                if(!bitSet) return false;
				bitSet = false;
            }
		}
		return true;
	}
	public static void main(String[] args) {
		E_0693_BinaryNumberWithAlternatingBits obj = new E_0693_BinaryNumberWithAlternatingBits();
		System.out.println(obj.hasAlternatingBits(4));
	}
}
