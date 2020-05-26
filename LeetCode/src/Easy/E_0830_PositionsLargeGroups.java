package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class E_0830_PositionsLargeGroups {

	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int start = 0, end = 0, i = 1;

		while(i < S.length()){

			if(S.charAt(i) != S.charAt(i-1)){
				if(end - start >= 2){
					res.add(Arrays.asList(new Integer[]{start, end}));
				}
				start = i;
			}
			end = i++;
		}
		// case when last char is a repeating char
		if(end - start >= 2){
			res.add(Arrays.asList(new Integer[]{start, end}));
		}
		return res;
	}

	public static void main(String[] args) {
		E_0830_PositionsLargeGroups obj = new E_0830_PositionsLargeGroups();
		List<List<Integer>> output = obj.largeGroupPositions("aaaaaaaaaaaaaabbbbbccdddeeeeaabbb");
		System.out.println(output);
	}
}
