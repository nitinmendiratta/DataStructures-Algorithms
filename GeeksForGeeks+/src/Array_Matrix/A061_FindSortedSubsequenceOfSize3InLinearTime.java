package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 * Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. 
 * If there are multiple such triplets, then print any one of them.
 * 
 * 1) Create an auxiliary array smaller[0..n-1]. smaller[i] should store the index of a number which is smaller than arr[i] 
 * and is on left side of arr[i]. smaller[i] should contain -1 if there is no such element.
 * 2) Create another auxiliary array greater[0..n-1]. greater[i] should store the index of a number 
 * which is greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no such element.
 * 3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i] are not -1.
 */
 
public class A061_FindSortedSubsequenceOfSize3InLinearTime {

	public int[] sortedSubsequence(int[] arr){
		int[] result = new int[3];
		int n = arr.length, i = 0, 
				min = 0, //Index of minimum element from left side
				max = n-1;//Index of maximum element from right side
		
		// Create an array that will store index of a smaller
        // element on left side. If there is no smaller element
        // on left side, then smaller[i] will be -1.
		int[] smaller = new int[n];
		smaller[0] = -1; // first entry will always be -1
		
		for(i = 1;i < n;i++){
			if (arr[i] <= arr[min]){
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
		}
		
		// Create another array that will store index of a
        // greater element on right side. If there is no greater
        // element on right side, then greater[i] will be -1.
		int[] larger = new int[n];
		larger[n-1] = -1; // last entry will always be -1
		
		for(i = n-2;i >= 0;i--){
			 if (arr[i] >= arr[max]){
	                max = i;
	                larger[i] = -1;
	            }
	            else
	            	larger[i] = max;
		}
		
		// Now find a number which has both a greater number
        // on right side and smaller number on left side
		for(i = 0;i < n;i++){
			if(smaller[i] != -1 && larger[i] != -1){
				result[0] = arr[smaller[i]];
				result[1] = arr[i];
				result[2] = arr[larger[i]];
				return result;
			}
		}
		System.out.println("No such triplet");
		// throw exception
		return result;
	}
	
	public static void main(String[] args) {
		A061_FindSortedSubsequenceOfSize3InLinearTime obj = new A061_FindSortedSubsequenceOfSize3InLinearTime();
		int[] arr = {1, 2, 3, 4};
		int[] result = obj.sortedSubsequence(arr);
		System.out.println("3 sorted elems are:"+result[0]+","+result[1]+","+result[2]);
	}
}
