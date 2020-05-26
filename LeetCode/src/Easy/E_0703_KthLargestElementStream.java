package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class E_0703_KthLargestElementStream {
	
	// the idea here is to use priority queue which default creates a min heap, so the top element will always be smallest
	// in this case can specify size of queue so the queue will have utmost k elements
	PriorityQueue<Integer> pq;
	int k;
	public E_0703_KthLargestElementStream(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<Integer>();
		for(int n: nums) {
			add(n);
		}
	}

	public int add(int val) {
		pq.offer(val);
		// if size increases remove 1 element from queue
		if(pq.size() > k) {
			pq.poll();
		}
		return pq.peek();
	}
	public static void main(String[] args) {
		E_0703_KthLargestElementStream kthLargest = new E_0703_KthLargestElementStream(3, new int[] {4,5,8,2});
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
	}
}
