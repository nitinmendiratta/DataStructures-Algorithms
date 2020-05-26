package Easy;
/*
 * https://leetcode.com/problems/number-complement/
 * https://www.geeksforgeeks.org/invert-actual-bits-number/
 */
public class E_0476_NumberComplement {

	// Time complexity : O(log n)
	// Auxiliary space : O(1)
	public int findComplement(int num) {
		// calculating number of  bits in the number 
		int x = (int)(Math.log(num)/Math.log(2)) + 1; 

		// Inverting the bits one by one 
		for (int i = 0; i < x; i++)  
			num = (num ^ (1 << i));  

		return num;
	}
	/* input: 5 = 0...0101(+)
	 * output: 2 = 0...0010(+)
	 * input + output = 0...0111(+)
	 * ~5 = 1..1010 (-)（all bits inverse）
	 * 	 (Integer.highestOneBit(num) << 1) - 1 //it's mean 1000-1=0..0111(+)
	 *  ~5 & (Integer.highestOneBit(num) << 1) - 1  //result is  0...0 010
	  */
	public int findComplementApproach2(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
	}
	
	public static void main(String[] args) {
		E_0476_NumberComplement obj = new E_0476_NumberComplement();
		System.out.println(obj.findComplement(5));
	}
}
