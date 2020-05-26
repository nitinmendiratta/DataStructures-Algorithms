package Easy;
import java.util.*;

/**
 * https://leetcode.com/problems/happy-number/
 * https://www.geeksforgeeks.org/happy-number/
 */
public class E_0202_HappyNumber {
	Set<Integer> numberSet = new HashSet();
	public boolean isHappy(int n) {
		numberSet.add(n);
		int sum = 0;
		while(n > 0){
			sum += Math.pow(n%10, 2);
			n = n/10;
		}
		if(sum == 1) return true;
		if(numberSet.contains(sum)) return false;
		return isHappy(sum);
	}
	public static void main(String[] args) {
		E_0202_HappyNumber obj = new E_0202_HappyNumber();
		System.out.println(obj.isHappy(19));
	}
}
