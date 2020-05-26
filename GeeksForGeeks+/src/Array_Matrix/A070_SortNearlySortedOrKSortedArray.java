package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * 1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact)
2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.

Removing an element and adding a new element to min heap will take Logk time. So overall complexity will be 
O(k) + O((n-k)*logK) = O(nLogk) time and
uses O(k) auxiliary space.
 */
public class A070_SortNearlySortedOrKSortedArray {

	public int[] sort(int[] arr, int k ){
		int n = arr.length, i = 0, j = 0;
		int[] result = new int[n];
		PriorityQueue q = new PriorityQueue(k+1);

		while(i <= k){
			q.add(arr[i]);
			i++;
		}

		while(!q.isEmpty()){
			result[j] = (int) q.poll();
			j++;
			if(i < n){
				q.add(arr[i]);
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		A070_SortNearlySortedOrKSortedArray obj = new A070_SortNearlySortedOrKSortedArray();
		int[] arr = {2, 6, 3, 12, 56, 8};
		arr = obj.sort(arr,3);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
