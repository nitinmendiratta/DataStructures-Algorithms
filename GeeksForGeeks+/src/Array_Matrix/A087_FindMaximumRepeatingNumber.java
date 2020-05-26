package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 */

public class A087_FindMaximumRepeatingNumber {

	public int max(int[] arr, int k){
		int n = arr.length;
		// Iterate though input array, for every element arr[i], increment arr[arr[i]%k] by k
		for (int i = 0; i< n; i++)
			arr[arr[i]%k] += k;

		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++){
			if (arr[i] > max){
				max = arr[i];
				result = i;
			}
		}
		// code to get the original array back
       for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k;
          
		// Return index of the maximum element
		return result;
	}

	public static void main(String[] args) {
		A087_FindMaximumRepeatingNumber obj = new A087_FindMaximumRepeatingNumber();
		int[] arr = {2, 3, 3, 5, 3, 4, 1, 7};
		System.out.println("max elem is:"+obj.max(arr,9));
	}
}
