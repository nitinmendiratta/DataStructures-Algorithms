package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * http://leetcode.com/2011/01/sliding-window-maximum.html
 * Time complexity: O(n)
 */
public class A042_MaxOfAllSubArraysOfSizeK {

	public int[] max(int[] arr, int k){
		int n = arr.length;
		int[] b = new int[n-k+1];
		// Create a Double Ended Queue, Qi that will store indexes of array elements
		// The queue will store indexes of useful elements in every window and it will
		// maintain decreasing order of values from front to rear in Qi, i.e., 
		// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
		Deque<Integer> Qi = new LinkedList<Integer>();

		/* Process first k (or first window) elements of array */
		int i;
		for (i = 0; i < k; ++i){
			// For very element, the previous smaller elements are useless so remove them from Qi
			while ( (!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.pollLast() ;  // Remove from rear

			// Add new element at rear of queue
			Qi.addLast(i);
		}
		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for ( ; i < n; ++i){
			// The element at the front of the queue is the largest element of previous window, so print it
			b[i-k] = arr[Qi.getFirst()];

			// Remove the elements which are out of this window
			while ( (!Qi.isEmpty()) && Qi.getFirst() <= i - k)
				Qi.pollFirst();  // Remove from front of queue

			// Remove all elements smaller than the currently being added element (remove useless elements)
			while ( (!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.pollLast();

			// Add current element at the rear of Qi
			Qi.addLast(i);
		}
		// Print the maximum element of last window
		b[i-k] = arr[Qi.getFirst()];
		return b;
	}

	public static void main(String[] args) {
		A042_MaxOfAllSubArraysOfSizeK obj = new A042_MaxOfAllSubArraysOfSizeK();
		int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
		arr = obj.max(arr,3);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
