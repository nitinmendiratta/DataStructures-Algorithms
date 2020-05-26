package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class M_0386_LexicographicalNumbers {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList();

		lexicalOrderHelper(n, res, 0);
		return res;
	}

	public void lexicalOrderHelper(int n, List<Integer> res, int curr) {

		for (int i = 0; i < 10; i++) {

			int temp = 10 * curr + i;
			
			if(temp > n) return;
			
			if (temp > 0) {
				res.add(temp);
				lexicalOrderHelper(n, res, temp);
			}
		}
	}

	public static void main(String[] args) {
		M_0386_LexicographicalNumbers obj = new M_0386_LexicographicalNumbers();
		System.out.println(obj.lexicalOrder(25));

	}

}
