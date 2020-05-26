package Heap_Hash;
/*
 * http://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
 * Time complexity of this solution is O(n)
 */
public class Hp12_CheckIfArrayRepresentsBinaryHeap {

	// Returns true if arr[i..n-1] represents a
	// max-heap
	boolean isHeap(int arr[], int i){
		int n = arr.length;
		// If a leaf node
		//System.out.println("n"+(n - 2)/2);
		if (i >= (n - 2)/2)
			return true;
		//System.out.println("i"+i);
		// If an internal node and is greater than its children, and
		// same is recursively true for the children
		if (arr[i] >= arr[2*i + 1]  &&  arr[i] >= arr[2*i + 2] &&
				isHeap(arr, 2*i + 1) && isHeap(arr, 2*i + 2))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Hp12_CheckIfArrayRepresentsBinaryHeap obj = new Hp12_CheckIfArrayRepresentsBinaryHeap();
		int arr[] = {90, 15, 10, 7, 12, 2};
		//int n = arr.length;

		if(obj.isHeap(arr,0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
