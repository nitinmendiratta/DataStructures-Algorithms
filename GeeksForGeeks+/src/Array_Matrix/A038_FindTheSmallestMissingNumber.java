package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-first-missing-number/
 * Note: This method doesn’t work if there are duplicate elements in the array.
 * Time Complexity: O(Logn)
 */
public class A038_FindTheSmallestMissingNumber {

	public int smallestMiss(int[] arr,int start,int end){

		int mid = (start+end)/2;
		if(start > end) return end+1;
		if(start != arr[start]) return start;

		if(arr[mid] > mid) 
			return smallestMiss(arr,start,mid);
		else
			return smallestMiss(arr,mid+1,end);
	}

	public static void main(String[] args) {
		A038_FindTheSmallestMissingNumber obj = new A038_FindTheSmallestMissingNumber();
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println("Missing numbr:"+obj.smallestMiss(arr,0,arr.length-1));
	}
}
