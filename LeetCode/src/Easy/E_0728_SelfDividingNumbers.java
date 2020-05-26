package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/self-dividing-numbers/
 */
public class E_0728_SelfDividingNumbers {

	/*
	 * Time Complexity: O(D)O(D), where DD is the number of integers in the range
	 * [L, R], and assuming log(R) is bounded. 
	 * (In general, the complexity would be O(DlogR).)
	 * 
	 * Space Complexity: O(D), the length of the answer.
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
	public boolean selfDividing(int n) {
        int x = n;
        while (x > 0) {
        	// remainder
            int d = x % 10;
            // x updated to count the number of digits in the number
            x /= 10;
            if (d == 0 || (n % d) > 0) return false;
        }
        return true;
	}
	public static void main(String[] args) {
		E_0728_SelfDividingNumbers obj = new E_0728_SelfDividingNumbers();
		System.out.println(obj.selfDividingNumbers(1, 22));
	}
}
