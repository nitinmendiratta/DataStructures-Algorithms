package Array_Matrix;
import java.util.*;
/*
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
 * Time Complexity: The main step is 3rd step, the loop runs n*k times. 
 * In every iteration of loop, we call heapify which takes O(Logk) time. 
 * Therefore, the time complexity is O(nk Logk).
 */

// A min heap node
class MinHeapNode{
	int data; // The element to be stored
	int i; // index of the array from which the element is taken
	int j; // index of the next element to be picked from array
	public MinHeapNode(int d,int i, int j){
		this.data = d;
		this.i = i;
		this.j = j;
	}
}

public class A098_MergekSortedArrays {

	// This function takes an array of arrays as an argument and All arrays are assumed to be sorted. 
	// It merges them together and prints the final sorted output.
	public int[] mergeKArrays(int arr[][], int k){
		int n = arr[k-1].length, i = 0;
		int[] output = new int[n*k];  // To store output array

		Queue<MinHeapNode> q = new PriorityQueue<MinHeapNode>(k, new Comparator<MinHeapNode>(){
			public int compare(MinHeapNode a, MinHeapNode b){
				return (a.data - b.data);
			}
		});
		for(i = 0;i<k;i++){
			MinHeapNode node  = new MinHeapNode(arr[i][0],i,0);
			q.add(node);
		}
		i = 0;
		while(!q.isEmpty()){	
			MinHeapNode temp = q.poll();
			output[i++] = temp.data;
			if(temp.j+1 < n){
				MinHeapNode node  = new MinHeapNode(arr[temp.i][temp.j+1],temp.i,temp.j+1);
				q.add(node);			
			}
		}
		return output;
	}

	// A utility function to print array elements
	void printArray(int arr[], int size){
		for (int i=0; i < size; i++)
			System.out.print(arr[i]+",");
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		A098_MergekSortedArrays obj = new A098_MergekSortedArrays();
		// Change n at the top to change number of elements in an array
		int arr[][] =  {{2, 6, 12, 34},
						{1, 9, 20, 1000},
						{23, 34, 90, 2000}
		};
		int[] output = obj.mergeKArrays(arr, 3);
		System.out.println("Merged array is ");
		obj.printArray(output, 12);
	}
}
