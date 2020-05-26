package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/gray-code/
 */
public class M_0089_GrayCode {

	// No idea what is graycode
	public List<Integer> grayCode(int n) {
		int count = (int)Math.pow(2,n);
	    List<Integer> res = new ArrayList<>();
	    for(int i = 0; i < count; i++){
	        res.add((i) ^ (i >> 1));
	    }
	    return res;
	}
	
	// Backtracking
	public List<Integer> grayCodeApproach2(int n) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		list.add(0);

		helper(result, list, n);
		return result;
	}
	public void helper(List<Integer> result,List<Integer> list,int n){

		if(list.size() == Math.pow(2,n)){
			result.addAll(list);
			return;
		}
		int last = list.get(list.size() - 1);

		for(int i = 0; i < n; i++){
			int cur = last ^ (1 >> i);

			if(list.contains(cur)) continue;

			list.add(cur);
			helper(result,list,n);

			if(result.size() > 0) return;
			list.remove(list.size() - 1);
		}

	} 
	public static void main(String[] args) {
		M_0089_GrayCode obj = new M_0089_GrayCode();
		System.out.println(obj.grayCode(0));
	}
}
