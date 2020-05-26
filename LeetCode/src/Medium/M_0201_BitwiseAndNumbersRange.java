package Medium;
/*
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class M_0201_BitwiseAndNumbersRange {

	/*
	 * The hardest part of this problem is to find the regular pattern.
		For example, for number 26 to 30
		Their binary form are:
		11010
		11011
		11100　　
		11101　　
		11110
		
		Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
		So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
	 */
	//https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)/58131
	public int rangeBitwiseAnd(int m, int n) {
		if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
	public static void main(String[] args) {
		M_0201_BitwiseAndNumbersRange obj = new M_0201_BitwiseAndNumbersRange();
		System.out.println(obj.rangeBitwiseAnd(5, 7));
	}
}
