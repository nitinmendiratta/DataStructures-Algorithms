package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */
public class E_1128_NumberEquivalentDominoPairs {

	/*
	You need to distinguish the different dominoes and count the same.

	f(domino) = min(d[0], d[1]) * 10 + max(d[0], d[1])
	For each domino d, calculate min(d[0], d[1]) * 10 + max(d[0], d[1])
	This will put the smaller number on the left and bigger one on the right (in decimal).
	So same number same domino, different number different domino.

	Take the example from the problem:
	dominoes = [[1,2],[2,1],[3,4],[5,6]]
	now we transform it into [12,12,34,56].


	We sum up the pair in the end after the loop,
	using the guass formula sum = v * (v + 1) / 2,
	where v is the number of count.
	Explanation on how to calculate pairs
	
	Let's say you have 3 dominoes - a, b, c and they match. You can pair them like this:

	a and b
	a and c
	b and c
	totally 3 combinations.

	Now let's say you have 4 - a, b, c, d that also match. You can pair them like this:

	a and b
	a and c
	a and d
	b and c
	b and d
	c and d
	totally 6 combinations.

	Mathematically, it can be calculated like N * (N - 1) / 2 where N is a number of dominoes.

	In the given solution the map contains a number of dominoes that match (by a certain key).
	In that part of code, we iterate through the map and calculate the number of combinations (using the above formula) for every number of matching dominoes.
	 */

	public int numEquivDominoPairs(int[][] dominoes) {
		Map<Integer, Integer> count = new HashMap<>();
		int res = 0;
		for (int[] d : dominoes) {
			int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
			count.put(k, count.getOrDefault(k, 0) + 1);
		}
		for (int v : count.values()) {
			res += v * (v - 1) / 2;
		}
		return res;
	}

	//bit modification [using prime numbers]
	public int numEquivDominoPairsApproach2(int[][] dominoes) {
		Map<Integer, Integer> count = new HashMap<>();
		int res = 0;
		int[] p =new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

		for(int[] d: dominoes){
			int prod = p[d[0]]*p[d[1]];
			count.put(prod,count.getOrDefault(prod,0)+1);
		}

		for(int v : count.values()){
			res += v*(v-1)/2;
		}
		return res;
	}

	//Another approach with bit modification
	public int numEquivDominoPairsApproach3(int[][] dominoes) {
		Map<Integer, Integer> count = new HashMap<>();
		int res = 0;

		for(int[] d: dominoes){
			int prod = 1<<d[0]| 1<<d[1];
			count.put(prod,count.getOrDefault(prod,0)+1);
		}

		for(int v : count.values()){
			res += v*(v-1)/2;
		}
		return res;
	}
	public static void main(String[] args) {
		E_1128_NumberEquivalentDominoPairs obj = new E_1128_NumberEquivalentDominoPairs();
		int[][] dominoes = new int[][] {
			{1,2},{2,1},{2,1}
		};
		System.out.println(obj.numEquivDominoPairs(dominoes));
	}
}
