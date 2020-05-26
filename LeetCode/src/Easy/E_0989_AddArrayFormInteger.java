package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class E_0989_AddArrayFormInteger {

	public List<Integer> addToArrayForm(int[] A, int K) {
		LinkedList<Integer> res = new LinkedList<>();
		int len = A.length, carry = 0, val = 0;

		for(int i = len-1; i >= 0 || K > 0; i--){
			val = i >= 0 ? A[i] : 0;
			int rem = K%10;
			if(K > 0) K = K/10;

			int sum = val + rem + carry;
			carry = 0;
			if(sum > 9){
				carry = 1;
			}
			res.add(0, sum%10);
		}
		if(carry > 0) res.add(0, carry);

		return res;
	}
	public static void main(String[] args) {
		E_0989_AddArrayFormInteger obj = new E_0989_AddArrayFormInteger();
		System.out.println(obj.addToArrayForm(new int[] {1,2,0,0}, 34));
	}
}
