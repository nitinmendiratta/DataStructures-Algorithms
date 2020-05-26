package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/last-stone-weight/
 */
public class E_1046_LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int n: stones) {
			pq.offer(n);
		}
		
		while (pq.size() > 1) {
			int big = pq.poll();
			int small = pq.poll();
			int diff = big - small;
			if(diff > 0) {
				pq.offer(diff);
			}
		}
		return pq.size() == 0 ? 0 : pq.poll();
	}
	public static void main(String[] args) {
		E_1046_LastStoneWeight obj = new E_1046_LastStoneWeight();
		System.out.println(obj.lastStoneWeight(new int[] {2,7,4,1,100,1}));
	}
}
