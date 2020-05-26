package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class E_0933_NumberOfRecentCalls {

	Queue<Integer> q;
    public E_0933_NumberOfRecentCalls() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
	

    // my approach
    ArrayList<Integer> list;
   	int start = 0;
   	public void RecentCounter() {
   		list = new ArrayList<Integer>();
   	}

   	public int pingMyApproach(int t) {
   		list.add(t);
   		while(list.get(start) < t - 3000) start++;
   		return list.size() - start;
   	}
   	
	public static void main(String[] args) {
		E_0933_NumberOfRecentCalls obj = new E_0933_NumberOfRecentCalls();
		System.out.println(obj.ping(1));
		System.out.println(obj.ping(100));
		System.out.println(obj.ping(3001));
		System.out.println(obj.ping(3002));
		System.out.println(obj.ping(6005));
	}
}
