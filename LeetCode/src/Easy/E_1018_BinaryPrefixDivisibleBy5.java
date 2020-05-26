package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */
public class E_1018_BinaryPrefixDivisibleBy5 {

	public List<Boolean> prefixesDivBy5(int[] A) {

		int k = 0;
		List<Boolean> ans = new ArrayList<>();
		for (int a : A) {
			k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
			ans.add(k == 0); 
		}
		return ans;
	}

	public boolean check(StringBuilder num){
		return Integer.parseInt(num.toString(), 2)%5 == 0;
	}
	public static void main(String[] args) {
		E_1018_BinaryPrefixDivisibleBy5 obj = new E_1018_BinaryPrefixDivisibleBy5();
		System.out.println(obj.prefixesDivBy5(new int[] {0,1,1}));
		System.out.println(obj.prefixesDivBy5(new int[] {1,1,1}));
		System.out.println(obj.prefixesDivBy5(new int[] {0,1,1,1,1,1}));
		System.out.println(obj.prefixesDivBy5(new int[] {1,1,1,0,1}));
		System.out.println(obj.prefixesDivBy5(new int[] {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
		System.out.println(obj.prefixesDivBy5(new int[] {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0}));
	}
}
