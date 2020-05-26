package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 */
public class E_1441_BuildArrayWithStackOperations {

	public List<String> buildArray(int[] target, int n) {
		int i = 1, j = 0;
		
		List<String> res = new ArrayList();
		
		while(j < target.length) {
			
			res.add("Push");
			if(i != target[j]) {
				res.add("Pop");
			}else {
				j++;
			}
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		E_1441_BuildArrayWithStackOperations obj = new E_1441_BuildArrayWithStackOperations();
		System.out.println(obj.buildArray(new int[] { 1, 3 }, 3));
		System.out.println(obj.buildArray(new int[] { 1, 2, 3 }, 3));
		System.out.println(obj.buildArray(new int[] { 1, 2 }, 4));
		System.out.println(obj.buildArray(new int[] { 2,3,4 }, 4));
	}
}
