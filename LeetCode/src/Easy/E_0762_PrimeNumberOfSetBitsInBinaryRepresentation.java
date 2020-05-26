package Easy;
/*
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class E_0762_PrimeNumberOfSetBitsInBinaryRepresentation {

	/*
	 * 0b10100010100010101100 is the bit wise representation of 665772. 
	 * Here 2nd,3rd,5th,7th,11th,13th,17th,19th,23rd and 29th bits are 1 and rest are 0s.
	 * 
	 * What do all these positions have in common? they are prime numbers! Example:
	 * -Let say a number has 5 bits set, (calculated by using
	 * Integer.bitCount(L)). -To check if 5 is prime shift 0b10100010100010101100
	 * by 5 -This gives you 0b00000101000101000101, -When you & it with 1 you get
	 * 1, hence 5 is prime number!
	 */
	public int countPrimeSetBits(int L, int R) {
		int count = 0;
		while (L <= R)
			count += 665772 >> Integer.bitCount(L++) & 1;
		return count;
	}

	public int countPrimeSetBitsApproach2(int L, int R) {
		int ans = 0;
		for (int x = L; x <= R; ++x)
			if (isSmallPrime(Integer.bitCount(x)))
				ans++;
		return ans;
	}
	public boolean isSmallPrime(int x) {
		return (x == 2 || x == 3 || x == 5 || x == 7 ||
				x == 11 || x == 13 || x == 17 || x == 19);
	}
	public static void main(String[] args) {
		E_0762_PrimeNumberOfSetBitsInBinaryRepresentation obj = new E_0762_PrimeNumberOfSetBitsInBinaryRepresentation();
		System.out.println(obj.countPrimeSetBits(6, 10));
		System.out.println(obj.countPrimeSetBitsApproach2(6, 10));
	}
}
