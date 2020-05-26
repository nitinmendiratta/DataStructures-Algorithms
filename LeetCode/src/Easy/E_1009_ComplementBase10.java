package Easy;
/*
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class E_1009_ComplementBase10 {

	
	/* 	x = 1 => 1 => 1
		x = 3 => (2*1 + 1) => 11
		x = 7 => (3*2 + 1) => 111
		x = 15 => (7*2 + 1) => 1111
	*/
	public int bitwiseComplement(int N) {
		int X = 1;
		// find closest number to N which has all bits set,
		// so that N^X will give opposite bit set of N
		while (N > X) X = X * 2 + 1;
		return N ^ X;
	}
	
	public int bitwiseComplementMyApproach(int N) {
		StringBuilder sb = new StringBuilder();
		char c = (N&1) == 0 ? '1' : '0';
		sb.append(c);
		N = N>>1;

		while(N > 0) {
			if((N&1) == 0) {
				// bit is 0
				sb.insert(0, '1');
			}else {
				// bit is 1
				sb.insert(0, '0');
			}
			N = N>>1;
		}
		return Integer.parseInt(sb.toString(), 2);
	}
	public static void main(String[] args) {
		E_1009_ComplementBase10 obj = new E_1009_ComplementBase10();
		System.out.println(obj.bitwiseComplement(5));
		System.out.println(obj.bitwiseComplement(7));
		System.out.println(obj.bitwiseComplement(10));
	}
}
