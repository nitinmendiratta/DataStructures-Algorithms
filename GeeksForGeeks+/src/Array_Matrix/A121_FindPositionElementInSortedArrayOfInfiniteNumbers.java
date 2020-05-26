package Array_Matrix;
/* 
 * http://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * Let p be the position of element to be searched. Number of steps for finding high index ‘h’ is O(Log p). 
 * The value of ‘h’ must be less than 2*p. The number of elements between h/2 and h must be O(p). 
 * Therefore, time complexity of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log p) which is O(Log p).
 */
public class A121_FindPositionElementInSortedArrayOfInfiniteNumbers {
	// Simple binary search algorithm
	public int binarySearch(int arr[], int l, int r, int x) {
	    if (r>=l) {
	        int mid = l + (r - l)/2;
	        if (arr[mid] == x)
	            return mid;
	        if (arr[mid] > x)
	            return binarySearch(arr, l, mid-1, x);
	        return binarySearch(arr, mid+1, r, x);
	    }
	    return -1;
	}
	 
	// function takes an infinite size array and a key to be
	// searched and returns its position if found else -1.
	// We don't know size of arr[] and we can assume size to be
	// infinite in this function.
	// NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
	// THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING
	public int findPos(int arr[], int key){
	    int l = 0, h = 1;
	    int val = arr[0];
	 
	    // Find h to do binary search
	    while (val < key){
	        l = h;        // store previous high
	        h = 2*h;      // double high index
	        val = arr[h]; // update new val
	    }
	    // at this point we have updated low and high indices,
	    // thus use binary search between them
	    return binarySearch(arr, l, h, key);
	}
	
	public static void main(String[] args) {
		A121_FindPositionElementInSortedArrayOfInfiniteNumbers obj = new A121_FindPositionElementInSortedArrayOfInfiniteNumbers();
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
	    int ans = obj.findPos(arr, 10);
	    if (ans==-1)
	        System.out.println("Element not found");
	    else
	        System.out.println("Element found at index: "+ans);
	}
}
