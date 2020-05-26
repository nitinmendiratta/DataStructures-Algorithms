package Array_Matrix;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class A056_FindTripletThatSumToaValue {

	public int[] threeSum(int[] A, int x){
		int n = A.length;
		int l, r;
		int[] result = new int[3];
		/* Sort the elements */
		Arrays.sort(A);

		/* Now fix the first element one by one and find the other two elements */
		for (int i = 0; i < n - 2; i++){
			// To find the other two elements, start two index variables from two corners of the array and move them toward each other
			l = i + 1; // index of the first element in the remaining elements
			r = n-1; // index of the last element
			while (l < r){
				if( (A[i] + A[l] + A[r]) == x){
					result[0] = A[i];
					result[1] = A[l];
					result[2] = A[r];
					return result;
				}
				else if (A[i] + A[l] + A[r] < x)
					l++;
				else // A[i] + A[l] + A[r] > sum
					r--;
			}
		}
		// If we reach here, then no triplet was found
		return result;
	}

	public static void main(String[] args) {
		A056_FindTripletThatSumToaValue obj = new A056_FindTripletThatSumToaValue();
		int[] arr = {1, 4, 45, 6, 10, 8};
		arr = obj.threeSum(arr,22);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
