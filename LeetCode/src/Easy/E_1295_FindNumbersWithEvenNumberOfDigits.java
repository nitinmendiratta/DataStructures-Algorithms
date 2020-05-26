package Easy;
/*
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class E_1295_FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) {

		int count=0;
		
		for(int i =0 ; i< nums.length; i++){
			if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000)){
				count++;
			}
		}
		return count;
	}

	//My Approach
	public int findNumbersMyApproach(int[] nums) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			if(isDigitEven(nums[i])) {
				count++;
			}
		}
		return count;
	}

	public boolean isDigitEven(int num) {
		int digit = 0;
		while(num > 0) {
			num /= 10;
			digit++;
		}
		return digit%2 == 0 ? true : false;
	}
	public static void main(String[] args) {
		E_1295_FindNumbersWithEvenNumberOfDigits obj = new E_1295_FindNumbersWithEvenNumberOfDigits();
		int[] nums = new int[] {12,345,2,6,7896};
		System.out.println(obj.findNumbers(nums));
	}
}
