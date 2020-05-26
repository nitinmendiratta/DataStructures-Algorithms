package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 */
public class E_1317_ConvertIntegerSumToTwoNoZeroIntegers {

	public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0"))
                return new int[]{a, b};
        }
        return new int[]{}; // unreachable because at least one valid solution
    }
	public static void main(String[] args) {
		E_1317_ConvertIntegerSumToTwoNoZeroIntegers obj = new E_1317_ConvertIntegerSumToTwoNoZeroIntegers();
		System.out.println(Arrays.toString(obj.getNoZeroIntegers(2)));
	}
}
