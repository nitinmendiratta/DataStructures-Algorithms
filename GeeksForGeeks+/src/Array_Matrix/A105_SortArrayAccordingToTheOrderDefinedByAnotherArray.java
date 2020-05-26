package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 * Time complexity: 
 * The steps 1 and 2 require O(m) time. 
 * Step 3 requires O(mLogm) time. Step 5 requires O(nLogm) time. 
 * Therefore overall time complexity is O(m + nLogm).
 */
public class A105_SortArrayAccordingToTheOrderDefinedByAnotherArray {
	// Sort A1[0..m-1] according to the order defined by A2[0..n-1].
	public void sortAccording(int A1[], int A2[]){
		int m = A1.length;
		int n = A2.length;
		// The temp array is used to store a copy of A1[] and visited[] is used mark the visited elements in temp[].
		int temp[] = new int[m];
		int visited[] = new int[m];
		for (int i = 0; i < m; i++){
			temp[i] = A1[i];
			visited[i] = 0;
		}
		// Sort elements in temp
		Arrays.sort(temp);
		int ind = 0;  // for index of output which is sorted A1[]
		// Consider all elements of A2[], find them in temp[] and copy to A1[] in order.
		for (int i = 0; i < n; i++){
			// Find index of the first occurrence of A2[i] in temp
			int f = first(temp, 0, m-1, A2[i], m);
			// If not present, no need to proceed
			if (f == -1) continue;
			// Copy all occurrences of A2[i] to A1[]
			for (int j = f; (j < m && temp[j] == A2[i]); j++){
				A1[ind++] = temp[j];
				visited[j] = 1;
			}
		}
		// Now copy all items of temp[] which are not present in A2[]
		for (int i = 0; i < m; i++)
			if (visited[i] == 0)
				A1[ind++] = temp[i];
	}

	// A Binary Search based function to find index of FIRST occurrence of x in arr[].  If x is not present, then it returns -1 
	int first(int arr[], int low, int high, int x, int n){
		if (high >= low){
			int mid = low + (high-low)/2;  /* (low + high)/2; */
			if ((mid == 0 || x > arr[mid-1]) && arr[mid] == x)
				return mid;
			if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			return first(arr, low, (mid -1), x, n);
		}
		return -1;
	}

	public static void main(String[] args) {
		A105_SortArrayAccordingToTheOrderDefinedByAnotherArray obj = new A105_SortArrayAccordingToTheOrderDefinedByAnotherArray();
		int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int A2[] = {2, 1, 8, 3};
		obj.sortAccording(A1, A2);
		for(int i = 0; i < A1.length;i++){
			System.out.print(A1[i]+",");
		}
	}
}
