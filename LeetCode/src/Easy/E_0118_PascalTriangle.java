package Easy;
import java.util.*;

/*
 * https://oj.leetcode.com/problems/pascals-triangle/
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	[1,5,10,10,5,1]
]
 */
public class E_0118_PascalTriangle {

	public  List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList();
		if(numRows == 0) return result;
		List<Integer> prev = new ArrayList();
		prev.add(1);
		result.add(prev);

		for(int i = 1; i < numRows; i++){
			prev = result.get(i-1);
			List<Integer> next = new ArrayList();
			next.add(1);
			for(int j = 0; j < i-1; j++){
                int sum = (int)prev.get(j) + (int)prev.get(j+1);
				next.add(sum);
            }
			next.add(1);
			result.add(next);
		}
		return result;
	}

	public static void main(String[] args) {
		E_0118_PascalTriangle obj = new E_0118_PascalTriangle();
		List<List<Integer>> result = obj.generate(1);
		for(List a : result){
			System.out.println(a);
		}
	}
}
