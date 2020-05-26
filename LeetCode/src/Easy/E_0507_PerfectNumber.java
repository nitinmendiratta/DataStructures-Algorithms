package Easy;
/*
 * https://leetcode.com/problems/perfect-number/
 */
public class E_0507_PerfectNumber {

	public boolean checkPerfectNumber(int num) {
		if (num == 1) return false;

		int sum = 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i + num / i;
			}
		}
		sum++;

		return sum == num;
	}
	public static void main(String[] args) {
		E_0507_PerfectNumber obj = new E_0507_PerfectNumber();
		System.out.println(obj.checkPerfectNumber(28));
	}
}
