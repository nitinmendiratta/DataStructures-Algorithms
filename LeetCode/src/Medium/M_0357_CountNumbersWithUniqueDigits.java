package Medium;

/*
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class M_0357_CountNumbersWithUniqueDigits {

	/******************************* Using combinatorics *********************************/
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 91;
        }
		/*
		 * if here n > 2, 1st position can be filled in 9 ways, 
		 * 2nd in 9 ways so prod is 81, 
		 * 3rd position can be filled in 8 ways
		 */
        int prod = 81, end = 8, curr = 91;
        
        for (int i = 3; i <= n; i++) {
            prod *= end;
            end--;
            curr += prod;
        }
        return curr;
    }
	
	
	/******************************* Standard Backtracking solution *********************************/

	// The running time for this program is O(10!) worst case, or O(n!) if n < 10.
	public int countNumbersWithUniqueDigitsApproach2(int n) {
		if (n > 10) { // Cannot exceeds 10 digits without duplicate digits
			n = 10;
		}
		long max = (long) Math.pow(10, n);
		boolean[] used = new boolean[10];
		return dfs(0, max, used);
	}

	// The idea is to build integer one digit by digit, with no leading zeros
	private int dfs(long curr, long max, boolean[] used) {
		if (curr >= max) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < 10; i++) {
			if (curr == 0 && i == 0) { // Skip leading zero
				continue;
			}
			// check if we already have used i as the digit in curt
			if (!used[i]) {
				used[i] = true;
				//System.out.println(10 * curt + i);
				count += dfs(10 * curr + i, max, used);
				used[i] = false;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		M_0357_CountNumbersWithUniqueDigits obj = new M_0357_CountNumbersWithUniqueDigits();
		System.out.println(obj.countNumbersWithUniqueDigits(2));
		System.out.println(obj.countNumbersWithUniqueDigits(3));
		System.out.println(obj.countNumbersWithUniqueDigitsApproach2(3));
		System.out.println(obj.countNumbersWithUniqueDigits(4));
		System.out.println(obj.countNumbersWithUniqueDigitsApproach2(4));
	}
}
