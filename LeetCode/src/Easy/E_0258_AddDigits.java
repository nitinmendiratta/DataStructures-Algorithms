package Easy;
/*
 * https://leetcode.com/problems/add-digits/
 */
public class E_0258_AddDigits {
	public int addDigits(int num) {
		int temp = num;
		if (num == 0) return 0;
		int sum;
		while (true) {
			sum = 0;
			while (temp > 0) {
				sum += temp % 10; // get the last digit and add it to sum
				temp = temp / 10; // get the number except last digit
			}
			if (sum > 9) temp = sum;
			else break;
		}
		return sum;
	}
	public static void main(String[] args) {
		E_0258_AddDigits obj = new E_0258_AddDigits();
		System.out.println(obj.addDigits(38));
	}
}
