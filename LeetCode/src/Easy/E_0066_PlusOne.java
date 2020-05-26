package Easy;
/*
 * https://oj.leetcode.com/problems/plus-one/
 */
public class E_0066_PlusOne {

	public int[] plusOne(int[] digits) {
		int len = digits.length;
        int[] res = new int[len+1];
        int carry = 1;
        for(int i = len-1; i >= 0; i--){
            if(digits[i] + carry == 10 ){
                res[i+1] = 0;
            }else {
                res[i+1] = digits[i] + carry;
                carry = 0; 
            }
        }
        if(carry == 1){
            res[0] = 1;
        }else{
            res = java.util.Arrays.copyOfRange(res, 1, len+1);
        }
        return res;
	}

	public static void main(String[] args) {
		E_0066_PlusOne obj = new E_0066_PlusOne();
		int[] arr = {0};
		arr = obj.plusOne(arr);
		for(int i = 0;i < arr.length;i++)System.out.print(arr[i]);
	}
}
