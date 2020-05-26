package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 */
public class A049_FindMaxElementInAnArrayWhichIsFirstIncreasingAndThenDecreasing {

	public int max(int[] arr, int low, int high){
		/* Base Case: Only one element is present in arr[low..high]*/
		if(low == high) return arr[low];
		
		/* If there are two elements and first is greater then the first element is maximum */
		if((high == (low+1)) && (arr[high] >= arr[low])) return arr[high];
		if((high == (low+1)) && (arr[high] < arr[low])) return arr[low];
		
		int mid = (high+low)/2;
		/* If we reach a point where arr[mid] is greater than both of its adjacent elements arr[mid-1] and arr[mid+1], 
		 * then arr[mid] is the maximum element*/
		if((arr[mid] > arr[mid-1]) && (arr[mid] > arr[mid+1])) return arr[mid];
		else if((arr[mid] > arr[mid-1]) && (arr[mid] < arr[mid+1])) return max(arr, mid+1, high);
		else return max(arr, low, mid-1);
	}
	
	public static void main(String[] args) {
		A049_FindMaxElementInAnArrayWhichIsFirstIncreasingAndThenDecreasing obj = new A049_FindMaxElementInAnArrayWhichIsFirstIncreasingAndThenDecreasing();
		int[] arr = {1, 3, 50, 10, 9, 7, 6};
		System.out.println("max is:"+obj.max(arr,0,arr.length-1));
	}
}
