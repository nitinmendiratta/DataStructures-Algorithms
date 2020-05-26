package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */

public class A039_CountNumberOfOccurrencesInSortedArray {

	public int countOccurrences(int[] arr,int x){
		int n = arr.length;

		int first = firstIndex(arr,0,n-1,x);
		int last = lastIndex(arr,0,n-1,x);
		return (last-first+1);
	}

	public int firstIndex(int[] arr,int start, int end, int x){
		if(end >= start){
			int mid = (start+end)/2;
			if((mid == 0) || (arr[mid] == x) && x > (arr[mid-1])){
				return mid;
			}
			else if(x > arr[mid]){
				return firstIndex(arr, mid+1,end,x);
			}
			else {
				return firstIndex(arr,start,mid-1,x);
			}
		}
		return -1;
	}

	public int lastIndex(int[] arr,int start, int end, int x){
		int n = arr.length;
		if(end >= start){
			int mid = (start+end)/2;
			if((mid == n-1) || (arr[mid] == x) && (x < arr[mid+1])){
				return mid;
			}
			else if(x < arr[mid]){
				return lastIndex(arr,start,mid-1,x);
			}
			else{
				return lastIndex(arr, mid+1,end,x);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		A039_CountNumberOfOccurrencesInSortedArray obj = new A039_CountNumberOfOccurrencesInSortedArray();
		int[] arr = {1, 2, 2, 3, 3, 3, 3};
		System.out.println("count numbr:"+obj.countOccurrences(arr,2));
	}
}
