package Easy;
/*
 * https://leetcode.com/problems/hamming-distance/
 */
public class E_0461_HammingDistance {

	public int hammingDistance(int x, int y) {
		int xor = x ^ y, count = 0;
		// calculate set bits or use Integer.bitCount(xor)
		for (int i = 0; i < 32; i++) {
			count += (xor >> i) & 1;
		}
		return count;
	}
	public static void main(String[] args) {
		E_0461_HammingDistance obj = new E_0461_HammingDistance();
		System.out.println(obj.hammingDistance(1, 4));
	}
}
