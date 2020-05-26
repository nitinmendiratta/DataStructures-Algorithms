package Easy;
/*
 * https://leetcode.com/problems/base-7/
 */
public class E_0504_Base7 {

	public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return Integer.toString(num);
        return convertToBase7(num / 7) + Integer.toString(num % 7);
    }
	public static void main(String[] args) {
		E_0504_Base7 obj = new E_0504_Base7();
		System.out.println(obj.convertToBase7(100));
	}
}
