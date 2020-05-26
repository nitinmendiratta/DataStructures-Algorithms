package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/combinations/
 */
public class M_0077_Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList();

		combineHelper(n, k, res, new ArrayList<Integer>(), 1);
		return res;
	}

	public void combineHelper(int n, int k, List<List<Integer>> res, List<Integer> tempList, int start) {

		if(k == 0) {
			res.add(new ArrayList<Integer>(tempList));
			return;
		}

		for(int i = start; i <= n-k+1; i++) {
			tempList.add(i);
			combineHelper(n, k-1, res, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}

	// Iterative: Difficult to understand
	public List<List<Integer>> combineIterative(int n, int k) {
		List<List<Integer>> list = new LinkedList<>();
		list.add(new LinkedList<Integer>());
		
		for(; k > 0; k--){
			List<List<Integer>> next = new LinkedList<>();
			
			for(List<Integer> l : list){
				int start = l.isEmpty() ? 1 : l.get(l.size()-1) + 1;
				
				for(int j = start; j <= n-k+1; j++){
					l.add(j);
					next.add(new LinkedList<Integer>(l));
					l.remove(l.size()-1);
				}
			}
			list = next;
		}
		return list;
	}
	public static void main(String[] args) {
		M_0077_Combinations obj = new M_0077_Combinations();
		List<List<Integer>> res = obj.combine(4, 3);
		System.out.println(res);
	}
}
