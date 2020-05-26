package Easy;
/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class E_0191_NumberOf1Bits {

	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			// AND-ing n and n-1 flips the least-significant 1-bit to 0.
			// 11&10 -> 10
			// 10&9 -> 8
			n &= (n - 1);
		}
		return sum;
	}

	public int hammingWeightApproach2(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			// shift 1 to the bit number we are processing in n
			if ((n & (1 << i)) == 1) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		E_0191_NumberOf1Bits obj = new E_0191_NumberOf1Bits();
		System.out.println(obj.hammingWeight(
				00000000000000000000000000001011));
	}

}
